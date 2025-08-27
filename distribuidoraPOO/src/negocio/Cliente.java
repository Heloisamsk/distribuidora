package negocio;

import negocio.exceptions.ClienteInvalidoException;
import negocio.exceptions.ClienteNaoExisteException;
import negocio.exceptions.PagamentoException;
import negocio.exceptions.StatusInvalidoException;
import negocio.Estoque;


import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
public class Cliente extends Pessoa {
    private String tipo;
    private boolean cadastrado = false;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, int idade, String cpf, String telefone, String endereco, String email, String tipo) {
        super(nome, idade, cpf, telefone, endereco, email);

        if (nome == null || nome.trim().isEmpty()) {
            throw new ClienteInvalidoException("O nome do cliente não pode ser vazio.");
        }
        if (idade <= 0) {
            throw new ClienteInvalidoException("A idade do cliente deve ser maior que zero.");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new ClienteInvalidoException("O CPF do cliente não pode ser vazio.");
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ClienteInvalidoException("O tipo do cliente não pode ser vazio.");
        }
        this.tipo = tipo;
    }
    public boolean isCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }

    public void realizarPedido(ArrayList<Produto> produtosDesejados, Estoque estoque) {
        if (!cadastrado) {
            throw new ClienteNaoExisteException("Cliente não cadastrado.");
        }
        if (produtosDesejados == null || produtosDesejados.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser vazia.");
        }

        ArrayList<Produto> produtosParaPedido = new ArrayList<>();

        for (Produto produtoDesejado : produtosDesejados) {
            Produto produtoEstoque = estoque.consultarProduto(produtoDesejado.getCodigo());

            if (produtoEstoque.getQuantidade() < produtoDesejado.getQuantidade()) {
                throw new RuntimeException(
                        "Estoque insuficiente para o produto: " + produtoDesejado.getNome());
            }

            // Adiciona o produto "real" do estoque ao pedido
            produtosParaPedido.add(new Produto(
                    produtoEstoque.getCodigo(),
                    produtoEstoque.getNome(),
                    produtoEstoque.getDescricao(),
                    produtoEstoque.getPreco(),
                    produtoDesejado.getQuantidade()
            ));
        }

        Pedido novoPedido = new Pedido(produtosParaPedido);
        pedidos.add(novoPedido);

        System.out.println("Cliente " + getNome() + " iniciou o pedido de número: " + novoPedido.getNumero());
        // gerar nota fiscal
        System.out.println("Total: R$ " + novoPedido.getValorTotal());
    }


    public void realizarPagamento(Pedido pedido, double valorPago, Estoque estoque) {
        if (!cadastrado) {
            throw new ClienteNaoExisteException("Cliente não cadastrado.");
        }
        if (pedido == null || !pedidos.contains(pedido)) {
            throw new IllegalArgumentException("Pedido inválido ou não pertence a este cliente.");
        }
        if ("Pago".equalsIgnoreCase(pedido.getStatus())) {
            throw new IllegalStateException("Pedido já foi pago.");
        }
        if ("Cancelado".equalsIgnoreCase(pedido.getStatus())) {
            throw new IllegalStateException("Não é possível pagar um pedido cancelado.");
        }
        if (valorPago < pedido.getValorTotal()) {
            throw new IllegalArgumentException(
                    "Valor pago insuficiente. Total do pedido: R$ " + pedido.getValorTotal());
        }

        // Muda o status do pedido
        pedido.setStatus("Pago");

        // Atualiza o estoque
        for (Produto produtoPedido : pedido.getProdutos()) {
            Produto produtoEstoque = estoque.consultarProduto(produtoPedido.getCodigo());
            produtoEstoque.setQuantidade(produtoEstoque.getQuantidade() - produtoPedido.getQuantidade());
        }

        System.out.println("Pagamento realizado com sucesso! Pedido #" + pedido.getNumero() +
                " agora está com status: " + pedido.getStatus());
    }


    public void status() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("CPF: " + getCpf());
        System.out.println("Tipo: " + getTipo());
    }

    public String getTipo() {
        return tipo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ClienteInvalidoException("O tipo do cliente não pode ser vazio.");
        }
        this.tipo = tipo;
    }
}