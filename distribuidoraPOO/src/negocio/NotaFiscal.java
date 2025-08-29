package negocio;
import negocio.exceptions.NotaFiscalException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class NotaFiscal {
    Random random = new Random();
    private int numero = random.nextInt(10);
    private Date data;
    private ArrayList<Produto> produtos;
    private double valorTotal;


    public NotaFiscal(ArrayList<Produto> produtos, Pedido pedido){
       this.numero = pedido.getNumero();
        this.valorTotal = valorTotal;
        this.produtos = new ArrayList<>();
    }
    public NotaFiscal(){
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
    public void gerarNotaFiscal(ArrayList<Produto> produtos) throws NotaFiscalException {
        if (produtos.isEmpty()) {
            throw new NotaFiscalException("Não é possível gerar nota fiscal sem produtos.");
        }
        double soma = 0;
        for (Produto p : produtos) {
            soma += p.getPreco() * p.getQuantidade();
        }
        this.valorTotal = soma;

        // imprime nota (bem simples)
        System.out.println("===== NOTA FISCAL =====");
        System.out.println("Número: " + numero);
        System.out.println("Data: " + data);
        System.out.println("Produtos:");
        for (Produto p : produtos) {
            System.out.println("- " + p.getNome() + " | R$ " + p.getPreco());
        }
        System.out.println("Valor Total: R$ " + valorTotal);
        System.out.println("=======================");
    }

}
