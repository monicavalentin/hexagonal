package com.mvvalentin.hexagonal.application.ports.out;

import com.mvvalentin.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);

}
