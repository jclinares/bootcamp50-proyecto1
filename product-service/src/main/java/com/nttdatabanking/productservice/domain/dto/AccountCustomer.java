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
 * AccountCustomer
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T14:55:59.068065600-05:00[America/Lima]")
public class AccountCustomer implements Serializable {

  private static final long serialVersionUID = 1L;

  private String customerId;

  private String businessCustomerType;

  /**
   * Default constructor
   * @deprecated Use {@link AccountCustomer#AccountCustomer(String)}
   */
  @Deprecated
  public AccountCustomer() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AccountCustomer(String customerId) {
    this.customerId = customerId;
  }

  public AccountCustomer customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  */
  @NotNull 
  @Schema(name = "customerId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerId")
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public AccountCustomer businessCustomerType(String businessCustomerType) {
    this.businessCustomerType = businessCustomerType;
    return this;
  }

  /**
   * Get businessCustomerType
   * @return businessCustomerType
  */
  
  @Schema(name = "businessCustomerType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("businessCustomerType")
  public String getBusinessCustomerType() {
    return businessCustomerType;
  }

  public void setBusinessCustomerType(String businessCustomerType) {
    this.businessCustomerType = businessCustomerType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountCustomer accountCustomer = (AccountCustomer) o;
    return Objects.equals(this.customerId, accountCustomer.customerId) &&
        Objects.equals(this.businessCustomerType, accountCustomer.businessCustomerType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, businessCustomerType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountCustomer {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    businessCustomerType: ").append(toIndentedString(businessCustomerType)).append("\n");
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

