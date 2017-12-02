package com.example.renan.trabalho1;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String editora;
    private Integer ano;
    private ArrayList<Livro> livros = new ArrayList<>();

    public Livro(String titulo, String editora, Integer ano) {
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
    }

    public Livro() {
        if(this.livros.isEmpty()) {
            criarLista();
        }
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getEditora() {

        return editora;
    }

    public void setEditora(String editora) {

        this.editora = editora;
    }

    public Integer getAno() {

        return ano;
    }

    public void setAno(Integer ano) {

        this.ano = ano;
    }

    private void criarLista() {
        livros.add(new Livro("Android", "UFJF", 2017));
        livros.add(new Livro("Rede", "UFJF", 2016));
        livros.add(new Livro("PHP", "UFJF", 2017));
    }

    public ArrayList<Livro> getLivros() {

        return livros;
    }

    public void addLivro(Livro livro) {

        livros.add(livro);
    }

    public boolean verificaLivro(String nome) {
        for(Livro l: this.getLivros()){
            if(l.getTitulo().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public Livro getLivro(String nome) {
        for(Livro l: this.getLivros()){
            if(l.getTitulo().equals(nome)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        return titulo;
    }
}
