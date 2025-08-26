package negocio.exceptions;

public class PedidoNaoPagoException extends RuntimeException {
    public PedidoNaoPagoException(String mensagem){
        super(mensagem);
    }
}
