/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad;



/**
 *
 * @author ivann
 */
public class Book {
    
    
    
    private String name;
    private Author autor;
    private double precio;
    private int cantidad;
    
    
    public Book(String name, Author autor, double precio, int cantidad) {
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

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
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
