package negocio;

public class Venda {
    private Pedido pedido;
    private NotaFiscal notaFiscal;
    private Pagamento pagamento;

    public Venda(Pedido pedido, NotaFiscal notaFiscal, Pagamento pagamento) {
        this.pedido = pedido;
        this.notaFiscal = notaFiscal;
        this.pagamento = pagamento;
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

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void finalizarPedido(){
        if (pedido,getProdutos().isEmpty()){
            System.out.println("Não é possível finalizar o pedido sem produtos!")
            return;
        }

        pedido.alterarStatus("Finalizado!");
        System.out.println("Valor total: R$ "+ pedido.getValorTotal())
    }
}
