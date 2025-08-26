package negocio;

import negocio.exceptions.ErrosGeralEstoque;
import negocio.exceptions.EstoqueInsuficienteException;
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

    public void consultarProduto(String codigo) throws ProdutoNaoEncontradoException {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                System.out.println("Produto encontrado: " + produto.getNome());
                return; // sai do método
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

    public void atualizarEstoquePedido(Pedido pedido)
            throws EstoqueInsuficienteException, ProdutoNaoEncontradoException { // Adiciona a cláusula throws
        if (pedido == null || pedido.getProdutos() == null) {
            throw new IllegalArgumentException("O pedido e sua lista de produtos não podem ser nulos.");
        }

        for (Produto produtoPedido : pedido.getProdutos()) {
            if(produtoPedido.getQuantidade() < 0){
                throw new IllegalArgumentException("A quantidade de produto não pode ser negativa.");
            }
            boolean produtoEncontrado = false;
            for (Produto p : produtos) {
                if (p.getCodigo().equals(produtoPedido.getCodigo())) {
                    produtoEncontrado = true; // Marca que o produto foi encontrado

                    if (p.getQuantidade() >= produtoPedido.getQuantidade()) {
                        p.setQuantidade(p.getQuantidade() - produtoPedido.getQuantidade());
                        System.out.println("Estoque atualizado: " + p.getNome());
                    } else {
                        throw new ErrosGeralEstoque("Erro ao atualizar estoque");
                    }
                    break;
                }
            }

            if (!produtoEncontrado) {
                throw new ProdutoNaoEncontradoException("Produto com código '" + produtoPedido.getCodigo() + "' não foi encontrado no estoque.");
            }
        }
    }
}