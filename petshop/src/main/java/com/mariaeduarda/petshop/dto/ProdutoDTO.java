package com.mariaeduarda.petshop.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private String nome;
    private String descricao;
    private BigDecimal preco;
    private BigDecimal precoDesconto;
    private String imagem;
    private Integer qtdEstoque;
    private Integer categoriaId;

    public ProdutoDTO() {}

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public BigDecimal getPrecoDesconto() { return precoDesconto; }
    public void setPrecoDesconto(BigDecimal precoDesconto) { this.precoDesconto = precoDesconto; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }

    public Integer getQtdEstoque() { return qtdEstoque; }
    public void setQtdEstoque(Integer qtdEstoque) { this.qtdEstoque = qtdEstoque; }

    public Integer getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Integer categoriaId) { this.categoriaId = categoriaId; }
}