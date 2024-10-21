/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

public class Pedido implements Comparable<Pedido> {
    private String autorPedido;
    private double precio;
    private int cercania;

    // Constructor
    public Pedido(String autorPedido, double precio, int cercania) {
        this.autorPedido = autorPedido;
        this.precio = precio;
        this.cercania = cercania;
    }

    // Getters
    public String getAutorPedido() {
        return autorPedido;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCercania() {
        return cercania;
    }

    // Método para comparar por precio (para el Max Heap)
    @Override
    public int compareTo(Pedido otro) {
        return Double.compare(this.precio, otro.precio);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "autorPedido='" + autorPedido + '\'' +
                ", precio=" + precio +
                ", cercania=" + cercania +
                '}';
    }
}
