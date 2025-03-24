package grupofp.vista;

import grupofp.controlador.ArticuloNoEncontradoException;
import grupofp.controlador.Controlador;

import java.util.Scanner;

public class VistaConsola {

  private Controlador controlador;
  private Scanner sc;

  public VistaConsola(Controlador controlador) {
    this.controlador = controlador;
    this.sc = new Scanner(System.in);
  }

  public void iniciar() {
    int opcion;
    do {
      mostrarMenu();
      opcion = leerEntero("Elige una opción: ");
      switch (opcion) {
        case 1:
          opcionAgregarArticulo();
          break;
        case 2:
          System.out.println(controlador.listarArticulos());
          break;
        case 3:
          opcionAgregarClienteEstandar();
          break;
        case 4:
          opcionAgregarClientePremium();
          break;
        case 5:
          System.out.println(controlador.listarClientes());
          break;
        case 6:
          opcionAgregarPedido();
          break;
        case 7:
          System.out.println(controlador.listarPedidos());
          break;
        case 8:
          opcionCancelarPedido();
          break;
        case 9:
          System.out.println("Saliendo del programa...");
          break;
        default:
          System.out.println("Opción no válida. Intente de nuevo.");
      }
    } while (opcion != 9);
  }

  private void mostrarMenu() {
    System.out.println("\n======= MENÚ PRINCIPAL =======");
    System.out.println("1. Agregar Artículo");
    System.out.println("2. Listar Artículos");
    System.out.println("3. Agregar Cliente Estandar");
    System.out.println("4. Agregar Cliente Premium");
    System.out.println("5. Listar Clientes");
    System.out.println("6. Agregar Pedido");
    System.out.println("7. Listar Pedidos");
    System.out.println("8. Cancelar Pedido");
    System.out.println("9. Salir");
    System.out.println("==============================");
  }

  private void opcionAgregarArticulo() {
    System.out.println("\n=== Agregar Artículo ===");
    String codigo = leerCadena("Código: ");
    int tiempoPrep = leerEntero("Tiempo de preparación (min): ");
    float gastosEnvio = leerFloat("Gastos de envío: ");
    float precioVenta = leerFloat("Precio de venta: ");
    String descripcion = leerCadena("Descripción: ");

    controlador.agregarArticulo(codigo, tiempoPrep, gastosEnvio, precioVenta, descripcion);
    System.out.println("Artículo agregado correctamente.");
  }

  private void opcionAgregarClienteEstandar() {
    System.out.println("\n=== Agregar Cliente Estandar ===");
    String nombre = leerCadena("Nombre: ");
    String domicilio = leerCadena("Domicilio: ");
    String nif = leerCadena("NIF: ");
    String email = leerCadena("Email: ");

    controlador.agregarClienteEstandar(nombre, domicilio, nif, email);
    System.out.println("Cliente Estandar agregado correctamente.");
  }

  private void opcionAgregarClientePremium() {
    System.out.println("\n=== Agregar Cliente Premium ===");
    String nombre = leerCadena("Nombre: ");
    String domicilio = leerCadena("Domicilio: ");
    String nif = leerCadena("NIF: ");
    String email = leerCadena("Email: ");
    int cuotaAnual = leerEntero("Cuota anual: ");

    controlador.agregarClientePremium(nombre, domicilio, nif, email, cuotaAnual);
    System.out.println("Cliente Premium agregado correctamente.");
  }

  private void opcionAgregarPedido() {
    System.out.println("\n=== Agregar Pedido ===");
    int numeroPedido = leerEntero("Número de pedido: ");
    int unidades = leerEntero("Unidades: ");
    String codigoArticulo = leerCadena("Código del Artículo: ");
    String nifCliente = leerCadena("NIF del Cliente: ");

    try {
      controlador.agregarPedido(numeroPedido, unidades, codigoArticulo, nifCliente);
      System.out.println("Pedido agregado correctamente.");
    } catch (ArticuloNoEncontradoException e) {
      System.out.println("Error al agregar pedido: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error al agregar pedido: " + e.getMessage());
    }
  }

  private void opcionCancelarPedido() {
    System.out.println("\n=== Cancelar Pedido ===");
    int numeroPedido = leerEntero("Número de pedido a cancelar: ");
    boolean exito = controlador.cancelarPedido(numeroPedido);
    if (exito) {
      System.out.println("Pedido cancelado con éxito.");
    } else {
      System.out.println("No se pudo cancelar el pedido (puede que esté fuera de tiempo o no exista).");
    }
  }

  private String leerCadena(String mensaje) {
    System.out.print(mensaje);
    return sc.nextLine();
  }

  private int leerEntero(String mensaje) {
    while (true) {
      try {
        System.out.print(mensaje);
        int valor = Integer.parseInt(sc.nextLine());
        return valor;
      } catch (NumberFormatException e) {
        System.out.println("Error: introduce un número entero válido.");
      }
    }
  }

  private float leerFloat(String mensaje) {
    while (true) {
      try {
        System.out.print(mensaje);
        float valor = Float.parseFloat(sc.nextLine());
        return valor;
      } catch (NumberFormatException e) {
        System.out.println("Error: introduce un número válido.");
      }
    }
  }
}
