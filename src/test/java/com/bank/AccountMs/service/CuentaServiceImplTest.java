package com.bank.AccountMs.service;

import com.bank.AccountMs.client.ClienteClient;
import com.bank.AccountMs.exception.CuentaException;
import com.bank.AccountMs.exception.SaldoInsuficienteException;
import com.bank.AccountMs.model.Cuenta;
import com.bank.AccountMs.model.TipoCuenta;
import com.bank.AccountMs.repository.CuentaRepository;
import com.bank.AccountMs.service.impl.CuentaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuentaServiceImplTest {

    @Mock
    private CuentaRepository cuentaRepository;

    @Mock
    private ClienteClient clienteClient;

    @InjectMocks
    private CuentaServiceImpl cuentaService;

    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        cuenta = Cuenta.builder()
                .id(1)
                .numeroCuenta("1234567890")
                .saldo(1000.0)
                .tipoCuenta(TipoCuenta.AHORROS)
                .clienteId(1)
                .build();
    }

    @Test
    void crearCuenta_DatosValidos_RetornaCuentaCreada() {
        Cuenta nuevaCuenta = Cuenta.builder()
                .tipoCuenta(TipoCuenta.AHORROS)
                .clienteId(1)
                .build();

        Cuenta cuentaCreada = Cuenta.builder()
                .id(1)
                .numeroCuenta("1234567890")
                .saldo(0.0)
                .tipoCuenta(TipoCuenta.AHORROS)
                .clienteId(1)
                .build();

        when(clienteClient.existeCliente(1)).thenReturn(true);
        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuentaCreada);

        Cuenta resultado = cuentaService.crearCuenta(nuevaCuenta);

        assertNotNull(resultado);
        assertNotNull(resultado.getNumeroCuenta());
        assertEquals(0.0, resultado.getSaldo());
        verify(cuentaRepository).save(any(Cuenta.class));
    }

    @Test
    void crearCuenta_ClienteNoExiste_LanzaExcepcion() {
        Cuenta nuevaCuenta = Cuenta.builder()
                .tipoCuenta(TipoCuenta.AHORROS)
                .clienteId(1)
                .build();

        when(clienteClient.existeCliente(1)).thenReturn(false);

        assertThrows(CuentaException.class, () -> cuentaService.crearCuenta(nuevaCuenta));
        verify(cuentaRepository, never()).save(any());
    }

    @Test
    void depositarDinero_MontoPositivo_ActualizaSaldo() {
        when(cuentaRepository.findById(1)).thenReturn(Optional.of(cuenta));
        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        Cuenta resultado = cuentaService.depositarDinero(1, 500.0);

        assertEquals(1500.0, resultado.getSaldo());
        verify(cuentaRepository).save(any(Cuenta.class));
    }

    @Test
    void depositarDinero_MontoNegativo_LanzaExcepcion() {
        assertThrows(CuentaException.class, () ->
                cuentaService.depositarDinero(1, -100.0));

        verify(cuentaRepository, never()).save(any());
    }

    @Test
    void retirarDinero_CuentaAhorros_SaldoSuficiente_RealizaRetiro() {
        when(cuentaRepository.findById(1)).thenReturn(Optional.of(cuenta));
        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        Cuenta resultado = cuentaService.retirarDinero(1, 500.0);

        assertEquals(500.0, resultado.getSaldo());
    }

    @Test
    void retirarDinero_CuentaAhorros_SaldoInsuficiente_LanzaExcepcion() {
        when(cuentaRepository.findById(1)).thenReturn(Optional.of(cuenta));

        assertThrows(SaldoInsuficienteException.class, () ->
                cuentaService.retirarDinero(1, 2000.0));
    }

    @Test
    void retirarDinero_CuentaCorriente_PermiteSobregiro() {
        cuenta.setTipoCuenta(TipoCuenta.CORRIENTE);
        when(cuentaRepository.findById(1)).thenReturn(Optional.of(cuenta));
        when(cuentaRepository.save(any(Cuenta.class))).thenReturn(cuenta);

        Cuenta resultado = cuentaService.retirarDinero(1, 1400.0);

        assertEquals(-400.0, resultado.getSaldo());
    }

    @Test
    void retirarDinero_CuentaCorriente_ExcedeSobregiro_LanzaExcepcion() {
        cuenta.setTipoCuenta(TipoCuenta.CORRIENTE);
        when(cuentaRepository.findById(1)).thenReturn(Optional.of(cuenta));

        assertThrows(SaldoInsuficienteException.class, () ->
                cuentaService.retirarDinero(1, 2000.0));
    }

    @Test
    void listarCuentas_RetornaTodasLasCuentas() {
        when(cuentaRepository.findAll()).thenReturn(Arrays.asList(cuenta));

        List<Cuenta> resultado = cuentaService.listarCuentas();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
    }

    @Test
    void listarCuentasPorClienteId_RetornaCuentasDelCliente() {
        when(cuentaRepository.findByClienteId(1)).thenReturn(Arrays.asList(cuenta));

        List<Cuenta> resultado = cuentaService.listarCuentasPorClienteId(1);

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.size());
        assertEquals(1, resultado.get(0).getClienteId());
    }

    @Test
    void obtenerCuentaPorId_CuentaExiste_RetornaCuenta() {
        when(cuentaRepository.findById(1)).thenReturn(Optional.of(cuenta));

        Cuenta resultado = cuentaService.obtenerCuentaPorId(1);

        assertNotNull(resultado);
        assertEquals(cuenta.getId(), resultado.getId());
    }

    @Test
    void obtenerCuentaPorId_CuentaNoExiste_LanzaExcepcion() {
        when(cuentaRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(CuentaException.class, () ->
                cuentaService.obtenerCuentaPorId(999));
    }

    @Test
    void eliminarCuenta_CuentaExiste_EliminaCuenta() {
        when(cuentaRepository.findById(1)).thenReturn(Optional.of(cuenta));
        doNothing().when(cuentaRepository).delete(cuenta);

        cuentaService.eliminarCuenta(1);

        verify(cuentaRepository).delete(cuenta);
    }

    @Test
    void eliminarCuenta_CuentaNoExiste_LanzaExcepcion() {
        when(cuentaRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(CuentaException.class, () ->
                cuentaService.eliminarCuenta(999));
    }
}