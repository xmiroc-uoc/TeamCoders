package grupofp.controlador;

import grupofp.modelo.*;

import java.util.Date;

public class Controlador {

  private Tienda tienda;

  public Controlador(Tienda tienda) {
    this.tienda = tienda;
  }

  public void agregarArticulo(String codigo, int tiempoPreparacion, float gastosEnvio, float precioVenta,
      String descripcion) {
    Articulo articulo = new Articulo(codigo, tiempoPreparacion, gastosEnvio, precioVenta, descripcion);
    tienda.agregarArticulo(articulo);
  }

  public void agregarClienteEstandar(String nombre, String domicilio, String nif, String email) {
    ClienteEstandar ce = new ClienteEstandar(nombre, domicilio, nif, email);
    tienda.agregarCliente(ce);
  }

  public void agregarClientePremium(String nombre, String domicilio, String nif, String email, int cuotaAnual) {
    ClientePremium cp = new ClientePremium(nombre, domicilio, nif, email, cuotaAnual);
    tienda.agregarCliente(cp);
  }

  public void agregarPedido(int numeroPedido, int unidades, String codigoArticulo, String nifCliente)
      throws ArticuloNoEncontradoException {
    Articulo articuloEncontrado = null;
    for (Articulo a : tienda.getArticulos()) {
      if (a.getCodigo().equalsIgnoreCase(codigoArticulo)) {
        articuloEncontrado = a;
        break;
      }
    }
    if (articuloEncontrado == null) {
      throw new ArticuloNoEncontradoException("No se encontró el artículo con código: " + codigoArticulo);
    }

    Cliente clienteEncontrado = null;
    for (Cliente c : tienda.getClientes()) {
      if (c.getNif().equalsIgnoreCase(nifCliente)) {
        clienteEncontrado = c;
        break;
      }
    }
    if (clienteEncontrado == null) {
      throw new RuntimeException("No se encontró el cliente con NIF: " + nifCliente);
    }

    Pedido pedido = new Pedido(numeroPedido, unidades, new Date(), clienteEncontrado, articuloEncontrado);
    tienda.agregarPedido(pedido);
  }

  public boolean cancelarPedido(int numeroPedido) {
    for (Pedido p : tienda.getPedidos()) {
      if (p.getNumeroPedido() == numeroPedido) {
        if (p.cancelable()) {
          tienda.eliminarPedido(p);
          return true;
        }
      }
    }
    return false;
  }

  public String listarArticulos() {
    StringBuilder sb = new StringBuilder();
    sb.append("Artículos en tienda:\n");
    for (Articulo a : tienda.getArticulos()) {
      sb.append(a.toString()).append("\n");
    }
    return sb.toString();
  }

  public String listarClientes() {
    StringBuilder sb = new StringBuilder();
    sb.append("Clientes en tienda:\n");
    for (Cliente c : tienda.getClientes()) {
      sb.append(c.toString()).append("\n");
    }
    return sb.toString();
  }

  public String listarPedidos() {
    StringBuilder sb = new StringBuilder();
    sb.append("Pedidos registrados:\n");
    for (Pedido p : tienda.getPedidos()) {
      sb.append(p.toString()).append("\n");
    }
    return sb.toString();
  }
}
