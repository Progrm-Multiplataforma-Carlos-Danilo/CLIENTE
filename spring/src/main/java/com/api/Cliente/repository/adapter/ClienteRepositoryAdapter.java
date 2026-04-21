package com.api.Cliente.repository.adapter;

import com.api.Cliente.entity.Cliente;
import com.api.Cliente.repository.orm.ClienteOrmMongo;

public class ClienteRepositoryAdapter {
    private ClienteRepositoryAdapter(){

    }

    public static Cliente castOrm(ClienteOrmMongo orm){
        return new Cliente(
                orm.id(),
                orm.nome(),
                orm.dataNascimento(),
                orm.endereco()
        );
    }
    public static ClienteOrmMongo castEntity(Cliente cliente){
        return new ClienteOrmMongo(
                cliente.id(),
                cliente.nome(),
                cliente.dataNascimento(),
                cliente.endereco()
        );
    }
}
