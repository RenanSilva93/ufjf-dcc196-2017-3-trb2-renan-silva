package com.example.renan.trabalho1;

import java.util.ArrayList;
import java.util.Date;

public class Participante {
    private String nome;
    private String email;
    private ArrayList<Participante> participantes = new ArrayList<>();
    //private Date dataEntrada;
    //private Date dataSaida;
    private String dataEntrada;
    private String dataSaida;

    public Participante(String nome, String email, String entrada, String saida) {
        this.nome = nome;
        this.email = email;
        this.dataEntrada = entrada;
        this.dataSaida = saida;
    }

    public Participante() {
        if(participantes.isEmpty()) {
            //criarParticipantes();
        }
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getEntrada() {

        return dataEntrada;
    }

    public void setEntrada(String dataEntrada) {

        this.dataEntrada = dataEntrada;
    }

    public String getSaida() {

        return dataSaida;
    }

    public void setSaida(String dataSaida) {

        this.dataSaida = dataSaida;
    }

    /*public void criarParticipantes() {
        participantes.add(new Participante("Participante 1", "part1@part.com"));
        participantes.add(new Participante("Participante 2", "part2@part.com"));
    }*/

    public ArrayList<Participante> getParticipantes() {

        return participantes;
    }

    public void addParticipante(Participante participante) {

        participantes.add(participante);
    }

    public boolean verificaParticipante(String nome) {
        for(Participante p: this.getParticipantes()){
            if(p.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public Participante getParticipante(String nome) {
        for(Participante p: this.getParticipantes()){
            if(p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    public Participante getParticipanteToIndex(int index) {
        for(int i=0; i < index; i++){
            if(i == index) {
                return participantes.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {

        return nome;
    }
}
