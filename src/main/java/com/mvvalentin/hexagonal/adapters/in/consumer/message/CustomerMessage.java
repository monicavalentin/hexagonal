package com.mvvalentin.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {

    // praticamente os mesmos dados que  temos no Consumer (core), com exceção que aqui ele passa o zipCode ao invés do
    // Address

    private String id;

    private String name;

    private  String zipCode;

    private String cpf;

    private Boolean isValidCpf;

}