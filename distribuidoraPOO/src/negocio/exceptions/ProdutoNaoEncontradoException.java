package negocio.exceptions;

public class ProdutoNaoEncontradoException extends EstoqueErros{
    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
