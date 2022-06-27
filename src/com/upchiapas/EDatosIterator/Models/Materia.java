package com.upchiapas.EDatosIterator.Models;

public class Materia {
    private String nomMateria;
    private char grupo;

    public Materia(){
        this("-",'-');
    }

    public Materia(String nomMateria, char grupo) {
        this.nomMateria = nomMateria;
        this.grupo = grupo;
    }
    public String getMateria() {
        return nomMateria;
    }
    public char getGrupo() {
        return grupo;
    }
}
