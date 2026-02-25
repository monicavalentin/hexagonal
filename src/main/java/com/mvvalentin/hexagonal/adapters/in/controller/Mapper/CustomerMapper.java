package com.mvvalentin.hexagonal.adapters.in.controller.Mapper;

import com.mvvalentin.hexagonal.adapters.in.controller.request.CustomerResquest;
import com.mvvalentin.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface CustomerMapper {

    @Mapping(target = "id", ignore = true) // utilizado para ignorar campos da classe Customer
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCostumer(CustomerResquest customerResquest);

}
