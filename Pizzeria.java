package mundo;

import estructuras.Heap;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class Pizzeria {

    // Constantes
    public static final String RECIBIR_PEDIDO = "RECIBIR";
    public static final String ATENDER_PEDIDO = "ATENDER";
    public static final String DESPACHAR_PEDIDO = "DESPACHAR";
    public static final String FIN = "FIN";

    private Heap<Pedido> pedidosRecibidos;  // Max Heap para pedidos recibidos
    private Heap<Pedido> colaDespachos;     // Min Heap para pedidos despachados

    public Pizzeria() {
        pedidosRecibidos = new Heap<>(true);  // Max Heap (por precio)
        colaDespachos = new Heap<>(false);    // Min Heap (por cercanía)
    }

    public void agregarPedido(String nombreAutor, double precio, int cercania) {
        Pedido pedido = new Pedido(nombreAutor, precio, cercania);
        pedidosRecibidos.add(pedido);
    }

    public Pedido atenderPedido() {
        return pedidosRecibidos.poll();  // Retira el pedido más caro
    }

    public Pedido despacharPedido() {
        Pedido pedido = atenderPedido(); // Primero atender
        if (pedido != null) {
            colaDespachos.add(pedido);  // Luego despachar por cercanía
        }
        return pedido;
    }

    /**
     * Convierte el heap de pedidos recibidos en una lista.
     * Esto requiere iterar sobre los elementos del heap.
     */
    public List<Pedido> pedidosRecibidosList() {
        List<Pedido> pedidos = new ArrayList<>();
        for (Pedido p : pedidosRecibidos.getElements()) {
            pedidos.add(p);
        }
        return pedidos;
    }

    /**
     * Convierte el heap de cola de despachos en una lista.
     * Esto requiere iterar sobre los elementos del heap.
     */
    public List<Pedido> colaDespachosList() {
        List<Pedido> despachos = new ArrayList<>();
        for (Pedido p : colaDespachos.getElements()) {
            despachos.add(p);
        }
        return despachos;
    }
}
