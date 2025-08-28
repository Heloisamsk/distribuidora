package negocio;
import negocio.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private static int contador = 0;
    private ArrayList<Produto> produtos;
    private double valorTotal;
    private String status;

    public Pedido(int numero,double valorTotal, String status, ArrayList<Produto> produtos) {
        this.numero = ++contador;
        this.produtos = new ArrayList<>();
        this.valorTotal = calcularTotal();
        this.status = status;
    }
    public Pedido(ArrayList<Produto> produtos) {
        if (produtos == null) {
            this.produtos = new ArrayList<>();
        } else {
            this.produtos = new ArrayList<>(produtos); // copia os produtos
        }
        this.valorTotal = calcularTotal();
        this.status = "Pendente"; // status inicial
        this.numero = ++contador;
    }

    public Pedido(){
        this.produtos = new ArrayList<>();
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        this.valorTotal = total; // garante que o atributo valorTotal seja atualizado
        return total;
    }

    public boolean adicionarProduto(Produto produto) {
        if (this.produtos.add(produto)) {
            //System.out.println("add");
            return produtos.add(produto);
        } else {
            throw new ProdutoNaoEncontradoException("Produto nao encontrado.");
        }
    }
    // nao testei
    public boolean removerProduto(Produto produto) {
        if (this.produtos.contains(produto)) {
            return produtos.remove(produto);
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");
        }
    }

        /*@Override
        public String toString () {
            StringBuilder sb = new StringBuilder();
            sb.append("Pedido número: ").append(numero).append("\n");
            sb.append("Cliente: ").append(cliente.getNome()).append("\n");
            sb.append("Produtos:\n");
            for (Produto p : produtos) {
                sb.append(" - ").append(p.getNome())
                        .append(" x").append(p.getQuantidade())
                        .append(" R$").append(p.getPreco()).append("\n");
            }
            sb.append("Valor total: R$").append(valorTotal).append("\n");
            sb.append("Status: ").append(status);
            return sb.toString();

        }

         */

}