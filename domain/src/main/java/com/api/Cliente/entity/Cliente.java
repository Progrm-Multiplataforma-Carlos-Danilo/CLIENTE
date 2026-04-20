package com.api.Cliente.entity;

import java.util.Date;

public record Cliente(String id , String nome, Date dataNascimento, String endereco) {
}
