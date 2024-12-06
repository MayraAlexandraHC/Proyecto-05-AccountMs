package com.bank.AccountMs.excepction;

import com.bank.AccountMs.exception.CuentaException;
import com.bank.AccountMs.exception.GlobalExceptionHandler;
import com.bank.AccountMs.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;

    @Mock
    private BindingResult bindingResult;

    @Test
    void handleCuentaException_RetornaErrorResponse() {
        CuentaException exception = new CuentaException("Error de prueba");

        ResponseEntity<GlobalExceptionHandler.ErrorResponse> response = exceptionHandler.handleCuentaException(exception);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Error de prueba", response.getBody().getMessage());
    }

    @Test
    void handleSaldoInsuficienteException_RetornaErrorResponse() {
        SaldoInsuficienteException exception = new SaldoInsuficienteException("Saldo insuficiente");

        ResponseEntity<GlobalExceptionHandler.ErrorResponse> response = exceptionHandler.handleSaldoInsuficienteException(exception);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Saldo insuficiente", response.getBody().getMessage());
    }



}