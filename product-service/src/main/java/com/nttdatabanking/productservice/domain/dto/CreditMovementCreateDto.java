package com.nttdatabanking.productservice.domain.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreditMovementCreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T16:34:21.491983300-05:00[America/Lima]")
public class CreditMovementCreateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String creditId;

  private String description;

  private String movementType;

  private Double amount;

  /**
   * Default constructor
   * @deprecated Use {@link CreditMovementCreateDto#CreditMovementCreateDto(String, String, String, Double)}
   */
  @Deprecated
  public CreditMovementCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreditMovementCreateDto(String creditId, String description, String movementType, Double amount) {
    this.creditId = creditId;
    this.description = description;
    this.movementType = movementType;
    this.amount = amount;
  }

  public CreditMovementCreateDto creditId(String creditId) {
    this.creditId = creditId;
    return this;
  }

  /**
   * Get creditId
   * @return creditId
  */
  @NotNull 
  @Schema(name = "creditId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("creditId")
  public String getCreditId() {
    return creditId;
  }

  public void setCreditId(String creditId) {
    this.creditId = creditId;
  }

  public CreditMovementCreateDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @NotNull 
  @Schema(name = "description", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreditMovementCreateDto movementType(String movementType) {
    this.movementType = movementType;
    return this;
  }

  /**
   * Get movementType
   * @return movementType
  */
  @NotNull 
  @Schema(name = "movementType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("movementType")
  public String getMovementType() {
    return movementType;
  }

  public void setMovementType(String movementType) {
    this.movementType = movementType;
  }

  public CreditMovementCreateDto amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull 
  @Schema(name = "amount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditMovementCreateDto creditMovementCreateDto = (CreditMovementCreateDto) o;
    return Objects.equals(this.creditId, creditMovementCreateDto.creditId) &&
        Objects.equals(this.description, creditMovementCreateDto.description) &&
        Objects.equals(this.movementType, creditMovementCreateDto.movementType) &&
        Objects.equals(this.amount, creditMovementCreateDto.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditId, description, movementType, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditMovementCreateDto {\n");
    sb.append("    creditId: ").append(toIndentedString(creditId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    movementType: ").append(toIndentedString(movementType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

