package negocio;
import negocio.exceptions.NotaFiscalException;

import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {
    private int numero;
    private Date data;
    private ArrayList<Produto> produtos;
    private double valorTotal;

    public NotaFiscal(int numero, Date data, double valorTotal){
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
        produtos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "NotaFiscal{" +
                "numero=" + numero +
                ", data=" + data +
                ", produtos=" + produtos +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public void gerarNota() throws NotaFiscalException {
        if(produtos == null){
            throw new NotaFiscalException("A lista de produtos esta vazia.");
        }
        if(valorTotal <= 0){
            throw new NotaFiscalException("Valor total invalido para nota fiscal.");
        }
        System.out.println("=================================");
        System.out.println("          NOTA FISCAL            ");
        System.out.println("=================================");
        System.out.println("Número: " + numero);
        System.out.println("Data:   " + data);
        System.out.println("---------------------------------");
        System.out.println("Produtos:");

        for (Produto p : produtos) {
            System.out.println(" - " + p);
        }

        System.out.println("---------------------------------");
        System.out.println("Valor Total: R$ " + valorTotal);
        System.out.println("=================================");
    }
}
