package com.mvvalentin.hexagonal.adapters.out;

import com.mvvalentin.hexagonal.adapters.out.repository.CustomerRepository;
import com.mvvalentin.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapters implements DeleteCustomerByIdOutputPort {

    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);

    }
}
