// ClienteEstandar.java
package grupofp.modelo;

public class ClienteEstandar extends Cliente {

  public ClienteEstandar(String nombre, String domicilio, String nif, String email) {
    super(nombre, domicilio, nif, email);
  }

  @Override
  public float descuentoEnvio() {

    return 0.0f;
  }
}
