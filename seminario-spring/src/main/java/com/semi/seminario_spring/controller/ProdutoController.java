package com.semi.seminario_spring.controller;

import com.semi.seminario_spring.datasources.ProdutoRepository;
import com.semi.seminario_spring.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null); // ou lance uma exceção personalizada se o produto não for encontrado
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        produtoAtualizado.setId(id);
        return produtoRepository.save(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
