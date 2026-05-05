package com.mariaeduarda.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaeduarda.petshop.entities.Categoria;
import com.mariaeduarda.petshop.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    // LISTAR TODAS
    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    public Categoria buscarPorId(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElse(null);
    }

    // CRIAR
    public Categoria criar(Categoria categoria) {
        return repository.save(categoria);
    }

    // EDITAR
    public Categoria editar(Long id, Categoria categoria) {
        Optional<Categoria> categoriaExistente = repository.findById(id);

        if (categoriaExistente.isPresent()) {
            Categoria cat = categoriaExistente.get();
            cat.setNome(categoria.getNome());
            cat.setDescricao(categoria.getDescricao());
            return repository.save(cat);
        }

        return null;
    }

    // EXCLUIR
    public boolean excluir(Long id) {
        Optional<Categoria> categoria = repository.findById(id);

        if (categoria.isPresent()) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}