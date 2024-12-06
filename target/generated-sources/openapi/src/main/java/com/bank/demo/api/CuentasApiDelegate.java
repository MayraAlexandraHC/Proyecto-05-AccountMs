package com.bank.demo.api;

import com.bank.demo.model.CuentaRequest;
import com.bank.demo.model.CuentaResponse;
import com.bank.demo.model.ErrorResponse;
import com.bank.demo.model.TransaccionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link CuentasApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T08:10:11.580573300-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public interface CuentasApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /cuentas : Crear una nueva cuenta
     *
     * @param cuentaRequest  (required)
     * @return Cuenta creada exitosamente (status code 201)
     *         or Error de validación (status code 400)
     * @see CuentasApi#crearCuenta
     */
    default ResponseEntity<CuentaResponse> crearCuenta(CuentaRequest cuentaRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : 1, \"tipoCuenta\" : \"AHORROS\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : 0, \"saldo\" : 6.027456183070403 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /cuentas/{cuentaId}/depositar : Realizar un depósito
     *
     * @param cuentaId  (required)
     * @param transaccionRequest  (required)
     * @return Depósito realizado exitosamente (status code 200)
     *         or Error en la transacción (status code 400)
     * @see CuentasApi#depositarDinero
     */
    default ResponseEntity<CuentaResponse> depositarDinero(Integer cuentaId,
        TransaccionRequest transaccionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : 1, \"tipoCuenta\" : \"AHORROS\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : 0, \"saldo\" : 6.027456183070403 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /cuentas/{id} : Eliminar una cuenta
     *
     * @param id  (required)
     * @return Cuenta eliminada exitosamente (status code 204)
     *         or Error al eliminar cuenta (status code 400)
     * @see CuentasApi#eliminarCuenta
     */
    default ResponseEntity<Void> eliminarCuenta(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /cuentas : Listar todas las cuentas
     *
     * @param clienteId  (optional)
     * @return Lista de cuentas (status code 200)
     * @see CuentasApi#listarCuentas
     */
    default ResponseEntity<List<CuentaResponse>> listarCuentas(Integer clienteId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"clienteId\" : 1, \"tipoCuenta\" : \"AHORROS\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : 0, \"saldo\" : 6.027456183070403 }, { \"clienteId\" : 1, \"tipoCuenta\" : \"AHORROS\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : 0, \"saldo\" : 6.027456183070403 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /cuentas/{id} : Obtener detalles de una cuenta por ID
     *
     * @param id  (required)
     * @return Detalles de la cuenta (status code 200)
     *         or Cuenta no encontrada (status code 404)
     * @see CuentasApi#obtenerCuenta
     */
    default ResponseEntity<CuentaResponse> obtenerCuenta(Integer id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : 1, \"tipoCuenta\" : \"AHORROS\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : 0, \"saldo\" : 6.027456183070403 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /cuentas/{cuentaId}/retirar : Realizar un retiro
     *
     * @param cuentaId  (required)
     * @param transaccionRequest  (required)
     * @return Retiro realizado exitosamente (status code 200)
     *         or Error en la transacción (status code 400)
     * @see CuentasApi#retirarDinero
     */
    default ResponseEntity<CuentaResponse> retirarDinero(Integer cuentaId,
        TransaccionRequest transaccionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"clienteId\" : 1, \"tipoCuenta\" : \"AHORROS\", \"numeroCuenta\" : \"numeroCuenta\", \"id\" : 0, \"saldo\" : 6.027456183070403 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"message\" : \"message\", \"timestamp\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
