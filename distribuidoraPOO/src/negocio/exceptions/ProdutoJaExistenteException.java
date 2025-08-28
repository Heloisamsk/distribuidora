package negocio.exceptions;

public class ProdutoJaExistenteException extends RuntimeException{
    public ProdutoJaExistenteException(String mensage){
        super(mensage);
    }
}
