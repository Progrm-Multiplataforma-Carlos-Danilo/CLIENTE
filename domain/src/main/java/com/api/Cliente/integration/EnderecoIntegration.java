package com.api.Cliente.integration;

import com.api.Cliente.entity.Endereco;

public interface EnderecoIntegration {

    Endereco buscarCep(String cep);

}
