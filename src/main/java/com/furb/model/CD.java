package com.furb.model;

public class CD {

    private String titulo;
    private String artista;
    private Double preco;
    private String loja;

    public CD(String loja, String artista, String titulo, Double preco) {
        this.loja = loja;
        this.titulo = titulo;
        this.artista = artista;
        this.preco = preco;
    }

    public CD(String titulo, String artista, Double preco, String loja) {
        this.titulo = titulo;
        this.artista = artista;
        this.preco = preco;
        this.loja = loja;
    }

    public CD() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    @Override
    public String toString(){
        return getTitulo() + " | " + getArtista() + " | R$" + getPreco();
    }
    
}
