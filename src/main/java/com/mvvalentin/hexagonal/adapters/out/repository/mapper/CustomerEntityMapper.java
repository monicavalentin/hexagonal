package com.mvvalentin.hexagonal.adapters.out.repository.mapper;

import com.mvvalentin.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mvvalentin.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" )
public interface CustomerEntityMapper {
    // converte de  Customer para CustomerEntity
    CustomerEntity toCustomerEntity(Customer customer);
}
