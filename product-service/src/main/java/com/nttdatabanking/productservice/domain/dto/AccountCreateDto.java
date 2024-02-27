package com.nttdatabanking.productservice.domain.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.nttdatabanking.productservice.domain.dto.AccountCustomer;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * AccountCreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T14:43:27.105208400-05:00[America/Lima]")
public class AccountCreateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String accountCustomerType;

  @Valid
  private List<@Valid AccountCustomer> accountCustomer = new ArrayList<>();

  private String accountNumber;

  private String accountType;

  private Double availableAmount;

  private Double commission;

  private Integer movementLimits;

  private Integer dayMovement;

  /**
   * Default constructor
   * @deprecated Use {@link AccountCreateDto#AccountCreateDto(String, List<@Valid AccountCustomer>, String, String, Double)}
   */
  @Deprecated
  public AccountCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AccountCreateDto(String accountCustomerType, List<@Valid AccountCustomer> accountCustomer, String accountNumber, String accountType, Double availableAmount) {
    this.accountCustomerType = accountCustomerType;
    this.accountCustomer = accountCustomer;
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.availableAmount = availableAmount;
  }

  public AccountCreateDto accountCustomerType(String accountCustomerType) {
    this.accountCustomerType = accountCustomerType;
    return this;
  }

  /**
   * Get accountCustomerType
   * @return accountCustomerType
  */
  @NotNull 
  @Schema(name = "accountCustomerType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accountCustomerType")
  public String getAccountCustomerType() {
    return accountCustomerType;
  }

  public void setAccountCustomerType(String accountCustomerType) {
    this.accountCustomerType = accountCustomerType;
  }

  public AccountCreateDto accountCustomer(List<@Valid AccountCustomer> accountCustomer) {
    this.accountCustomer = accountCustomer;
    return this;
  }

  public AccountCreateDto addAccountCustomerItem(AccountCustomer accountCustomerItem) {
    if (this.accountCustomer == null) {
      this.accountCustomer = new ArrayList<>();
    }
    this.accountCustomer.add(accountCustomerItem);
    return this;
  }

  /**
   * Get accountCustomer
   * @return accountCustomer
  */
  @NotNull @Valid 
  @Schema(name = "accountCustomer", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accountCustomer")
  public List<@Valid AccountCustomer> getAccountCustomer() {
    return accountCustomer;
  }

  public void setAccountCustomer(List<@Valid AccountCustomer> accountCustomer) {
    this.accountCustomer = accountCustomer;
  }

  public AccountCreateDto accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Get accountNumber
   * @return accountNumber
  */
  @NotNull 
  @Schema(name = "accountNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accountNumber")
  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public AccountCreateDto accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  */
  @NotNull 
  @Schema(name = "accountType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accountType")
  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public AccountCreateDto availableAmount(Double availableAmount) {
    this.availableAmount = availableAmount;
    return this;
  }

  /**
   * Get availableAmount
   * @return availableAmount
  */
  @NotNull 
  @Schema(name = "availableAmount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("availableAmount")
  public Double getAvailableAmount() {
    return availableAmount;
  }

  public void setAvailableAmount(Double availableAmount) {
    this.availableAmount = availableAmount;
  }

  public AccountCreateDto commission(Double commission) {
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

  public AccountCreateDto movementLimits(Integer movementLimits) {
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

  public AccountCreateDto dayMovement(Integer dayMovement) {
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
    AccountCreateDto accountCreateDto = (AccountCreateDto) o;
    return Objects.equals(this.accountCustomerType, accountCreateDto.accountCustomerType) &&
        Objects.equals(this.accountCustomer, accountCreateDto.accountCustomer) &&
        Objects.equals(this.accountNumber, accountCreateDto.accountNumber) &&
        Objects.equals(this.accountType, accountCreateDto.accountType) &&
        Objects.equals(this.availableAmount, accountCreateDto.availableAmount) &&
        Objects.equals(this.commission, accountCreateDto.commission) &&
        Objects.equals(this.movementLimits, accountCreateDto.movementLimits) &&
        Objects.equals(this.dayMovement, accountCreateDto.dayMovement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountCustomerType, accountCustomer, accountNumber, accountType, availableAmount, commission, movementLimits, dayMovement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountCreateDto {\n");
    sb.append("    accountCustomerType: ").append(toIndentedString(accountCustomerType)).append("\n");
    sb.append("    accountCustomer: ").append(toIndentedString(accountCustomer)).append("\n");
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

