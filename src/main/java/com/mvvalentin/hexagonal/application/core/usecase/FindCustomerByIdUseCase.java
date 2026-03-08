package com.mvvalentin.hexagonal.application.core.usecase;

import com.mvvalentin.hexagonal.application.core.domain.Customer;
import com.mvvalentin.hexagonal.application.core.exceptions.ObjectNotFoundException;
import com.mvvalentin.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mvvalentin.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {
    // injeção ports
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    // construtor
    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }
    @Override
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new ObjectNotFoundException(id));
    }
}