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
 * AccountMovementCreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T12:46:41.705912500-05:00[America/Lima]")
public class AccountMovementCreateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String accountId;

  private String description;

  private String movementType;

  private Double amount;

  /**
   * Default constructor
   * @deprecated Use {@link AccountMovementCreateDto#AccountMovementCreateDto(String, String, String, Double)}
   */
  @Deprecated
  public AccountMovementCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AccountMovementCreateDto(String accountId, String description, String movementType, Double amount) {
    this.accountId = accountId;
    this.description = description;
    this.movementType = movementType;
    this.amount = amount;
  }

  public AccountMovementCreateDto accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * Get accountId
   * @return accountId
  */
  @NotNull 
  @Schema(name = "accountId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accountId")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public AccountMovementCreateDto description(String description) {
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

  public AccountMovementCreateDto movementType(String movementType) {
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

  public AccountMovementCreateDto amount(Double amount) {
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
    AccountMovementCreateDto accountMovementCreateDto = (AccountMovementCreateDto) o;
    return Objects.equals(this.accountId, accountMovementCreateDto.accountId) &&
        Objects.equals(this.description, accountMovementCreateDto.description) &&
        Objects.equals(this.movementType, accountMovementCreateDto.movementType) &&
        Objects.equals(this.amount, accountMovementCreateDto.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, description, movementType, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountMovementCreateDto {\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
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

