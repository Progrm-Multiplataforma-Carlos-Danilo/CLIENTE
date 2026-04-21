package com.api.Cliente.controller.dto.request;

import java.util.Date;

public record ClienteRequest (
        String nome,
        Date dataNascimento,
        String endereco

) {

}
