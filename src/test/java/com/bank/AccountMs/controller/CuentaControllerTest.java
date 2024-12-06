package com.bank.AccountMs.controller;

import com.bank.AccountMs.exception.CuentaException;
import com.bank.AccountMs.model.Cuenta;
import com.bank.AccountMs.model.TipoCuenta;
import com.bank.AccountMs.model.Transaccion;
import com.bank.AccountMs.service.CuentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CuentaControllerTest {

    @Mock
    private CuentaService cuentaService;

    @InjectMocks
    private CuentaController cuentaController;

    private Cuenta cuenta;
    private Transaccion transaccion;

    @BeforeEach
    void setUp() {
        cuenta = Cuenta.builder()
                .id(1)
                .numeroCuenta("1234567890")
                .saldo(1000.0)
                .tipoCuenta(TipoCuenta.AHORROS)
                .clienteId(1)
                .build();

        transaccion = new Transaccion();
        transaccion.setMonto(500.0);
    }

    @Test
    void crearCuenta_DatosValidos_RetornaCuentaCreada() {
        when(cuentaService.crearCuenta(any(Cuenta.class))).thenReturn(cuenta);

        ResponseEntity<Cuenta> response = cuentaController.crearCuenta(cuenta);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(cuenta.getNumeroCuenta(), response.getBody().getNumeroCuenta());
    }

    @Test
    void listarCuentas_RetornaTodasLasCuentas() {
        List<Cuenta> cuentas = Arrays.asList(cuenta);
        when(cuentaService.listarCuentas()).thenReturn(cuentas);

        ResponseEntity<List<Cuenta>> response = cuentaController.listarCuentas(null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void listarCuentas_PorClienteId_RetornaCuentasDelCliente() {
        List<Cuenta> cuentas = Arrays.asList(cuenta);
        when(cuentaService.listarCuentasPorClienteId(1)).thenReturn(cuentas);

        ResponseEntity<List<Cuenta>> response = cuentaController.listarCuentas(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    void obtenerCuenta_CuentaExiste_RetornaCuenta() {
        when(cuentaService.obtenerCuentaPorId(1)).thenReturn(cuenta);

        ResponseEntity<Cuenta> response = cuentaController.obtenerCuenta(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(cuenta.getId(), response.getBody().getId());
    }

    @Test
    void depositarDinero_MontoValido_RetornaCuentaActualizada() {
        when(cuentaService.depositarDinero(eq(1), any(Double.class))).thenReturn(cuenta);

        ResponseEntity<Cuenta> response = cuentaController.depositarDinero(1, transaccion);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void retirarDinero_MontoValido_RetornaCuentaActualizada() {
        when(cuentaService.retirarDinero(eq(1), any(Double.class))).thenReturn(cuenta);

        ResponseEntity<Cuenta> response = cuentaController.retirarDinero(1, transaccion);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void eliminarCuenta_CuentaExiste_RetornaNoContent() {
        doNothing().when(cuentaService).eliminarCuenta(1);

        ResponseEntity<Void> response = cuentaController.eliminarCuenta(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}