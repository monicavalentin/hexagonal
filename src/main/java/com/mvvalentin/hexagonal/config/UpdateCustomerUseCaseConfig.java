package com.mvvalentin.hexagonal.config;

import com.mvvalentin.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mvvalentin.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mvvalentin.hexagonal.application.core.useCase.FindCustomerByIdUseCase;
import com.mvvalentin.hexagonal.application.core.useCase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerUseCaseConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,findAddressByZipCodeAdapter,updateCustomerAdapter);
    }

}