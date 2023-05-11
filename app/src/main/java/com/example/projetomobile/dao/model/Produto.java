package com.example.projetomobile.dao.model;

public class Produto {
    private Integer id;
    private String nome;
    private double valor;
    private String fabricante;
    private String codBarras;
    private String nomeFoto;
    private Integer quantidade;


    public Produto(Integer id, String nome, double valor, String codBarras, String nomeFoto, String fabricante, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.codBarras = codBarras;
        this.nomeFoto = nomeFoto;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
    }

    public Produto(){

    }
    public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}

    public Integer getQuantidade(){return this.quantidade;}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public void setNomeFoto(String nomeFoto) {
        this.nomeFoto = nomeFoto;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public String getNomeFoto() {
        return nomeFoto;
    }
}
