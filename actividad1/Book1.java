/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1;

/**
 *
 * @author ivann
 */
public class Book1 {
    
    private String name;
    private Author1 autor;
    private double precio;
    private int cantidad;


    public Book1(String name, Author1 autor, double precio, int cantidad) {
        this.name = name;
        this.autor = autor;
        this.precio = precio;
        this.cantidad = cantidad;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author1 getAutor() {
        return autor;
    }

    public void setAutor(Author1 autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

     @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", autor=" + autor +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }

}
