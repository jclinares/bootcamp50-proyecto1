package com.nttdatabanking.customerservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nttdatabanking.customerservice.domain.service.CustomerService;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T07:29:54.906932400-05:00[America/Lima]")
@RestController
public class CustomerApiController implements CustomerApi {

    private final CustomerService customerService;

    public CustomerApiController(@Autowired CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public CustomerService getCustomerService() {
        return customerService;
    }

}
