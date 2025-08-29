package negocio;

import negocio.exceptions.ErrosGeralEstoque;
import negocio.exceptions.EstoqueInsuficienteException;
import negocio.exceptions.PedidoNaoPagoException;
import negocio.exceptions.ProdutoNaoEncontradoException;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;
    private Pedido pedido;

    public Estoque(Pedido pedido) {
        this.pedido = pedido;
        this.produtos = new ArrayList<>();
    }

    public Estoque() {
        this.produtos = new ArrayList<>();
    }


    public ArrayList<Produto> getProdutos() {
        return produtos;
    }


    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void cadastrarProduto(Produto produto) {
        if (produto == null) throw new IllegalArgumentException("Produto não pode ser nulo.");
        produtos.add(produto);
        System.out.println("Produto cadastrado: " + produto.getNome() + " - Quantidade: " + produto.getQuantidade());
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    // se o produto estiver com menos de 50 unidades, está em estoque baixo!!!

    public Produto consultarProduto(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        throw new RuntimeException("Produto não encontrado no estoque: " + codigo);
    }


    public ArrayList<Produto> listarDados() {
        if (produtos.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Nenhum produto encontrado");
        }
        return produtos;
    }

    public void listarProdutos() {
        System.out.println("=== Estoque Atual ===");
        for (Produto p : produtos) {
            System.out.println(p.getNome() + " | Código: " + p.getCodigo() + " | Quantidade: " + p.getQuantidade());
        }
    }
    public void atualizarEstoquePedido(Pedido pedido) {
        if (pedido == null || pedido.getProdutos() == null) {
            throw new IllegalArgumentException("Pedido ou lista de produtos inválidos.");
        }
        if (!"Pago".equalsIgnoreCase(pedido.getStatus())) {
            throw new RuntimeException("Pedido não pode ser processado: ainda não foi pago.");
        }

        for (Produto produtoPedido : pedido.getProdutos()) {
            Produto estoqueProduto = consultarProduto(produtoPedido.getCodigo());

            if (estoqueProduto.getQuantidade() < produtoPedido.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + produtoPedido.getNome());
            }
            estoqueProduto.setQuantidade(estoqueProduto.getQuantidade() - produtoPedido.getQuantidade());
        }
    }
}