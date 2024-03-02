package com.nttdatabanking.customerservice.service.impl;

import com.nttdatabanking.customerservice.infraestructure.repository.CustomerRepository;
import com.nttdatabanking.customerservice.model.CustomerCreateDto;
import com.nttdatabanking.customerservice.model.CustomerDetailDto;
import com.nttdatabanking.customerservice.model.CustomerUpdateDto;
import com.nttdatabanking.customerservice.service.CustomerService;
import com.nttdatabanking.customerservice.util.Constants;
import com.nttdatabanking.customerservice.util.Messages;
import com.nttdatabanking.customerservice.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase implementacion servicio cliente.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Flux<CustomerDetailDto> getList() {
        return customerRepository.findAll()
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<CustomerDetailDto> getById(String id) {
        return customerRepository.findById(id)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<CustomerDetailDto> create(Mono<CustomerCreateDto> customerCreateDto) {
        return customerCreateDto
                .filter(this::validate)
                .switchIfEmpty(Mono.error(new Error(Messages.ERRORCUSTOMERVALIDATION)))
                .map(CustomerMapper::toEntity)
                .flatMap(customerRepository::insert)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<CustomerDetailDto> update(Mono<CustomerUpdateDto> customerUpdateDto) {
        return customerUpdateDto
                .filter(this::validate)
                .switchIfEmpty(Mono.error(new Error(Messages.ERRORCUSTOMERVALIDATION)))
                .map(CustomerMapper::toEntity)
                .flatMap(customerRepository::save)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<Void> delete(String id) {
        return customerRepository.deleteById(id);
    }

    private Boolean validate(CustomerCreateDto customerCreateDto) {
        return customerCreateDto.getName() != null
                && customerCreateDto.getLastname() != null
                && customerCreateDto.getDocumentNumber() != null
                && customerCreateDto.getEmail() != null
                && customerCreateDto.getCustomerType() != null
                && Constants.CostumerType.getByDescription(
                        customerCreateDto.getCustomerType()) != null;
    }

    private Boolean validate(CustomerUpdateDto customerUpdateDto) {
        return customerUpdateDto.getId() != null
                && customerUpdateDto.getName() != null
                && customerUpdateDto.getLastname() != null
                && customerUpdateDto.getDocumentNumber() != null
                && customerUpdateDto.getEmail() != null
                && customerUpdateDto.getCustomerType() != null
                && Constants.CostumerType.getByDescription(
                        customerUpdateDto.getCustomerType()) != null;
    }

}
