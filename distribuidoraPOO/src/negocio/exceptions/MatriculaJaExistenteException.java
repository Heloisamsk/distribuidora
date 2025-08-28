package negocio.exceptions;

public class MatriculaJaExistenteException extends RuntimeException {
    public MatriculaJaExistenteException(String message) {
        super(message);
    }
}
