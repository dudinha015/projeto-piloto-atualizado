package com.mariaeduarda.petshop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mariaeduarda.petshop.dto.ProdutoDTO;
import com.mariaeduarda.petshop.entities.Categoria;
import com.mariaeduarda.petshop.entities.Produto;
import com.mariaeduarda.petshop.repositories.CategoriaRepository;
import com.mariaeduarda.petshop.repositories.ProdutoRepository;
import com.mariaeduarda.petshop.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*") // Permite acesso de qualquer origem
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todos - Onde estava dando o erro 500
    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> lista = service.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody ProdutoDTO dto) {
        Categoria cat = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada!"));

        Produto produto = new Produto();
        copiarDtoParaEntidade(dto, produto, cat);
        
        return produtoRepository.save(produto);
    }

    @PostMapping("/bulk")
    public List<Produto> criarProdutos(@RequestBody List<ProdutoDTO> dtos) {
        List<Produto> produtos = new ArrayList<>();

        for (ProdutoDTO dto : dtos) {
            Categoria cat = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria ID " + dto.getCategoriaId() + " inválida"));
            
            Produto p = new Produto();
            copiarDtoParaEntidade(dto, p, cat);
            p.setAtivo(true);
            produtos.add(p);
        }

        return produtoRepository.saveAll(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        Produto obj = service.buscarPorId(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/categoria/{idCategoria}")
    public List<Produto> getProdutosByCategoria(@PathVariable Integer idCategoria) {
        return service.getProdutosPorCategoria(idCategoria);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Integer id, @RequestBody ProdutoDTO dto) {
        Produto existente = service.buscarPorId(id);
        Categoria cat = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada!"));

        copiarDtoParaEntidade(dto, existente, cat);
        return produtoRepository.save(existente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Integer id) {
        service.excluir(id);
    }

    // Método auxiliar para evitar repetição de código
    private void copiarDtoParaEntidade(ProdutoDTO dto, Produto entidade, Categoria cat) {
        entidade.setNome(dto.getNome());
        entidade.setDescricao(dto.getDescricao());
        entidade.setPreco(dto.getPreco());
        entidade.setPrecoDesconto(dto.getPrecoDesconto());
        entidade.setImagem(dto.getImagem());
        entidade.setQtdEstoque(dto.getQtdEstoque());
        entidade.setAtivo(true);
        entidade.setCategoria(cat);
    }

	public ProdutoService getService() {
		return service;
	}

	public void setService(ProdutoService service) {
		this.service = service;
	}

	public ProdutoRepository getProdutoRepository() {
		return produtoRepository;
	}

	public void setProdutoRepository(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public CategoriaRepository getCategoriaRepository() {
		return categoriaRepository;
	}

	public void setCategoriaRepository(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
}