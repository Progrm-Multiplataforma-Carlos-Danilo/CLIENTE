package com.api.Cliente.integration.dto;

public record govCep(
        String cep,
        String tipoCep,
        String subTipoCep,
        String uf,
        String cidade,
        String bairro,
        String endereco,
        String complemento,
        String codigoIBGE
) {
}
