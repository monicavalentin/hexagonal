package com.mvvalentin.hexagonal.adapters.out;

import com.mvvalentin.hexagonal.adapters.out.repository.CustomerRepository;
import com.mvvalentin.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mvvalentin.hexagonal.application.core.domain.Customer;
import com.mvvalentin.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutPutPort {

    //Injetar dependências
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        // inserir o cliente na base (salvar)

        // Primeiro convertemos o domínio para a entidade de banco
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);

        // Depois persistimos a entidade no repositório
        customerRepository.save(customerEntity);

        // ou faça assim para simplificar:
        //  customerRepository.save(customerEntityMapper.CustomerEntity(customer));

    }
}



