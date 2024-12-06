package com.bank.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TransaccionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T08:10:11.580573300-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public class TransaccionRequest {

  private Double monto;

  public TransaccionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TransaccionRequest(Double monto) {
    this.monto = monto;
  }

  public TransaccionRequest monto(Double monto) {
    this.monto = monto;
    return this;
  }

  /**
   * Monto de la transacción
   * minimum: 0.01
   * @return monto
   */
  @NotNull @DecimalMin("0.01") 
  @Schema(name = "monto", description = "Monto de la transacción", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("monto")
  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransaccionRequest transaccionRequest = (TransaccionRequest) o;
    return Objects.equals(this.monto, transaccionRequest.monto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(monto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransaccionRequest {\n");
    sb.append("    monto: ").append(toIndentedString(monto)).append("\n");
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

