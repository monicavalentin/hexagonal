package com.mvvalentin.hexagonal.adapters.out.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    private String street;
    private String city;
    private String state;

}