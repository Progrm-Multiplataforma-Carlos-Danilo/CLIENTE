package com.api.Cliente.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(value = "cliente")
public record ClienteOrmMongo(
        @Id
        String id,
        String nome,
        Date dataNascimento,
        String endereco
) {
}
