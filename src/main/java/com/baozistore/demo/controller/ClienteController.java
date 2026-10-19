package com.baozistore.demo.controller;

import com.baozistore.demo.model.ClienteModel;
import com.baozistore.demo.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // 1 - CRIAR CLIENTES (POST)
    @PostMapping
    public ClienteModel criarCliente(@RequestBody ClienteModel cliente) {
        return clienteRepository.save(cliente);
    }

    // 2 - LISTAR CLIENTES (GET)
    @GetMapping
    public List<ClienteModel> listarClientes() {
        return clienteRepository.findAll();
    }

    // 2.1 - OBTER CLIENTE POR ID (GET)
    @GetMapping("/{id}")
    public ClienteModel obterCliente(@PathVariable Long id) {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    // 3 - ATUALIZAR CLIENTES (PUT)
    @PutMapping("/{id}")
    public ClienteModel atualizarCliente(@PathVariable Long id, @RequestBody ClienteModel clienteAtualizado) {
        return clienteRepository.findById(id)
            .map(clienteExistente -> {
                clienteExistente.setNome(clienteAtualizado.getNome());
                clienteExistente.setDataDesdeCliente(clienteAtualizado.getDataDesdeCliente());
                return clienteRepository.save(clienteExistente);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado para atualizar"));
    }

    // 4 - DELETAR CLIENTES (DELETE)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCliente(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado para deletar");
        }
        clienteRepository.deleteById(id);
    }
}

