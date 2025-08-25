package negocio.exceptions;

public class ProdutoJaExistenteException extends Exception{
    public ProdutoJaExistenteException(String mensage){
        super(mensage);
    }
}
