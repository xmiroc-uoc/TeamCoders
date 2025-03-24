// Pedido.java
package grupofp.modelo;

import java.util.*;

public class Pedido {
  private int numeroPedido;
  private int unidades;
  private Date fechaPedido;
  private Cliente cliente;
  private Articulo articulo;

  public Pedido(int numeroPedido, int unidades, Date fechaPedido, Cliente cliente, Articulo articulo) {
    this.numeroPedido = numeroPedido;
    this.unidades = unidades;
    this.fechaPedido = fechaPedido;
    this.cliente = cliente;
    this.articulo = articulo;
  }

  public int getNumeroPedido() {
    return numeroPedido;
  }

  public int getUnidades() {
    return unidades;
  }

  public Date getFechaPedido() {
    return fechaPedido;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Articulo getArticulo() {
    return articulo;
  }

  public void setNumeroPedido(int numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }

  public void setFechaPedido(Date fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  @Override
  public String toString() {
    return "Pedido{" +
        "numeroPedido=" + numeroPedido +
        ", unidades=" + unidades +
        ", fechaPedido=" + fechaPedido +
        ", cliente=" + cliente +
        ", articulo=" + articulo +
        '}';
  }

  public boolean cancelable() {
    return (new Date().getTime() - fechaPedido.getTime()) < ((long) articulo.getTiempoPreparacion() * 60 * 1000);
  }

  public float precioPedido() {
    float total = articulo.getPrecioVenta() * unidades;
    float descuento = cliente.descuentoEnvio();
    return total + (articulo.getGastosEnvio() * (1 - descuento));
  }
}
