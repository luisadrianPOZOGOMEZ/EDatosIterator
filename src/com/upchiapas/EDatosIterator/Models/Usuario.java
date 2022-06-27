package com.upchiapas.EDatosIterator.Models;

public class Usuario {
    private int matricula;
    private String contraseña;

    public Usuario(int matricula, String contraseña) {
        this.matricula = matricula;
        this.contraseña = contraseña;

    }
    public Usuario(){}

    public int getMatricula() {
        return matricula;
    }

    public String getContraseña() {
        return contraseña;
    }
    public void setMatricula(int matricula) {this.matricula = matricula;}
}
