package com.upchiapas.EDatosIterator;

import com.upchiapas.EDatosIterator.Models.Alumno;
import com.upchiapas.EDatosIterator.Models.Materia;
import com.upchiapas.EDatosIterator.Models.Usuario;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Usuario> usuario = new ArrayList<>();
    private static ArrayList<Materia> materias= new ArrayList<>(7);
    private static ArrayList<Alumno> alumno= new ArrayList<>();
    private static Materia objetomateria = new Materia();
    private static int cMateria = 0;
    private static String nombremateria = "-";
    private static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args){
        usuario.add(new Usuario(221218,"abc"));
        usuario.add(new Usuario(221219,"efg"));
        usuario.add(new Usuario(221220,"ijk"));
        usuario.add(new Usuario(221221,"mnñ"));
        usuario.add(new Usuario(221222,"pqr"));
        usuario.add(new Usuario(111111,"profesor"));
        incioSesion();
    }
    public static void incioSesion(){

        int matricula;
        int j = 0;
        String contraseña;
        boolean iniciosesion = false;
        boolean docente = false;
        do{
            System.out.println("Matricula");
            matricula = entrada.nextInt();
            System.out.println("Contraseña");
            contraseña = entrada.next();
            for(int i = 0; i<6; i++){
                if(matricula == usuario.get(i).getMatricula() && contraseña.equals(usuario.get(i).getContraseña())) {
                    System.out.println("Iniciaste sesion correctamente");
                    iniciosesion = true;
                    if (contraseña.length() == 8) {
                       docente = true;
                       j=i;
                    }
                }
            }
            if(!iniciosesion){
                System.out.println("La matricula o contraseña es incorrecta ingresalo de nuevo");
            }
        }while(!iniciosesion);
       Materias(docente,j);
    }
    public static void Materias(boolean docente, int j){
        String materia, grupo;
        if(!docente){
           System.out.println("Nombre");
           nombremateria = entrada.next();
           System.out.println("Cuantas materias desea cargar");
           cMateria = entrada.nextInt();
           for(int i=0;i<cMateria; i++){
                System.out.println("materias a cargar");
                materia = entrada.next();
                System.out.println("a que grupo pertenece la materia");
                grupo = entrada.next();
                materias.add(new Materia(materia, grupo.charAt(0)));
                alumno.add(new Alumno(nombremateria, usuario.get(i).getMatricula(),materias));
           }
           objetomateria = cargaManual();
        }
        else
            mostrarcarga(cMateria);
        incioSesion();
    }
    public static Materia cargaManual(){
        String nombre = "-";
        String cp;
        String grupo = "-";
        System.out.println("desea hacer la carga manual");
        cp = entrada.next();
        if(cp.equals("si") || cp.equals("si")){
            System.out.println("Materia a cargar");
            nombre = entrada.next();
            System.out.println("a que grupo pertenece la materia");
            grupo = entrada.next();
        }
        return new Materia(nombre, grupo.charAt(0));
    }
    public static void mostrarcarga(int cMateria){
        int matricula, i = 0;
        String opcion;
        boolean ms = true;
        Iterator iterator = alumno.iterator();
        System.out.println("Busqueda");
        System.out.println("Matricula del alumno");
        matricula = entrada.nextInt();
        while(ms && iterator.hasNext()){
            if(matricula == alumno.get(i).getMatricula()){
                System.out.println("las materias cargadas son " + alumno.get(i).getNombre());
                alumno.get(i).Materia(cMateria);
                ms = false;
                System.out.println("Alumno " + alumno.get(i).getNombre() + " cargo " + objetomateria.getMateria() + " en " + objetomateria.getGrupo() );
                System.out.println("desea cargar materia");
                opcion = entrada.next();
                if(opcion.equals("si") || opcion.equals("si")){
                    materias.add(objetomateria);
                    System.out.println("la materia se cargo correctamente");
                }
            }
            iterator.next();
            i++;
        }
    }
}
