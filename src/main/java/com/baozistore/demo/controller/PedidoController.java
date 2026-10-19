package com.baozistore.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.baozistore.demo.model.PedidoModel;
import com.baozistore.demo.repository.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // 1 - CRIAR PEDIDOS (POST)
    @PostMapping
    public PedidoModel criarPedido(@RequestBody PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    // 2 - LISTAR PEDIDOS (GET)
    @GetMapping
    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    // 2.1 - OBTER PEDIDO POR ID (GET - Obrigatório pelo PDF)
    @GetMapping("/{id}")
    public PedidoModel obterPedido(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

    // 3 - ATUALIZAR PEDIDOS (PUT)
    @PutMapping("/{id}")
    public PedidoModel atualizarPedido(@PathVariable Long id, @RequestBody PedidoModel pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(pedidoExistente -> {
                    pedidoExistente.setClienteId(pedidoAtualizado.getClienteId());
                    pedidoExistente.setProdutoId(pedidoAtualizado.getProdutoId());
                    pedidoExistente.setQuantidade(pedidoAtualizado.getQuantidade());
                    return pedidoRepository.save(pedidoExistente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado para atualizar"));
    }

    // 4 - DELETAR PEDIDOS (DELETE)
    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado para deletar");
        }
        pedidoRepository.deleteById(id);
    }
}
