package com.mariaeduarda.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mariaeduarda.petshop.entities.Categoria;
import com.mariaeduarda.petshop.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    // GET - LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        List<Categoria> categorias = service.listarTodas();
        return ResponseEntity.ok(categorias);
    }

    // GET - BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Categoria categoria = service.buscarPorId(id);

        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        }

        return ResponseEntity.notFound().build();
    }

    // POST - CRIAR
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = service.criar(categoria);
        return ResponseEntity.ok(novaCategoria);
    }

    // PUT - EDITAR
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria categoriaAtualizada = service.editar(id, categoria);

        if (categoriaAtualizada != null) {
            return ResponseEntity.ok(categoriaAtualizada);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE - EXCLUIR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        boolean removido = service.excluir(id);

        if (removido) {
            return ResponseEntity.ok("Categoria excluída com sucesso!");
        }

        return ResponseEntity.status(404).body("Categoria não encontrada!");
    }
}