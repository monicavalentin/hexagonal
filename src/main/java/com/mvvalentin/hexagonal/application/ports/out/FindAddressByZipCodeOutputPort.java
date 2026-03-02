package com.mvvalentin.hexagonal.application.ports.out;

import com.mvvalentin.hexagonal.application.core.domain.Address;

// Porta de saída para busca de endereços. **Define a interface que um adaptador externo
// (como um cliente Web ou consulta a DB) deve implementar para  fornecer dados de endereço baseados em um CEP.

public interface FindAddressByZipCodeOutputPort {

    // Busca um endereço a partir de um código postal. ** @param zipCode O CEP a ser consultado.
    // @return Um objeto de domínio Address preenchido.
    Address find(String zipCode);

}
