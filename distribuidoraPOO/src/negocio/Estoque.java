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



    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    // se o produto estiver com menos de 50 unidades, está em estoque baixo!!!

    public Produto consultarProduto(String codigo) throws ProdutoNaoEncontradoException {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                //System.out.println("Produto encontrado: " + produto.getNome());
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado.");
    }


    public ArrayList<Produto> listarDados() {
        if (produtos.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Nenhum produto encontrado");
        }
        return produtos;
    }

    public void listarProdutos() throws ErrosGeralEstoque {
        if (produtos == null) {
            throw new ErrosGeralEstoque("Lista de produtos não inicializada.");
        }

        //System.out.println("=== STATUS DOS PRODUTOS ===");
        for (Produto p : produtos) {
            String status;

            if (p.getQuantidade() == 0) {
                status = "EM FALTA";
            } else if (p.getQuantidade() < 50) {
                status = "ESTOQUE BAIXO";
            } else {
                status = "EM ESTOQUE";
            }

            String infoProduto = "Código: " + p.getCodigo() +
                                 " | Nome: " + p.getNome() +
                                 " | Quantidade: " + p.getQuantidade() +
                                 " | Status: " + status;
        }
    }

    public void atualizarEstoquePedido(Pedido pedido)
            throws EstoqueInsuficienteException, ProdutoNaoEncontradoException, PedidoNaoPagoException {

        if (pedido == null || pedido.getProdutos() == null) {
            throw new IllegalArgumentException("O pedido e sua lista de produtos não podem ser nulos.");
        }

        if (!pedido.getStatus().equals("PAGO")) {
            throw new PedidoNaoPagoException("O pedido " + pedido.getNumero() + " não pode ser processado pois não está pago.");
        }

        for (Produto produtoPedido : pedido.getProdutos()) {
            if(produtoPedido.getQuantidade() < 0){
                throw new IllegalArgumentException("A quantidade de produto não pode ser negativa.");
            }

            Produto p = this.consultarProduto(produtoPedido.getCodigo());

            if (p.getQuantidade() < produtoPedido.getQuantidade()) {
                throw new EstoqueInsuficienteException("Estoque insuficiente.");
            }
            p.setQuantidade(p.getQuantidade() - produtoPedido.getQuantidade());
            //System.out.println("Estoque atualizado: " + p.getNome());
        }
    }
}