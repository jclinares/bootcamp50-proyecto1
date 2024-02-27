package com.nttdatabanking.productservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nttdatabanking.productservice.domain.AccountService;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T12:46:41.705912500-05:00[America/Lima]")
@RestController
public class AccountApiController implements AccountApi {

    private final AccountService accountService;

    public AccountApiController(@Autowired AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public AccountService getAccountService() {
        return accountService;
    }

}
