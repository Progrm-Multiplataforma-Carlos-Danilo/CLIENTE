package com.api.Cliente.repository;

import com.api.Cliente.entity.Cliente;

import java.util.Collection;

public interface ClienteRepository {
    Cliente cadastrar(Cliente cliente);
    Cliente pesquisarEspecifico(String id);
    Collection <Cliente>Listar();
    Cliente atualizar(Cliente cliente);
    Cliente Deletar(String id);
}
