/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

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
public class BookMetodos1 {
    
    private ArrayList<Book1> books;
    private AuthorMetodos1 authorMetodos;

    public BookMetodos1() {
        books = new ArrayList<>();
        authorMetodos = new AuthorMetodos1(); 
        cargarArchivo();
    }

    public BookMetodos1(AuthorMetodos1 authorMetodos) {
        this.authorMetodos = authorMetodos;
        books = new ArrayList<>(); 
    }

    public void adicionar(Book1 book) {
        books.add(book);
    }

    public void eliminar(Book1 book) {
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

            for (Book1 book : books) {
            Author1 autor = book.getAutor();
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



    private Author1 buscarAutorPorNombre(String nombre) {
        ArrayList<Author1> autores = authorMetodos.getListaAutor();
        for (Author1 autor : autores) {
            if (autor.getName().equalsIgnoreCase(nombre)) {
                return autor;
            }
        }
        return null; 
    }

    public Book1 buscarLibro(String nombre) {
        for (Book1 libro : books) {
            if (libro.getName().equalsIgnoreCase(nombre)) {
                return libro;
            }
        }
        return null; 
    }

    public Author1 buscarAutorPorLibro(String tituloLibro) {
        for (Book1 libro : books) {
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
            File file = new File("./src/actividad1/listaLibros.txt");
            Class<Book1> clazz = Book1.class;
            InputStream inputStream = clazz.getResourceAsStream("/actividad1/listaLibros.txt");

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
        ArrayList<Author1> listaAutor = authorMetodos.getListaAutor();

        if (parts.length >= 4) { 
            String nombreLibro = parts[0].trim();
            String autorName = parts[1].trim();
            String precioStr = parts[2].trim();
            String cantidadStr = parts[3].trim();

            double precio = Double.parseDouble(precioStr);
            int cantidad = Integer.parseInt(cantidadStr);

            Author1 autor = buscarAutorPorNombre(autorName);

            if (autor == null) {
                autor = new Author1(autorName, "", '\0');
                listaAutor.add(autor);
            }

            Book1 libro = new Book1(autorName, autor, precio, cantidad);
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
