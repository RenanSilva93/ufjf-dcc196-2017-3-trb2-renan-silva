package com.example.renan.trabalho1;

import java.util.ArrayList;

public class Reserva {
    private String participante;
    private String livro;
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public Reserva(String participante, String livro) {
        this.participante = participante;
        this.livro = livro;
    }

    public Reserva() {
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public void addReserva(Reserva reserva) {

        reservas.add(reserva);
    }

    public ArrayList<String> getLivrosParticipante(String nome) {
        ArrayList<String> livros = new ArrayList<>();
        for(Reserva r: this.reservas){
            if(r.participante.equals(nome)) {
                livros.add(r.livro);
            }
        }
        return livros;
    }

    public ArrayList<String> getReservasParticipantes(String titulo) {
        ArrayList<String> participantes = new ArrayList<>();
        for(Reserva r: this.reservas){
            if(r.livro.equals(titulo)) {
                participantes.add(r.participante);
            }
        }
        return participantes;
    }
}
