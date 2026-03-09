package com.mvvalentin.hexagonal.adapters.in.controller;

import com.mvvalentin.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.mvvalentin.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mvvalentin.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mvvalentin.hexagonal.application.core.domain.Customer;
import com.mvvalentin.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.mvvalentin.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mvvalentin.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mvvalentin.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerResquest){
        var customer = customerMapper.toCustomer(customerResquest);
        insertCustomerInputPort.insert(customer, customerResquest.getZipCode());
        return ResponseEntity.ok().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerByIdInputPort.find(id);
        var  customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id,
                                       @Valid @RequestBody CustomerRequest customerResquest){
        Customer customer = customerMapper.toCustomer(customerResquest);
        customer.setId(id);
        updateCustomerInputPort.update(customer,customerResquest.getZipCode());
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}