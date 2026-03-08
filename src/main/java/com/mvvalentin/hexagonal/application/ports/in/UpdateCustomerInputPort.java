package com.mvvalentin.hexagonal.application.ports.in;

import com.mvvalentin.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
