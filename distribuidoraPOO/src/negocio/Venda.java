package negocio;

public class Venda {
    private Pedido pedido;
    private NotaFiscal notaFiscal;

    public Venda(Pedido pedido, NotaFiscal notaFiscal) {
        this.pedido = pedido;
        this.notaFiscal = notaFiscal;
    }
    public Venda(){

    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }


    public void finalizarPedido(Pedido pedido){
        if (pedido.getProdutos().isEmpty()){
            throw new IllegalArgumentException("Não é possivel finalizar um pedido vazio.");
        }
        pedido.setStatus("PAGO");
        System.out.println("Status do pedido: " + pedido.getNumero()+ pedido.getStatus());

    }
}
