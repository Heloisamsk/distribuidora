package negocio;
import negocio.exceptions.ProdutoNaoEncontradoException;

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

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : this.produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        this.valorTotal = total;
        System.out.println("Total: " + total);
        return total;

    }

    public boolean adicionarProduto(Produto produto) {
        if (this.produtos.contains(produto)) {

            return produtos.add(produto);
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");
        }
    }

    public boolean removerProduto(Produto produto) {
        if (this.produtos.contains(produto)) {
            return produtos.remove(produto);
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado.");
        }
    }

        public void alterarStatus (String status){
            if (status.equalsIgnoreCase("Em andamento") ||
                    status.equalsIgnoreCase("Concluído") ||
                    status.equalsIgnoreCase("Cancelado")) {
                this.status = status;
            } else {
                throw new IllegalArgumentException("Status inválido!");
            }
        }
        @Override
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
    }

