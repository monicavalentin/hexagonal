package com.mvvalentin.hexagonal.adapters.in.controller.mapper;

import com.mvvalentin.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mvvalentin.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mvvalentin.hexagonal.application.core.domain.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @BeanMapping(ignoreByDefault = true)  // evita erros quando novos campos forem adicionados na entidade.
    @Mapping(target = "id", ignore = true) // utilizado para ignorar campos da classe Customer
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerResquest);

    // converte de Customer para CustomerResponse
    CustomerResponse toCustomerResponse (Customer customer);

}
