package com.mvvalentin.hexagonal.application.ports.in;

import com.mvvalentin.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInPutPort {

    void insert(Customer customer, String zipCode);
}
