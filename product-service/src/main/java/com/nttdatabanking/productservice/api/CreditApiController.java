package com.nttdatabanking.productservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nttdatabanking.productservice.domain.CreditService;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-02-27T16:34:21.491983300-05:00[America/Lima]")
@RestController
public class CreditApiController implements CreditApi {

    private final CreditService creditService;

    public CreditApiController(@Autowired CreditService creditService) {
        this.creditService = creditService;
    }

    @Override
    public CreditService getCreditService() {
        return creditService;
    }

}
