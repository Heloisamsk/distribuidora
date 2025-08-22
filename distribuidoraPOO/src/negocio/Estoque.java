package negocio;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;
    private Pedido pedido;

    public Estoque(Pedido pedido, ArrayList<Produto> produto) {
        this.pedido = pedido;
        this.produtos = new ArrayList<>();
    }

    public ArrayList<Produto> getProduto() {
        return produtos;
    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public Produto consultarProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }

    public Produto listarProdutos() {
        for (Produto produto : produtos) {
            return produto;
        }
        return null;
    }

    public void statusProdutos() {
        System.out.println("=== STATUS DOS PRODUTOS ===");
        for (Produto p : produtos) {
            String status;

            if (p.getQuantidade() == 0) {
                status = "EM FALTA";
            } else if (p.getQuantidade() < 50) {
                status = "ESTOQUE BAIXO";
            } else {
                status = "EM ESTOQUE";
            }

            System.out.println("Código: " + p.getCodigo() +
                    " | Nome: " + p.getNome() +
                    " | Quantidade: " + p.getQuantidade() +
                    " | Status: " + status);

        }
    }
    public void atualizarEstoquePedido(Pedido pedido) {
        for (Produto produtoPedido : pedido.getProdutos()) {
            for (Produto p : produtos) {
                if (p.getCodigo().equals(produtoPedido.getCodigo())) {
                    if (p.getQuantidade() >= produtoPedido.getQuantidade()) {
                        p.setQuantidade(p.getQuantidade() - produtoPedido.getQuantidade());
                        System.out.println("Estoque atualizado: " + p.getNome());
                    } else {
                        System.out.println("Estoque insuficiente para " + p.getNome());
                    }
                }
            }
        }
    }

}