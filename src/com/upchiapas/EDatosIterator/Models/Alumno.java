package com.upchiapas.EDatosIterator.Models;
import java.util.ArrayList;
public class Alumno {
    private String nombre;
    private int matricula;
    private ArrayList<Materia> materia;

    public Alumno(String nombre, int matricula, ArrayList<Materia> materia) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void Materia(int cantidad) {
        for(int i = 0; i<cantidad; i++){
            System.out.println(i+1 + materia.get(i).getMateria() + "grupo " + materia.get(i).getGrupo());
        }
    }
}
