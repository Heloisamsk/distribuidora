package negocio;

public class Venda {
    private Pedido pedido;
    private NotaFiscal notaFiscal;

    public Venda(Pedido pedido, NotaFiscal notaFiscal) {
        this.pedido = pedido;
        this.notaFiscal = notaFiscal;
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

    public void finalizarPedido(){
        if (pedido.getProdutos().isEmpty()){
            System.out.println("Não é possível finalizar o pedido sem produtos!");
            return;
        }
        double total = pedido.calcularTotal();
        pedido.alterarStatus("Finalizado!");
        System.out.println("Valor total: R$ "+ total);
    }
}
