package com.mvvalentin.hexagonal.application.ports.out;

import com.mvvalentin.hexagonal.application.core.domain.Customer;

    // * Porta de saída para persistência de clientes. * Esta interface abstrai como o cliente será salvo
    // (seja em SQL, NoSQL ou via API),  * permitindo que a lógica de aplicação não dependa de tecnologias
    // de banco de dados.

public interface InsertCustomerOutputPort {
    // Método responsável por enviar o objeto de domínio para ser persistido. * * @param customer O
    // objeto cliente já com os dados validados e enriquecidos.

    void insert(Customer customer);
}
