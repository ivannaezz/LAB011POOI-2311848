/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad;

import java.util.ArrayList;

/**
 *
 * @author ivann
 */
public class Author {
    
    private String name;
    private String email;
    private char genero;

    private static ArrayList<Author> autor;    

    public Author(String name, String email, char genero) {
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

    public static ArrayList<Author> getAutor() {
        return autor;
    }

    public static void setAutor(ArrayList<Author> autor) {
        Author.autor = autor;
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
