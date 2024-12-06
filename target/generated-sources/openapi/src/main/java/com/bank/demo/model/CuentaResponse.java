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
 * CuentaResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T08:10:11.580573300-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public class CuentaResponse {

  private Integer id;

  private String numeroCuenta;

  private Double saldo;

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

  public CuentaResponse id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CuentaResponse numeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
    return this;
  }

  /**
   * Get numeroCuenta
   * @return numeroCuenta
   */
  
  @Schema(name = "numeroCuenta", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numeroCuenta")
  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public CuentaResponse saldo(Double saldo) {
    this.saldo = saldo;
    return this;
  }

  /**
   * Get saldo
   * @return saldo
   */
  
  @Schema(name = "saldo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("saldo")
  public Double getSaldo() {
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }

  public CuentaResponse tipoCuenta(TipoCuentaEnum tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
    return this;
  }

  /**
   * Get tipoCuenta
   * @return tipoCuenta
   */
  
  @Schema(name = "tipoCuenta", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tipoCuenta")
  public TipoCuentaEnum getTipoCuenta() {
    return tipoCuenta;
  }

  public void setTipoCuenta(TipoCuentaEnum tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  public CuentaResponse clienteId(Integer clienteId) {
    this.clienteId = clienteId;
    return this;
  }

  /**
   * Get clienteId
   * @return clienteId
   */
  
  @Schema(name = "clienteId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    CuentaResponse cuentaResponse = (CuentaResponse) o;
    return Objects.equals(this.id, cuentaResponse.id) &&
        Objects.equals(this.numeroCuenta, cuentaResponse.numeroCuenta) &&
        Objects.equals(this.saldo, cuentaResponse.saldo) &&
        Objects.equals(this.tipoCuenta, cuentaResponse.tipoCuenta) &&
        Objects.equals(this.clienteId, cuentaResponse.clienteId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, numeroCuenta, saldo, tipoCuenta, clienteId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CuentaResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
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

