package com.nttdatabanking.customerservice.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdatabanking.customerservice.domain.dto.CustomerCreateDto;
import com.nttdatabanking.customerservice.domain.dto.CustomerDetailDto;
import com.nttdatabanking.customerservice.domain.dto.CustomerUpdateDto;
import com.nttdatabanking.customerservice.domain.service.CustomerService;
import com.nttdatabanking.customerservice.infraestructure.repository.CustomerRepository;
import com.nttdatabanking.customerservice.util.Constants;
import com.nttdatabanking.customerservice.util.Messages;
import com.nttdatabanking.customerservice.util.mapper.CustomerMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
                .flatMap(CustomerServiceImpl::validate)
                .switchIfEmpty(Mono.error(new Error(Messages.ERROR_CUSTOMER_VALIDATION)))
                .map(CustomerMapper::toEntity)
                .flatMap(customerRepository::insert)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<CustomerDetailDto> update(Mono<CustomerUpdateDto> customerUpdateDto) {
        return customerUpdateDto
                .flatMap(CustomerServiceImpl::validate)
                .switchIfEmpty(Mono.error(new Error(Messages.ERROR_CUSTOMER_VALIDATION)))
                .map(CustomerMapper::toEntity)
                .flatMap(customerRepository::save)
                .map(CustomerMapper::toDto);
    }

    @Override
    public Mono<Void> delete(String id) {
        return customerRepository.deleteById(id);
    }

    private static Mono<CustomerCreateDto> validate(CustomerCreateDto customerCreateDto) {
        return Mono.just(customerCreateDto)
                .filter(dto -> dto.getName() != null
                        && dto.getLastname() != null
                        && dto.getDocumentNumber() != null
                        && dto.getEmail() != null
                        && dto.getCustomerType() != null
                        && (dto.getCustomerType().equalsIgnoreCase(Constants.CUSTOMER_PERSONAL)
                                || dto.getCustomerType().equalsIgnoreCase(Constants.CUSTOMER_BUSINESS)));
    }

    private static Mono<CustomerUpdateDto> validate(CustomerUpdateDto CustomerUpdateDto) {
        return Mono.just(CustomerUpdateDto)
                .filter(dto -> dto.getId() != null
                        && dto.getName() != null
                        && dto.getLastname() != null
                        && dto.getDocumentNumber() != null
                        && dto.getEmail() != null
                        && dto.getCustomerType() != null
                        && (dto.getCustomerType().equalsIgnoreCase(Constants.CUSTOMER_PERSONAL)
                                || dto.getCustomerType().equalsIgnoreCase(Constants.CUSTOMER_BUSINESS)));
    }

}
