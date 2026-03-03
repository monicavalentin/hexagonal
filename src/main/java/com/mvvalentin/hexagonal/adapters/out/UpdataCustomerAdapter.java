package com.mvvalentin.hexagonal.adapters.out;

import com.mvvalentin.hexagonal.adapters.out.repository.CustomerRepository;
import com.mvvalentin.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mvvalentin.hexagonal.application.core.domain.Customer;
import com.mvvalentin.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdataCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
