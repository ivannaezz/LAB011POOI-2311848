/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author ivann
 */
public class AuthorMetodos {
    
    private ArrayList<Author> autores;
    
    public AuthorMetodos() {
    autores = new ArrayList<>();
    cargarArchivo();
    }
    
    public ArrayList<Author> getListaAutor() {
        return autores;
    }
    
    public void adicionar(Author author) {
        autores.add(author);
    }
    
    public void eliminar(Author author) {
        autores.remove(author);
    }
    
    public int tamano() {
	  return autores.size();
    }
    
    
    public char validarGenero(String generoInput) {
        char generoAutor = ' ';
        if (generoInput.length() == 1 && (generoInput.equals("F") || generoInput.equals("M"))) {
            generoAutor = generoInput.charAt(0);
        } else {
            System.out.println("Error: Ingrese un género válido (F/M).");
        }

        return generoAutor;
    }
    
    public Author buscarAutorPorNombre(String nombre) {
        for (Author autor : autores) {
            if (autor.getName().equalsIgnoreCase(nombre)) {
                return autor;
            }
        }
        return null; 
    }
    public boolean emailValido(String correo) {
    
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

        return correo.matches(regex);
    }
    
    
    
    public void mostrarListaAutor() {
        if (tamano() > 0) {
            System.out.println("Lista de autores de los libros:");
            for (Author author : autores) {
                System.out.println(author); 
            }
        } else {
            System.out.println("La lista de autores está vacía.");
        }
    }
    
    
    private void cargarArchivo() {
        try {
            File file = new File("./src/actividad/listaAutor.txt");

            Class<Book> clazz = Book.class;
        InputStream inputStream = clazz.getResourceAsStream("/actividad/listaAutor.txt");
        if (file.exists()) {
            readFromInputStream(inputStream);
        } else
            JOptionPane.showMessageDialog(null,"El archivo txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
    private void readFromInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                createAuthor(line.split(","));
            }
        }
    }
    
    private void createAuthor(String[] parts) {
        try {
            if (parts.length >= 3) { // Verificar que haya al menos 3 elementos en el array
                String autorName = parts[0].trim();
                String autorEmail = parts[1].trim();
                char autorGenero = parts[2].trim().charAt(0); // Tomar el primer carácter

                Author autor = new Author(autorName, autorEmail, autorGenero);
                adicionar(autor);
            } else {
                System.out.println("Error: La línea no tiene el formato esperado. Se requieren al menos 3 elementos.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir precio o cantidad a números: " + e.getMessage());
        }
        
    }
    
    
    
    
}
