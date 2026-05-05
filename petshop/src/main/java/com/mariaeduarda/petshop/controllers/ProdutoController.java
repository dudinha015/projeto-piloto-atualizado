package com.mariaeduarda.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mariaeduarda.petshop.entities.Produto;
import com.mariaeduarda.petshop.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
    // BUSCAR PRODUTOS POR CATEGORIA
    @GetMapping("/categoria/{idCategoria}")
    public List<Produto> getProdutosByCategoria(@PathVariable Integer idCategoria) {
        return service.getProdutosPorCategoria(idCategoria);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
        return service.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }
}