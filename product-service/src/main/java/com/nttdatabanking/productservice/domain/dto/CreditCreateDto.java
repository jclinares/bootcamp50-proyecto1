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
 * CreditCreateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T16:49:16.954406300-05:00[America/Lima]")
public class CreditCreateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String customerId;

  private String creditNumber;

  private String creditType;

  private Double limitAmount;

  private Double availableAmount;

  /**
   * Default constructor
   * @deprecated Use {@link CreditCreateDto#CreditCreateDto(String, String, Double, Double)}
   */
  @Deprecated
  public CreditCreateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreditCreateDto(String creditNumber, String creditType, Double limitAmount, Double availableAmount) {
    this.creditNumber = creditNumber;
    this.creditType = creditType;
    this.limitAmount = limitAmount;
    this.availableAmount = availableAmount;
  }

  public CreditCreateDto customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  
  @Schema(name = "customerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("customerId")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public CreditCreateDto creditNumber(String creditNumber) {
    this.creditNumber = creditNumber;
    return this;
  }

  /**
   * Get creditNumber
   * @return creditNumber
  */
  @NotNull 
  @Schema(name = "creditNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("creditNumber")
  public String getCreditNumber() {
    return creditNumber;
  }

  public void setCreditNumber(String creditNumber) {
    this.creditNumber = creditNumber;
  }

  public CreditCreateDto creditType(String creditType) {
    this.creditType = creditType;
    return this;
  }

  /**
   * Get creditType
   * @return creditType
  */
  @NotNull 
  @Schema(name = "creditType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("creditType")
  public String getCreditType() {
    return creditType;
  }

  public void setCreditType(String creditType) {
    this.creditType = creditType;
  }

  public CreditCreateDto limitAmount(Double limitAmount) {
    this.limitAmount = limitAmount;
    return this;
  }

  /**
   * Get limitAmount
   * @return limitAmount
  */
  @NotNull 
  @Schema(name = "limitAmount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("limitAmount")
  public Double getLimitAmount() {
    return limitAmount;
  }

  public void setLimitAmount(Double limitAmount) {
    this.limitAmount = limitAmount;
  }

  public CreditCreateDto availableAmount(Double availableAmount) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCreateDto creditCreateDto = (CreditCreateDto) o;
    return Objects.equals(this.customerId, creditCreateDto.customerId) &&
        Objects.equals(this.creditNumber, creditCreateDto.creditNumber) &&
        Objects.equals(this.creditType, creditCreateDto.creditType) &&
        Objects.equals(this.limitAmount, creditCreateDto.limitAmount) &&
        Objects.equals(this.availableAmount, creditCreateDto.availableAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, creditNumber, creditType, limitAmount, availableAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCreateDto {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    creditNumber: ").append(toIndentedString(creditNumber)).append("\n");
    sb.append("    creditType: ").append(toIndentedString(creditType)).append("\n");
    sb.append("    limitAmount: ").append(toIndentedString(limitAmount)).append("\n");
    sb.append("    availableAmount: ").append(toIndentedString(availableAmount)).append("\n");
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

