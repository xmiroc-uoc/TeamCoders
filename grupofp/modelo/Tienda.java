// Tienda.java
package grupofp.modelo;

import java.util.*;

public class Tienda {
  private List<Articulo> articulos;
  private List<Cliente> clientes;
  private List<Pedido> pedidos;

  public Tienda() {
    this.articulos = new ArrayList<>();
    this.clientes = new ArrayList<>();
    this.pedidos = new ArrayList<>();
  }

  public List<Articulo> getArticulos() {
    return articulos;
  }

  public List<Cliente> getClientes() {
    return clientes;
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setArticulos(List<Articulo> articulos) {
    this.articulos = articulos;
  }

  public void setClientes(List<Cliente> clientes) {
    this.clientes = clientes;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  @Override
  public String toString() {
    return "Tienda{" +
        "articulos=" + articulos +
        ", clientes=" + clientes +
        ", pedidos=" + pedidos +
        '}';
  }

  public void agregarArticulo(Articulo articulo) {
    articulos.add(articulo);
  }

  public void mostrarArticulo() {
    for (Articulo a : articulos) {
      System.out.println(a.getDescripcion());
    }
  }

  public void agregarCliente(Cliente cliente) {
    clientes.add(cliente);
  }

  public void mostrarClientes() {
    for (Cliente c : clientes) {
      System.out.println(c.getNombre());
    }
  }

  public void agregarPedido(Pedido pedido) {
    pedidos.add(pedido);
  }

  public void eliminarPedido(Pedido pedido) {
    pedidos.remove(pedido);
  }

  public void mostrarPedidos() {
    for (Pedido p : pedidos) {
      System.out.println("Pedido #" + p.getNumeroPedido());
    }
  }
}
