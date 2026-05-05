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
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> catOpt = categoriaRepository.findById(id);
        return catOpt.orElseThrow(() -> new RuntimeException("Categoria com ID " + id + " não encontrada"));
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void excluir(Integer id) {
        Categoria cat = buscarPorId(id);
        categoriaRepository.delete(cat);
    }
}