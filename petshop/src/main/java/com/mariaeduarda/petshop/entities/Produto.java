package com.mariaeduarda.petshop.entities;

import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name = "preco_desconto", nullable = false)
    private BigDecimal precoDesconto;

    @Column(columnDefinition = "LONGTEXT")
    private String imagem;

    @Column(name = "qtd_estoque")
    private Integer qtdEstoque;

    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Integer idProduto, String nome, String descricao, BigDecimal preco,
                   BigDecimal precoDesconto, String imagem, Integer qtdEstoque,
                   Boolean ativo, Categoria categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
        this.imagem = imagem;
        this.qtdEstoque = qtdEstoque;
        this.ativo = ativo;
        this.categoria = categoria;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPrecoDesconto() {
        return precoDesconto;
    }

    public void setPrecoDesconto(BigDecimal precoDesconto) {
        this.precoDesconto = precoDesconto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}