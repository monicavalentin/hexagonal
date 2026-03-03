package com.mvvalentin.hexagonal.adapters.out.client.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AddressResponse {

    private String street;
    private String city;
    private String state;

}