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
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 *
 * @author ivann
 */
public class BookMetodos {
    
    private ArrayList<Book> books;
    private AuthorMetodos authorMetodos;
    
    public BookMetodos() {
        books = new ArrayList<>();
        authorMetodos = new AuthorMetodos(); 
        cargarArchivo();
    }
    
    public BookMetodos(AuthorMetodos authorMetodos) {
        this.authorMetodos = authorMetodos;
        books = new ArrayList<>(); 
    }
    
    public void adicionar(Book book) {
        books.add(book);
    }
    
    public void eliminar(Book book) {
        books.remove(book);
    }
    
    public int tamano() {
	  return books.size();
    }
    
    
    
    public void mostrarListaDeLibros() {
        if (tamano() > 0) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-25s | %-25s | %-25s | %-18s | %-9s | %-11s |\n", "Nombre del libro", "Autor", "Email del autor", "Género del autor", "Precio", "Cantidad");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

            for (Book book : books) {
            Author autor = book.getAutor();
            System.out.printf("| %-25s | %-25s | %-25s | %-18s | %-9.2f | %-11d |\n",
                book.getName(),
                (autor != null) ? autor.getName() : "No disponible",
                (autor != null) ? autor.getEmail() : "No disponible",
                (autor != null) ? String.valueOf(autor.getGenero()) : "No disponible",
                book.getPrecio(),
                book.getCantidad());
           }
        }
    }


    
    private Author buscarAutorPorNombre(String nombre) {
        ArrayList<Author> autores = authorMetodos.getListaAutor();
        for (Author autor : autores) {
            if (autor.getName().equalsIgnoreCase(nombre)) {
                return autor;
            }
        }
        return null; 
    }
     
    public Book buscarLibro(String nombre) {
        for (Book libro : books) {
            if (libro.getName().equalsIgnoreCase(nombre)) {
                return libro;
            }
        }
        return null; 
    }
    
    public Author buscarAutorPorLibro(String tituloLibro) {
        for (Book libro : books) {
            if (libro.getName().equalsIgnoreCase(tituloLibro)) {
                return libro.getAutor();  
            }
        }
        return null;  
    }
    
    public void ordenarPorAutor() {
        Collections.sort(books, (book1, book2) -> {
            String autor1 = book1.getAutor().getName();
            String autor2 = book2.getAutor().getName();
            return autor1.compareToIgnoreCase(autor2);
        });
    }
    
    
    
    private void cargarArchivo() {
        try {
            File file = new File("./src/actividad/listaLibros.txt");
            Class<Book> clazz = Book.class;
            InputStream inputStream = clazz.getResourceAsStream("/actividad/listaLibros.txt");

            if (file.exists()) {
                readFromInputStream(inputStream);
            } else {
                JOptionPane.showMessageDialog(null, "El archivo txt no existe");
            }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
            }
    }

    private void readFromInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) { // Asegurarse de que hay 4 elementos en la línea
                    createBook(parts);
                } else {
                    System.out.println("Error: La línea no tiene el formato esperado: " + line);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage());
            e.printStackTrace(); 
       }
    }
    
    private void createBook(String[] parts) {
    try {
        ArrayList<Author> listaAutor = authorMetodos.getListaAutor();

        if (parts.length >= 4) { 
            String nombreLibro = parts[0].trim();
            String autorName = parts[1].trim();
            String precioStr = parts[2].trim();
            String cantidadStr = parts[3].trim();

            double precio = Double.parseDouble(precioStr);
            int cantidad = Integer.parseInt(cantidadStr);

            Author autor = buscarAutorPorNombre(autorName);

            if (autor == null) {
                autor = new Author(autorName, "", '\0');
                listaAutor.add(autor);
            }

            Book libro = new Book(autorName, autor, precio, cantidad);
            libro.setName(nombreLibro);
            libro.setAutor(autor);
            libro.setPrecio(precio);
            libro.setCantidad(cantidad);

            adicionar(libro);
        } else {
            System.out.println("Error: La línea no tiene el formato esperado. Se requieren al menos 4 elementos.");
        }
    } catch (NumberFormatException e) {
        System.out.println("Error al convertir precio o cantidad a números: " + e.getMessage());
    }
}
    
    
    
    
}
