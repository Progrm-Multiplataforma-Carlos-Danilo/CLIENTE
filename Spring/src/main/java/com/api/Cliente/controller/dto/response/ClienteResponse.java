package com.api.Cliente.controller.dto.response;

import java.util.Date;

public record ClienteResponse (
        String id,
        String nome,
        Date dataNascimento,
        String endereco
){
}
