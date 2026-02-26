package com.mvvalentin.hexagonal.application.core.useCase;

import com.mvvalentin.hexagonal.application.core.domain.Customer;
import com.mvvalentin.hexagonal.application.ports.in.InsertCustomerInPutPort;
import com.mvvalentin.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.mvvalentin.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import org.springframework.stereotype.Service;

//  Use Case responsável pela lógica de negócio de inserção de um novo cliente.Segue o princípio
    //  da inversão de dependência, comunicando-se com o mundo externo  através de interfaces (Output Ports).
@Service
public class InsertCustomerUseCase implements InsertCustomerInPutPort  {
    // Portas de saída: O Use Case não sabe QUEM busca o endereço ou QUEM salva o cliente,
    // ele apenas sabe que existe um contrato para isso.

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final InsertCustomerOutPutPort insertCustomerOutPutPort;

      //Construtor para injeção de dependências.

    public InsertCustomerUseCase(FindAddressByZipCodeOutPutPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutPutPort insertCustomerOutPutPort) {
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
    }

    // Orquestra o fluxo de inserção: busca o endereço pelo CEP, enriquece o objeto
     // de domínio (Customer) e solicita a persistência.* @param customer Objeto de domínio com os
    // dados básicos do cliente. * @param zipCode CEP para busca de endereço.

    @Override
    public void insert(Customer customer, String zipCode){
        // 1. Busca as informações de endereço via integração externa (ex: API de Correios/ViaCEP)
        var andress = findAddressByZipCodeOutPutPort.find(zipCode);
        // 2. Associa o endereço retornado ao objeto cliente
        customer.setAddress(andress);
        // 3. Persiste o cliente no banco de dados através do adaptador de saída correspondente
        insertCustomerOutPutPort.insert(customer);
    }
}
