/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

import java.util.ArrayList;

/**
 *
 * @author ivann
 */
public class Author1 {
    private String name;
    private String email;
    private char genero;

    private static ArrayList<Author1> autor;    

    public Author1(String name, String email, char genero) {
        this.name = name;
        this.email = email;
        this.genero = genero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public static ArrayList<Author1> getAutor() {
        return autor;
    }

    public static void setAutor(ArrayList<Author1> autor) {
        Author1.autor = autor;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", genero=" + genero +
                '}';
    }

}

