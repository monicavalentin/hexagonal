package com.mvvalentin.hexagonal.application.core.usecase;

import com.mvvalentin.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.mvvalentin.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mvvalentin.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }
    @Override
    public void delete(final String id){
        findCustomerByIdInputPort.find(id); // buscar um cliente para verificar se ele existe, se não existir cai na exceção do usecase
        deleteCustomerByIdOutputPort.delete(id);

    }
}