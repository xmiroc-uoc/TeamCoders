// Main.java
package grupofp.vista;

import grupofp.controlador.Controlador;
import grupofp.modelo.Tienda;

public class Main {
  public static void main(String[] args) {
    // Modelo
    Tienda tienda = new Tienda();

    // Controlador
    Controlador controlador = new Controlador(tienda);

    // Vista
    VistaConsola vista = new VistaConsola(controlador);

    // Iniciar la aplicación
    vista.iniciar();
  }
}
