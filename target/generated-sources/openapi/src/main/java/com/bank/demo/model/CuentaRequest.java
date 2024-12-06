package com.bank.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CuentaRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T08:10:11.580573300-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public class CuentaRequest {

  /**
   * Gets or Sets tipoCuenta
   */
  public enum TipoCuentaEnum {
    AHORROS("AHORROS"),
    
    CORRIENTE("CORRIENTE");

    private String value;

    TipoCuentaEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoCuentaEnum fromValue(String value) {
      for (TipoCuentaEnum b : TipoCuentaEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TipoCuentaEnum tipoCuenta;

  private Integer clienteId;

  public CuentaRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CuentaRequest(TipoCuentaEnum tipoCuenta, Integer clienteId) {
    this.tipoCuenta = tipoCuenta;
    this.clienteId = clienteId;
  }

  public CuentaRequest tipoCuenta(TipoCuentaEnum tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
    return this;
  }

  /**
   * Get tipoCuenta
   * @return tipoCuenta
   */
  @NotNull 
  @Schema(name = "tipoCuenta", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tipoCuenta")
  public TipoCuentaEnum getTipoCuenta() {
    return tipoCuenta;
  }

  public void setTipoCuenta(TipoCuentaEnum tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public CuentaRequest clienteId(Integer clienteId) {
    this.clienteId = clienteId;
    return this;
  }

  /**
   * Get clienteId
   * @return clienteId
   */
  @NotNull 
  @Schema(name = "clienteId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("clienteId")
  public Integer getClienteId() {
    return clienteId;
  }

  public void setClienteId(Integer clienteId) {
    this.clienteId = clienteId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CuentaRequest cuentaRequest = (CuentaRequest) o;
    return Objects.equals(this.tipoCuenta, cuentaRequest.tipoCuenta) &&
        Objects.equals(this.clienteId, cuentaRequest.clienteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoCuenta, clienteId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CuentaRequest {\n");
    sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
    sb.append("    clienteId: ").append(toIndentedString(clienteId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

