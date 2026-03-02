package com.mvvalentin.hexagonal.application.ports.in;

import com.mvvalentin.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
