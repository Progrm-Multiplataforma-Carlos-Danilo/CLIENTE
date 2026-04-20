package com.api.Cliente.repository;

import com.api.Cliente.entity.Cliente;
import com.api.Cliente.repository.adapter.ClienteRepositoryAdapter;
import com.api.Cliente.repository.mongo.ClienteRepositoryWithMongoDB;
import com.api.Cliente.repository.orm.ClienteOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository{

    private final ClienteRepositoryWithMongoDB repository;

    public ClienteRepositoryImpl(ClienteRepositoryWithMongoDB repository){
        this.repository = repository;
    }
    @Override
    public Cliente cadastrar(Cliente cliente){
            ClienteOrmMongo orm = ClienteRepositoryAdapter.castEntity(cliente);
            ClienteOrmMongo ormSave = repository.save(orm);
            return ClienteRepositoryAdapter.castOrm(ormSave);
     }

    @Override
    public Cliente pesquisarEspecifico(String id) {
        Optional<ClienteOrmMongo> orm = repository.findById(id);
        if (orm.isEmpty()) return null;

        return ClienteRepositoryAdapter.castOrm(orm.get());
    }

    @Override
    public Collection<Cliente> Listar() {
        return repository.findAll()
                .stream()
                .map(ClienteRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        ClienteOrmMongo orm = ClienteRepositoryAdapter.castEntity(cliente);
        ClienteOrmMongo ormUpdate = repository.save(orm);
        return ClienteRepositoryAdapter.castOrm(ormUpdate);
    }

    @Override
    public Cliente Deletar(String id) {
        repository.deleteById(id);
        return null;
    }
}
