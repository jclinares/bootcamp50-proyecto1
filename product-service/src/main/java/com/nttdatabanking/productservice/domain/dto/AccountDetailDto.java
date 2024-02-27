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
 * AccountDetailDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T15:29:05.914645900-05:00[America/Lima]")
public class AccountDetailDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String accountCustomerType;

  private String accountNumber;

  private String accountType;

  private Double availableAmount;

  private Double commission;

  private Integer movementLimits;

  private Integer dayMovement;

  public AccountDetailDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AccountDetailDto accountCustomerType(String accountCustomerType) {
    this.accountCustomerType = accountCustomerType;
    return this;
  }

  /**
   * Get accountCustomerType
   * @return accountCustomerType
  */
  
  @Schema(name = "accountCustomerType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountCustomerType")
  public String getAccountCustomerType() {
    return accountCustomerType;
  }

  public void setAccountCustomerType(String accountCustomerType) {
    this.accountCustomerType = accountCustomerType;
  }

  public AccountDetailDto accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  */
  
  @Schema(name = "accountNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountNumber")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public AccountDetailDto accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  */
  
  @Schema(name = "accountType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountType")
  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public AccountDetailDto availableAmount(Double availableAmount) {
    this.availableAmount = availableAmount;
    return this;
  }

  /**
   * Get availableAmount
   * @return availableAmount
  */
  
  @Schema(name = "availableAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("availableAmount")
  public Double getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(Double availableAmount) {
    this.availableAmount = availableAmount;
  }

  public AccountDetailDto commission(Double commission) {
    this.commission = commission;
    return this;
  }

  /**
   * Get commission
   * @return commission
  */
  
  @Schema(name = "commission", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("commission")
  public Double getCommission() {
    return commission;
  }

  public void setCommission(Double commission) {
    this.commission = commission;
  }

  public AccountDetailDto movementLimits(Integer movementLimits) {
    this.movementLimits = movementLimits;
    return this;
  }

  /**
   * Get movementLimits
   * @return movementLimits
  */
  
  @Schema(name = "movementLimits", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("movementLimits")
  public Integer getMovementLimits() {
    return movementLimits;
  }

  public void setMovementLimits(Integer movementLimits) {
    this.movementLimits = movementLimits;
  }

  public AccountDetailDto dayMovement(Integer dayMovement) {
    this.dayMovement = dayMovement;
    return this;
  }

  /**
   * Get dayMovement
   * @return dayMovement
  */
  
  @Schema(name = "dayMovement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dayMovement")
  public Integer getDayMovement() {
    return dayMovement;
  }

  public void setDayMovement(Integer dayMovement) {
    this.dayMovement = dayMovement;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountDetailDto accountDetailDto = (AccountDetailDto) o;
    return Objects.equals(this.id, accountDetailDto.id) &&
        Objects.equals(this.accountCustomerType, accountDetailDto.accountCustomerType) &&
        Objects.equals(this.accountNumber, accountDetailDto.accountNumber) &&
        Objects.equals(this.accountType, accountDetailDto.accountType) &&
        Objects.equals(this.availableAmount, accountDetailDto.availableAmount) &&
        Objects.equals(this.commission, accountDetailDto.commission) &&
        Objects.equals(this.movementLimits, accountDetailDto.movementLimits) &&
        Objects.equals(this.dayMovement, accountDetailDto.dayMovement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, accountCustomerType, accountNumber, accountType, availableAmount, commission, movementLimits, dayMovement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountDetailDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    accountCustomerType: ").append(toIndentedString(accountCustomerType)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    availableAmount: ").append(toIndentedString(availableAmount)).append("\n");
    sb.append("    commission: ").append(toIndentedString(commission)).append("\n");
    sb.append("    movementLimits: ").append(toIndentedString(movementLimits)).append("\n");
    sb.append("    dayMovement: ").append(toIndentedString(dayMovement)).append("\n");
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

