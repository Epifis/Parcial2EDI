package interfaz;

import mundo.Pedido;
import mundo.Pizzeria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;
public class Main {

    static BufferedReader br;
    static Pizzeria pizzeria;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        boolean end = false;

        while (!end) {
            // Mostrar el menú de opciones
            System.out.println("Modos de uso:\n-----------------\n1. Interfaz de usuario\n2. Ingreso manual\n3. Archivo de pruebas\n4. Salir");
            int option = Integer.parseInt(br.readLine());

            if (option == 1) {
                interfazUsuario();
            } else if (option == 2) {
                ingresoManual();
            } else if (option == 3) {
                ingresoArchivoPruebas();
            } else if (option == 4) {
                System.out.println("SALIENDO");
                end = true;
            }
        }
    }

    static void interfazUsuario() throws Exception {
        pizzeria = new Pizzeria();
        boolean end = false;
        while (!end) {
            System.out.println("Bienvenido a la pizzeria\nMenu principal:\n1. Recibir un pedido.\n2. Atender un pedido.\n3. Despachar un pedido.\n4. Visualizar colas.\n5. Menu anterior.");
            int option = Integer.parseInt(br.readLine());

            switch (option) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = br.readLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(br.readLine());
                    System.out.print("Cercania (1-5): ");
                    int cercania = Integer.parseInt(br.readLine());
                    pizzeria.agregarPedido(nombre, precio, cercania);
                    break;
                case 2:
                    Pedido pedidoAtendido = pizzeria.atenderPedido();
                    if (pedidoAtendido != null) {
                        System.out.println("Pedido atendido: " + pedidoAtendido);
                    } else {
                        System.out.println("No hay pedidos para atender.");
                    }
                    break;
                case 3:
                    Pedido pedidoDespachado = pizzeria.despacharPedido();
                    if (pedidoDespachado != null) {
                        System.out.println("Pedido despachado: " + pedidoDespachado);
                    } else {
                        System.out.println("No hay pedidos para despachar.");
                    }
                    break;
                case 4:
                    System.out.println("Pedidos recibidos:");
                    List<Pedido> pedidos = pizzeria.pedidosRecibidosList();
                    for (Pedido p : pedidos) {
                        System.out.println(p);
                    }

                    System.out.println("Cola de despachos:");
                    List<Pedido> despachos = pizzeria.colaDespachosList();
                    for (Pedido d : despachos) {
                        System.out.println(d);
                    }
                    break;
                case 5:
                    end = true;
                    break;
            }
        }
    }

    static void ingresoManual() throws Exception {
        pizzeria = new Pizzeria();
        System.out.println("Ingrese manualmente los pedidos:");
        boolean exit = false;
        while (!exit) {
            System.out.println("Ingrese comando (RECIBIR <Nombre> <Precio> <Cercania>, ATENDER, DESPACHAR o SALIR):");
            String comando = br.readLine();
            String[] partes = comando.split(" ");
            switch (partes[0]) {
                case "RECIBIR":
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int cercania = Integer.parseInt(partes[3]);
                    pizzeria.agregarPedido(nombre, precio, cercania);
                    break;
                case "ATENDER":
                    Pedido atendido = pizzeria.atenderPedido();
                    if (atendido != null) {
                        System.out.println("Pedido atendido: " + atendido);
                    } else {
                        System.out.println("No hay pedidos para atender.");
                    }
                    break;
                case "DESPACHAR":
                    Pedido despachado = pizzeria.despacharPedido();
                    if (despachado != null) {
                        System.out.println("Pedido despachado: " + despachado);
                    } else {
                        System.out.println("No hay pedidos para despachar.");
                    }
                    break;
                case "SALIR":
                    exit = true;
                    break;
            }
        }
    }

    static void ingresoArchivoPruebas() throws Exception {
        pizzeria = new Pizzeria();
        BufferedReader fileReader = new BufferedReader(new FileReader("data/text.txt"));
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] partes = line.split(" ");
            switch (partes[0]) {
                case "RECIBIR":
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    int cercania = Integer.parseInt(partes[3]);
                    pizzeria.agregarPedido(nombre, precio, cercania);
                    break;
                case "ATENDER":
                    Pedido atendido = pizzeria.atenderPedido();
                    if (atendido != null) {
                        System.out.println("Pedido atendido: " + atendido);
                    } else {
                        System.out.println("No hay pedidos para atender.");
                    }
                    break;
                case "DESPACHAR":
                    Pedido despachado = pizzeria.despacharPedido();
                    if (despachado != null) {
                        System.out.println("Pedido despachado: " + despachado);
                    } else {
                        System.out.println("No hay pedidos para despachar.");
                    }
                    break;
                case "SALIR":
                    fileReader.close();
                    return;
            }
        }
    }
}
