package com.nttdatabanking.customerservice.domain.dto;

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
 * CustomerUpdateDto
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T07:29:54.906932400-05:00[America/Lima]")
public class CustomerUpdateDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String id;

  private String name;

  private String lastname;

  private String documentNumber;

  private String email;

  private String customerType;

  /**
   * Default constructor
   * @deprecated Use {@link CustomerUpdateDto#CustomerUpdateDto(String, String, String, String, String, String)}
   */
  @Deprecated
  public CustomerUpdateDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CustomerUpdateDto(String id, String name, String lastname, String documentNumber, String email, String customerType) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.documentNumber = documentNumber;
    this.email = email;
    this.customerType = customerType;
  }

  public CustomerUpdateDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public CustomerUpdateDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerUpdateDto lastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  /**
   * Get lastname
   * @return lastname
  */
  @NotNull 
  @Schema(name = "lastname", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lastname")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public CustomerUpdateDto documentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  /**
   * Get documentNumber
   * @return documentNumber
  */
  @NotNull 
  @Schema(name = "documentNumber", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("documentNumber")
  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public CustomerUpdateDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CustomerUpdateDto customerType(String customerType) {
    this.customerType = customerType;
    return this;
  }

  /**
   * Get customerType
   * @return customerType
  */
  @NotNull 
  @Schema(name = "customerType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerType")
  public String getCustomerType() {
    return customerType;
  }

  public void setCustomerType(String customerType) {
    this.customerType = customerType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerUpdateDto customerUpdateDto = (CustomerUpdateDto) o;
    return Objects.equals(this.id, customerUpdateDto.id) &&
        Objects.equals(this.name, customerUpdateDto.name) &&
        Objects.equals(this.lastname, customerUpdateDto.lastname) &&
        Objects.equals(this.documentNumber, customerUpdateDto.documentNumber) &&
        Objects.equals(this.email, customerUpdateDto.email) &&
        Objects.equals(this.customerType, customerUpdateDto.customerType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastname, documentNumber, email, customerType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerUpdateDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    documentNumber: ").append(toIndentedString(documentNumber)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    customerType: ").append(toIndentedString(customerType)).append("\n");
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

