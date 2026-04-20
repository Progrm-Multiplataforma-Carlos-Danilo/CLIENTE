package com.api.Cliente.integration;

import com.api.Cliente.entity.Endereco;
import com.api.Cliente.integration.externo.enderecoComFeign;
import org.springframework.stereotype.Component;

@Component
public class enderecoIntegrationImpl implements EnderecoIntegration {
    private final enderecoComFeign feign;

    public enderecoIntegrationImpl(enderecoComFeign feign) {
        this.feign = feign;
    }

    @Override
    public Endereco buscarCep(String cep) {
        System.out.println("BUSCANDO ENDERECO PARA O CEP: " + cep);
        var response = feign.buscaEndereco(cep);


        return new Endereco(
                response.cep(),
                response.logradouro(),
                response.complemento(),
                response.bairro(),
                response.localidade(),
                response.uf()
        );
    }
}

