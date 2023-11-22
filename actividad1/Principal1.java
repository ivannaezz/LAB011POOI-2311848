/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author ivann
 */
public class Principal1 {
    public static void main(String[] args) {

        AuthorMetodos1 authorMetodos = new AuthorMetodos1();
        BookMetodos1 bookMetodos = new BookMetodos1();

        Scanner scanner =  new Scanner(System.in);

        try{
        System.out.println("****** BIENVENIDOS ********");
        System.out.println("1- Mostrar la lista de libros");
        System.out.println("2- Agregar un libro y asignar el autor del libro");
        System.out.println("3- Eliminar un libro");
        System.out.println("4- Editar un libro");
        System.out.println("5- Buscar un libro por título");
        System.out.println("6- Buscar el autor dado un libro");
        System.out.println("7- Ordenar los libros por autor");
        System.out.println("8- SALIR");
        System.out.println();
        System.out.println("Ingrese su número de operación : ");
        int numOperacion = scanner.nextInt();
        scanner.nextLine();

        switch (numOperacion) {

            case 1:
                bookMetodos.mostrarListaDeLibros();
                break;

            case 2:

                System.out.println("Ingrese el nombre del libro:");
                String nombreLibro = scanner.nextLine().trim();


                System.out.println("Ingrese el precio del libro:");
                double precio = 0;

                while (true) {
                    try {
                        precio = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un número válido para el precio del libro.");
                    }
                }

                int cantidad = 0;
                while (true) {
                    System.out.println("Ingrese la cantidad de libros:");
                    try {
                        cantidad = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un número válido para la cantidad de libros.");
                    }
                }

                System.out.println("Ingrese el nombre del autor del libro:");
                String nombreAutor = scanner.nextLine().trim();

                char generoAutor;

                do {
                    System.out.println("Ingrese el género del autor (F/M):");
                    generoAutor = authorMetodos.validarGenero(scanner.nextLine().trim());
                    } while (generoAutor == 0);

                System.out.println("Ingrese el email del autor:");
                String emailAutor = scanner.nextLine().trim();

                Author1 autor = null;
                if (!authorMetodos.emailValido(emailAutor)) {
                    System.out.println("Error: Ingrese un correo electrónico válido.");
                }else {
                    autor = authorMetodos.buscarAutorPorNombre(nombreAutor);
                    if (autor == null) {
                        System.out.println("El libro no existe. Creando nuevo autor...");
                        autor = new Author1(nombreAutor, emailAutor, generoAutor);
                        authorMetodos.adicionar(autor);
                    }
                }    

                Book1 book = new Book1(nombreLibro, autor, precio, cantidad);
                bookMetodos.adicionar(book);
                System.out.println("Libro agregado exitosamente.");
                break;

            case 3:

                bookMetodos.mostrarListaDeLibros();

                System.out.println("Ingrese el nombre del libro que desea eliminar:");
                String nombreLibroEliminar = scanner.nextLine().trim();

                Book1 libroEliminar = bookMetodos.buscarLibro(nombreLibroEliminar);

                if (libroEliminar != null) {

                    bookMetodos.eliminar(libroEliminar);
                    System.out.println("Libro eliminado exitosamente.");
                } else {
                    System.out.println("El libro no existe en la lista.");
                }
                break;

            case 4:

                System.out.println("Ingrese el nombre del libro que desea editar:");
                String nombreLibroEditar = scanner.nextLine().trim();


                Book1 libroAEditar = bookMetodos.buscarLibro(nombreLibroEditar);

                if (libroAEditar != null) {
                    System.out.println("Libro encontrado. Ingrese los nuevos datos:");

                    System.out.println("Ingrese el nuevo nombre del libro:");
                    String nuevoNombreLibro = scanner.nextLine().trim();

                    System.out.println("Ingrese el nuevo precio del libro:");
                    double nuevoPrecioLibro = 0;

                while (true) {
                    try {
                        nuevoPrecioLibro = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un número válido para el precio del libro.");
                    }
                }

                System.out.println("Ingrese la nueva cantidad de libros:");
                int nuevaCantidadLibros = 0;

                while (true) {
                    try {
                        nuevaCantidadLibros = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingrese un número válido para la cantidad de libros.");
                    }
                }

                libroAEditar.setName(nuevoNombreLibro);
                libroAEditar.setPrecio(nuevoPrecioLibro);
                libroAEditar.setCantidad(nuevaCantidadLibros);

                System.out.println("Libro editado exitosamente.");
            } else {
                System.out.println("Libro no encontrado. Verifique el nombre e intente nuevamente.");
            }
            break;

            case 5:

                System.out.println("Ingrese el título del libro que desea buscar:");
                String tituloBuscar = scanner.nextLine().trim();

                Book1 libroEncontrado = bookMetodos.buscarLibro(tituloBuscar);

                if (libroEncontrado != null) {
                    System.out.println("Libro encontrado:");
                    System.out.println("Nombre del libro: " + libroEncontrado.getName());
                    System.out.println("Autor: " + libroEncontrado.getAutor().getName());
                    System.out.println("Email del autor: " + libroEncontrado.getAutor().getEmail());
                    System.out.println("Género del autor: " + libroEncontrado.getAutor().getGenero());
                    System.out.println("Precio: " + libroEncontrado.getPrecio());
                    System.out.println("Cantidad: " + libroEncontrado.getCantidad());
                } else {
                    System.out.println("Libro no encontrado. Verifique el título e intente nuevamente.");
                }
                break;

            case 6:
                System.out.println("Ingrese el título del libro:");
                String tituloLibroBusqueda = scanner.nextLine().trim();

                Author1 autorEncontrado = bookMetodos.buscarAutorPorLibro(tituloLibroBusqueda);

                if (autorEncontrado != null) {
                    System.out.println("Autor del libro '" + tituloLibroBusqueda + "':");
                    System.out.println("Nombre del autor: " + autorEncontrado.getName());
                    System.out.println("Email del autor: " + autorEncontrado.getEmail());
                    System.out.println("Género del autor: " + autorEncontrado.getGenero());
                } else {
                    System.out.println("No se encontró el libro con título '" + tituloLibroBusqueda + "' o no tiene un autor asignado.");
                }
                break;

            case 7:
                System.out.println("Lista de Libros (Original):");
                bookMetodos.mostrarListaDeLibros();

                System.out.println("\nLista de Libros Ordenada por Autor:");
                bookMetodos.ordenarPorAutor();
                bookMetodos.mostrarListaDeLibros();
                break;

            case 8: 
                System.exit(0);
                break;


                default:
                System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 8.");

        }


            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
            } finally {
            scanner.close(); 
    }



    }
}
