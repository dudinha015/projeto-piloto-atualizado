package com.mariaeduarda.petshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaeduarda.petshop.entities.Produto;
import com.mariaeduarda.petshop.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public ProdutoRepository getRepository() {
		return repository;
	}

	public void setRepository(ProdutoRepository repository) {
		this.repository = repository;
	}

	public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto buscarPorId(Integer id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.orElse(null);
    }

    public Produto atualizar(Integer id, Produto produtoAtualizado) {
        Produto produtoExistente = buscarPorId(id);

        if (produtoExistente != null) {
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setDescricao(produtoAtualizado.getDescricao());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            produtoExistente.setPrecoDesconto(produtoAtualizado.getPrecoDesconto());
            produtoExistente.setImagem(produtoAtualizado.getImagem());
            produtoExistente.setQtdEstoque(produtoAtualizado.getQtdEstoque());
            produtoExistente.setAtivo(produtoAtualizado.getAtivo());
            produtoExistente.setCategoria(produtoAtualizado.getCategoria());

            return repository.save(produtoExistente);
        }

        return null;
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }
 // BUSCAR PRODUTOS POR CATEGORIA
    public List<Produto> getProdutosPorCategoria(Integer idCategoria) {
        return repository.findByCategoriaIdAndAtivoTrue(idCategoria);
    }
}