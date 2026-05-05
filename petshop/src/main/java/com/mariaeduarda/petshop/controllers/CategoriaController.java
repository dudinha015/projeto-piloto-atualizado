package com.mariaeduarda.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mariaeduarda.petshop.entities.Categoria;
import com.mariaeduarda.petshop.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Integer id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        Categoria existente = categoriaService.buscarPorId(id);
        existente.setNome(categoria.getNome());
        existente.setDescricao(categoria.getDescricao());
        return categoriaService.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        categoriaService.excluir(id);
    }
}