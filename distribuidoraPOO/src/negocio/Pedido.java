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
    public Pedido(ArrayList<Produto> produtos){
        this.produtos = produtos;
        this.valorTotal = calcularTotal();
        this.status = "pendente";
        this.produtos = new ArrayList<>();
        this.numero = contador++;
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

    /*public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    */
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
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

    public boolean removerProduto(Produto produto) {
        if (this.produtos.contains(produto)) {
            return produtos.remove(produto);
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");
        }
    }

       /* public void alterarStatus (String status){
            if (status.equalsIgnoreCase("Em andamento") ||
                    status.equalsIgnoreCase("Concluído") ||
                    status.equalsIgnoreCase("Cancelado")) {
                this.status = status;
            } else {
                throw new IllegalArgumentException("Status inválido!");
            }
        } */


        /*
        *@Override
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

