package com.api.Cliente.controller.adapter;

import com.api.Cliente.controller.dto.request.ClienteRequest;
import com.api.Cliente.controller.dto.response.ClienteResponse;
import com.api.Cliente.entity.Cliente;

import java.util.UUID;

public class ClienteControllerAdapter {
    private ClienteControllerAdapter(){

    }

    public static Cliente castRequest(ClienteRequest request){
        return new Cliente(
                UUID.randomUUID().toString(),
                request.nome(),
                request.dataNascimento(),
                request.endereco()
        );
    }

    public static ClienteResponse castResponse(Cliente cliente){
             return new ClienteResponse(
                     cliente.id(),
                     cliente.nome(),
                     cliente.dataNascimento(),
                     cliente.endereco()
             );
    }
}
