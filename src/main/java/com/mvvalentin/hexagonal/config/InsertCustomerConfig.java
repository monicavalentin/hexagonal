package com.mvvalentin.hexagonal.config;

import com.mvvalentin.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mvvalentin.hexagonal.adapters.out.InsertCustomerAdapter;
import com.mvvalentin.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.mvvalentin.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,insertCustomerAdapter,sendCpfValidationAdapter);
    }
}