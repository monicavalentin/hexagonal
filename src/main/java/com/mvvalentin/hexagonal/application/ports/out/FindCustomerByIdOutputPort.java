package com.mvvalentin.hexagonal.application.ports.out;

import com.mvvalentin.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    // aqui ele pode ou não ter um id no banco de dados
    // então vamos delegar para  use case tratar este erro
    Optional<Customer> find (String id);
}
