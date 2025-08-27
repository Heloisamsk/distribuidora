package negocio.exceptions;

public class CaminhaoNaoCadastradoException extends RuntimeException {
  public CaminhaoNaoCadastradoException(String message) {
    super(message);
  }
}
