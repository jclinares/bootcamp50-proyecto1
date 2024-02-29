package com.nttdatabanking.customerservice.api;

import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerDetailDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import com.nttdatabanking.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion delegado api cliente.
 */
@Service
public class CustomerApiDelegateImpl implements CustomerApiDelegate {

        @Autowired
        CustomerService customerService;

        @Override
        public Mono<ResponseEntity<Flux<CustomerDetailDto>>> customergetlist(
                        ServerWebExchange exchange) {
                return customerService.getList()
                                .collectList()
                                .map(result -> ResponseEntity.ok(Flux.fromIterable(result)));
        }

        @Override
        public Mono<ResponseEntity<CustomerDetailDto>> customergetbyid(
                        String id, ServerWebExchange exchange) {
                return customerService.getById(id)
                                .map(ResponseEntity::ok);
        }

        @Override
        public Mono<ResponseEntity<CustomerDetailDto>> customercreate(
                        Mono<CustomerCreateDto> customerCreateDto,
                        ServerWebExchange exchange) {
                return customerService.create(customerCreateDto)
                                .map(ResponseEntity::ok);
        }

        @Override
        public Mono<ResponseEntity<CustomerDetailDto>> customerupdate(
                        Mono<CustomerUpdateDto> customerUpdateDto,
                        ServerWebExchange exchange) {
                return customerService.update(customerUpdateDto)
                                .map(ResponseEntity::ok);
        }

        @Override
        public Mono<ResponseEntity<Void>> customerdelete(
                        String id, ServerWebExchange exchange) {
                return customerService.delete(id)
                                .map(ResponseEntity::ok);
        }

}
