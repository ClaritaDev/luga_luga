package com.senai.lugaluga.model;

public class Produto {

    private String nome;

    private String descricao;

    private Double preco;

    private String status;

    private int quantidade;

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto(String nome, String descricao, Double preco, String status, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
        this.quantidade = quantidade;
    }

    public Produto() {
    }
}
