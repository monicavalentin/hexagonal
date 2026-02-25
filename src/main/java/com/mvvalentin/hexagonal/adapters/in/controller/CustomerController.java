package com.mvvalentin.hexagonal.adapters.in.controller;

import com.mvvalentin.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.mvvalentin.hexagonal.adapters.in.controller.request.CustomerResquest;
import com.mvvalentin.hexagonal.application.ports.in.InsertCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/vi/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerResquest customerResquest){
        var customer = customerMapper.toCostumer(customerResquest);
        insertCustomerInputPort.insert(customer, customerResquest.getZipCode());
        return ResponseEntity.ok().build();

    }
}
