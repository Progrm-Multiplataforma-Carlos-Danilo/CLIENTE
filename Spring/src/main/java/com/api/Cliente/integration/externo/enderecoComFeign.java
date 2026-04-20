package com.api.Cliente.integration.externo;

import com.api.Cliente.integration.dto.enderecoViaCep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "ViaCep",
        url = "https://viacep.com.br"
)
public interface enderecoComFeign {
    @GetMapping("/ws/{cep}/json")
    enderecoViaCep buscaEndereco(@PathVariable("cep") String cep);
}
