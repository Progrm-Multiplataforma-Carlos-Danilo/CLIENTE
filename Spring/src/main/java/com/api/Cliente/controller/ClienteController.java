package com.api.Cliente.controller;

import com.api.Cliente.controller.adapter.ClienteControllerAdapter;
import com.api.Cliente.controller.dto.request.ClienteRequest;
import com.api.Cliente.controller.dto.response.ClienteResponse;
import com.api.Cliente.entity.Cliente;
import com.api.Cliente.entity.Endereco;
import com.api.Cliente.integration.EnderecoIntegration;
import com.api.Cliente.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
@RestController
public class ClienteController {
    private final ClienteRepository clienteRepository;

    private final EnderecoIntegration enderecoIntegration;

     public ClienteController(ClienteRepository clienteRepository, EnderecoIntegration enderecoIntegration){
        this.clienteRepository=clienteRepository;
        this.enderecoIntegration=enderecoIntegration;
    }

    @PostMapping("cliente/cadastrar")
    public ClienteResponse cadastrar(@RequestBody ClienteRequest request) {
        Endereco enderecoViaCep = enderecoIntegration.buscarCep(request.endereco());
        
        String enderecoFormatado = enderecoViaCep.logradouro() + ", " + 
                                   enderecoViaCep.bairro() + ", " + 
                                   enderecoViaCep.cidade() + " - " + 
                                   enderecoViaCep.uf();
                                   
        Cliente cliente = new Cliente(
                java.util.UUID.randomUUID().toString(),
                request.nome(),
                request.dataNascimento(),
                enderecoFormatado
        );
        
        Cliente clienteCadastrar = clienteRepository.cadastrar(cliente);
        return ClienteControllerAdapter.castResponse(clienteCadastrar);
    }

    @GetMapping("cliente/{id}")
    public ClienteResponse pesquisar(@PathVariable String id){
        Cliente cliente = clienteRepository.pesquisarEspecifico(id);
        return  ClienteControllerAdapter.castResponse(cliente);
        }

    @GetMapping("cliente/listar")
    public Collection<ClienteResponse> listar(){
        return clienteRepository.Listar().stream().map(ClienteControllerAdapter::castResponse).collect(Collectors.toList());
    }

    @PutMapping("cliente/atualizar/{id}")
    public ClienteResponse atualizar(@PathVariable String id, @RequestBody ClienteRequest request){
        Endereco enderecoViaCep = enderecoIntegration.buscarCep(request.endereco());
        
        String enderecoFormatado = enderecoViaCep.logradouro() + ", " + 
                                   enderecoViaCep.bairro() + ", " + 
                                   enderecoViaCep.cidade() + " - " + 
                                   enderecoViaCep.uf();
                                   
        Cliente cliente = new Cliente(id, request.nome(), request.dataNascimento(), enderecoFormatado);
        Cliente atualizacao = clienteRepository.atualizar(cliente);
        return  ClienteControllerAdapter.castResponse(atualizacao);
        
    }

    @DeleteMapping("cliente/{id}")
    public String deletar(@PathVariable String id){
        clienteRepository.Deletar(id);
        return "CLiente DELETADO";
        }
}
