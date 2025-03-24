// Main.java
package grupofp.vista;

import grupofp.controlador.Controlador;
import grupofp.modelo.Tienda;

public class Main {
  public static void main(String[] args) {
    Tienda tienda = new Tienda();

    Controlador controlador = new Controlador(tienda);

    VistaConsola vista = new VistaConsola(controlador);

    vista.iniciar();
  }
}
