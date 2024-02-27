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
 * CreditDetailDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T16:34:21.491983300-05:00[America/Lima]")
public class CreditDetailDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String creditNumber;

  private String creditType;

  private Double limitAmount;

  private Double availableAmount;

  public CreditDetailDto id(String id) {
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

  public CreditDetailDto creditNumber(String creditNumber) {
    this.creditNumber = creditNumber;
    return this;
  }

  /**
   * Get creditNumber
   * @return creditNumber
  */
  
  @Schema(name = "creditNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creditNumber")
  public String getCreditNumber() {
    return creditNumber;
  }

  public void setCreditNumber(String creditNumber) {
    this.creditNumber = creditNumber;
  }

  public CreditDetailDto creditType(String creditType) {
    this.creditType = creditType;
    return this;
  }

  /**
   * Get creditType
   * @return creditType
  */
  
  @Schema(name = "creditType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creditType")
  public String getCreditType() {
    return creditType;
  }

  public void setCreditType(String creditType) {
    this.creditType = creditType;
  }

  public CreditDetailDto limitAmount(Double limitAmount) {
    this.limitAmount = limitAmount;
    return this;
  }

  /**
   * Get limitAmount
   * @return limitAmount
  */
  
  @Schema(name = "limitAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("limitAmount")
  public Double getLimitAmount() {
    return limitAmount;
  }

  public void setLimitAmount(Double limitAmount) {
    this.limitAmount = limitAmount;
  }

  public CreditDetailDto availableAmount(Double availableAmount) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditDetailDto creditDetailDto = (CreditDetailDto) o;
    return Objects.equals(this.id, creditDetailDto.id) &&
        Objects.equals(this.creditNumber, creditDetailDto.creditNumber) &&
        Objects.equals(this.creditType, creditDetailDto.creditType) &&
        Objects.equals(this.limitAmount, creditDetailDto.limitAmount) &&
        Objects.equals(this.availableAmount, creditDetailDto.availableAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creditNumber, creditType, limitAmount, availableAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditDetailDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

