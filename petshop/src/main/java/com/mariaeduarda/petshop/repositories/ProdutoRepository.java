package com.mariaeduarda.petshop.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mariaeduarda.petshop.entities.Produto;
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByCategoriaIdAndAtivoTrue(Integer idCategoria);
}