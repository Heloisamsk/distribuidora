package negocio.exceptions;

public class CaminhaoJaExisteException extends RuntimeException {
  public CaminhaoJaExisteException(String message) {
    super(message);
  }
}
