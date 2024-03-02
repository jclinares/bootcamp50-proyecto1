package com.nttdatabanking.customerservice.api;

import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerDetailDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import com.nttdatabanking.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion delegado api cliente.
 */
@Slf4j
@Service
public class CustomerApiDelegateImpl implements CustomerApiDelegate {

        @Autowired
        CustomerService customerService;

        @Override
        public Mono<ResponseEntity<Flux<CustomerDetailDto>>> customergetlist(
                        ServerWebExchange exchange) {
                log.info("customergetlist start");
                return customerService.getList()
                                .collectList()
                                .map(result -> ResponseEntity.ok(Flux.fromIterable(result)))
                                .doFinally(signal -> log.info("customergetlist end"));
        }

        @Override
        public Mono<ResponseEntity<CustomerDetailDto>> customergetbyid(
                        String id, ServerWebExchange exchange) {
                log.info("customergetbyid start");
                log.info("id: {}", id);
                return customerService.getById(id)
                                .map(ResponseEntity::ok)
                                .doFinally(signal -> log.info("customergetbyid end"));
        }

        @Override
        public Mono<ResponseEntity<CustomerDetailDto>> customercreate(
                        Mono<CustomerCreateDto> customerCreateDto,
                        ServerWebExchange exchange) {
                log.info("customercreate start");
                log.info("customerCreateDto: {}", customerCreateDto);
                return customerService.create(customerCreateDto)
                                .map(ResponseEntity::ok)
                                .doFinally(signal -> log.info("customercreate end"));
        }

        @Override
        public Mono<ResponseEntity<CustomerDetailDto>> customerupdate(
                        Mono<CustomerUpdateDto> customerUpdateDto,
                        ServerWebExchange exchange) {
                log.info("customerUpdateDto start");
                log.info("customerUpdateDto: {}", customerUpdateDto);
                return customerService.update(customerUpdateDto)
                                .map(ResponseEntity::ok)
                                .doFinally(signal -> log.info("customerUpdateDto end"));
        }

        @Override
        public Mono<ResponseEntity<Void>> customerdelete(
                        String id, ServerWebExchange exchange) {
                log.info("customerdelete start");
                log.info("id: {}", id);
                return customerService.delete(id)
                                .map(ResponseEntity::ok)
                                .doFinally(signal -> log.info("customerdelete end"));
        }

}
