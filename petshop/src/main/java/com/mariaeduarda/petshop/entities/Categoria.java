package com.mariaeduarda.petshop.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_categoria") // nome exato da tabela no MySQL
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // a coluna na tabela deve ser 'id'
    private Integer id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}