package com.semi.seminario_spring.controller;

import com.semi.seminario_spring.datasources.ClienteRepository;
import com.semi.seminario_spring.models.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @GetMapping("/{id}")
        public Cliente getClienteById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null); // ou lance uma exceção personalizada se o produto não for encontrado
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        clienteAtualizado.setId(id);
        return clienteRepository.save(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
