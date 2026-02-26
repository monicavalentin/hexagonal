package com.mvvalentin.hexagonal.adapters.in.controller;

import com.mvvalentin.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.mvvalentin.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mvvalentin.hexagonal.application.ports.in.InsertCustomerInPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInPutPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerResquest){
        var customer = customerMapper.toCustomer(customerResquest);
        insertCustomerInputPort.insert(customer, customerResquest.getZipCode());
        return ResponseEntity.ok().build();

    }
}
