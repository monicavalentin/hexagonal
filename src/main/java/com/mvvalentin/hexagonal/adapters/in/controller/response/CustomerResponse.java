package com.mvvalentin.hexagonal.adapters.in.controller.response;
import com.mvvalentin.hexagonal.application.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;
}
