package negocio;

import negocio.exceptions.ClienteInvalidoException;
import negocio.exceptions.ClienteNaoExisteException;
import negocio.exceptions.PagamentoException;
import negocio.exceptions.StatusInvalidoException;


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
    /*public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }*/

    public boolean isCadastrado() {
        return cadastrado;
    }

    public void setCadastrado(boolean cadastrado) {
        this.cadastrado = cadastrado;
    }

    public void realizarPedido(ArrayList<Produto> produtos) {
        if (!cadastrado) {
            throw new ClienteNaoExisteException("Cliente não cadastrado.");
        }
        if (produtos == null || produtos.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser vazia.");
        }
        Pedido novoPedido = new Pedido(produtos);
        pedidos.add(novoPedido);
        System.out.println("Cliente " + getNome() + " iniciou o pedido de número: " + novoPedido.getNumero());
        System.out.println("Total: R$ " + novoPedido.getValorTotal());
    }

    public void realizarPagamento(Pedido pedido, double valor, String metodo) {
        Objects.requireNonNull(pedido, "O pedido não pode ser nulo.");

        if (valor <= 0) {
            throw new PagamentoException("O valor do pagamento deve ser maior que zero.");
        }
        if (metodo == null || metodo.trim().isEmpty()) {
            throw new PagamentoException("O método de pagamento não pode ser vazio.");
        }

        if ("PAGO".equalsIgnoreCase(pedido.getStatus())) {
            throw new StatusInvalidoException("O pedido já foi pago.");
        }
        if ("CANCELADO".equalsIgnoreCase(pedido.getStatus())) {
            throw new StatusInvalidoException("Não é possível pagar um pedido cancelado.");
        }

        /*if (valor == pedido.getValorTotal()) {
            pedido.alterarStatus("Pago");
        } else {
            throw new PagamentoException("Valor do pagamento (R$ " + valor + ") é insuficiente para quitar o pedido (R$ " + pedido.getValorTotal() + ").");
        }

         */
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

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new ClienteInvalidoException("O tipo do cliente não pode ser vazio.");
        }
        this.tipo = tipo;
    }
}