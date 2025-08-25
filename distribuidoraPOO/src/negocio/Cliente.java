package negocio;

import negocio.exceptions.ClienteInvalidoException;
import negocio.exceptions.PagamentoException;
import negocio.exceptions.StatusInvalidoException;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Pessoa {
    private String tipo;

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

    public void realizarPedido(Pedido pedido, ArrayList<Produto> produtosSolicitados) {
        Objects.requireNonNull(pedido, "O pedido não pode ser nulo.");

        if (produtosSolicitados == null || produtosSolicitados.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos solicitados não pode ser vazia.");
        }

        if (!"Aberto".equalsIgnoreCase(pedido.getStatus()) && !"Pendente".equalsIgnoreCase(pedido.getStatus())) {
            throw new StatusInvalidoException("Não é possível adicionar produtos a um pedido com o status: " + pedido.getStatus());
        }

        System.out.println("Cliente " + getNome() + " iniciou o pedido de número: " + pedido.getNumero());

        for (Produto produto : produtosSolicitados) {
            pedido.adicionarProduto(produto);
        }

        pedido.alterarStatus("Pendente");

        System.out.println("Pedido criado! Status: " + pedido.getStatus());
        System.out.println("Valor total do pedido: R$ " + pedido.getValorTotal());
    }

    public void realizarPagamento(Pedido pedido, double valor, String metodo) {
        Objects.requireNonNull(pedido, "O pedido não pode ser nulo.");

        if (valor <= 0) {
            throw new PagamentoException("O valor do pagamento deve ser maior que zero.");
        }
        if (metodo == null || metodo.trim().isEmpty()) {
            throw new PagamentoException("O método de pagamento não pode ser vazio.");
        }

        if ("Pago".equalsIgnoreCase(pedido.getStatus())) {
            throw new StatusInvalidoException("O pedido já foi pago.");
        }
        if ("Cancelado".equalsIgnoreCase(pedido.getStatus())) {
            throw new StatusInvalidoException("Não é possível pagar um pedido cancelado.");
        }

        System.out.println("Cliente " + getNome() + " fez o pagamento de R$ " + valor + " usando: " + metodo);

        if (valor >= pedido.getValorTotal()) {
            pedido.alterarStatus("Pago");
            System.out.println("Pagamento processado! Status do pedido: " + pedido.getStatus());
        } else {
            throw new PagamentoException("Valor do pagamento (R$ " + valor + ") é insuficiente para quitar o pedido (R$ " + pedido.getValorTotal() + ").");
        }
    }

    public void status() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("CPF: " + getCpf());
        System.out.println("Tipo: " + tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ClienteInvalidoException("O tipo do cliente não pode ser vazio.");
        }
        this.tipo = tipo;
    }
}