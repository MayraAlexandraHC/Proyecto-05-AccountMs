package com.bank.AccountMs.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteClientTest {

    @Mock
    private RestTemplate restTemplate;

    @Value("${customerms.url}")
    private String customerMsUrl;

    @InjectMocks
    private ClienteClient clienteClient;

    @Test
    void existeCliente_ClienteExiste_RetornaTrue() {
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn("{}");

        boolean resultado = clienteClient.existeCliente(1);

        assertTrue(resultado);
    }

    @Test
    void existeCliente_ClienteNoExiste_RetornaFalse() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        boolean resultado = clienteClient.existeCliente(1);

        assertFalse(resultado);
    }

    @Test
    void existeCliente_ErrorComunicacion_RetornaFalse() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenThrow(new RestClientException("Error de comunicación"));

        boolean resultado = clienteClient.existeCliente(1);

        assertFalse(resultado);
    }

    @Test
    void existeCliente_TimeoutError_RetornaFalse() {
        when(restTemplate.getForObject(anyString(), eq(String.class)))
                .thenThrow(new ResourceAccessException("Timeout"));

        boolean resultado = clienteClient.existeCliente(1);

        assertFalse(resultado);
    }
}
