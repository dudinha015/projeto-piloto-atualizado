package com.mariaeduarda.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mariaeduarda.petshop.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}