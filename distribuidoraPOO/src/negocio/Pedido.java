package negocio;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private String status;

    public Pedido(int numero, Cliente cliente, ArrayList<Produto> produtos, double valorTotal, String status) {
        this.numero = numero;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", cliente=" + cliente +
                ", produtos=" + produtos +
                ", valorTotal=" + valorTotal +
                ", status='" + status + '\'' +
                '}';
    }
    public void calcularTotal(ArrayList<Produto> produtos){
        double total = 0.0;
        for(Produto p : produtos){
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;

    }
    public void adicionarProduto(){

    }
    public void status(){

    }
}
