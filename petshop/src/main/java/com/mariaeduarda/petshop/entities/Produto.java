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
    @JoinColumn(name = "id_categoria") // nome da FK na tabela produto
    private Categoria categoria;

    // getters e setters
}