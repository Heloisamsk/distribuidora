package negocio;

import java.util.ArrayList;
import java.util.Objects;

//try tentar -> tenta executar
//catch -> capturar pega os erros

public class Cliente extends Pessoa {
    private String tipo;

    public Cliente(String nome, int idade, String cpf, String telefone, String endereco, String email, String tipo) {
        super(nome, idade, cpf, telefone, endereco, email);

        if (nome == null || nome.trim().isEmpty()) { //isso de .trim é pra remover os espaços vazios da string
            throw new IllegalArgumentException("O cliente não pode ser alguém misterioso sem nome");
        }
        if (idade <= 0) {
            throw new IllegalArgumentException("Não tem como ter idade negativa/voltar no tempo");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF não é brincadeira não é mesmo");
        }

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("Faltou o tipo do cliente");
        }
        this.tipo = tipo;
    }

    public void realizarPedido(Pedido pedido, ArrayList<Produto> produtosSolicitados) {
        if (pedido == null) {
            throw new IllegalArgumentException("Faltou o pedido");
        }
        if (produtosSolicitados == null || produtosSolicitados.isEmpty()) {
            throw new IllegalArgumentException("Nao tem como comprar lista de produtos vazios");
        }

        if (!"Aberto".equals(pedido.getStatus()) && !"Pendente".equals(pedido.getStatus())) {
            throw new IllegalStateException("Não da pra adicionar produtos a um pedido com status: " + pedido.getStatus());
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
        Objects.requireNonNull(pedido, "Nao da pra pedir objeto inexistente");
        if (valor <= 0) {
            throw new IllegalArgumentException("Nao da pra pagar com dinheiro negativo");
        }
        if (metodo == null || metodo.trim().isEmpty()) {
            throw new IllegalArgumentException("Faltou falar se vai pagar usando pix/dinheir/cartao");
        }

        if ("Pago".equals(pedido.getStatus())) {
            throw new IllegalStateException("Já foi pago.");
        }
        if ("Cancelado".equals(pedido.getStatus())) {
            throw new IllegalStateException("Não da pra pagar um pedido cancelado.");
        }

        System.out.println("Cliente " + getNome() + " fez o pagamento de R$ " + valor + " usando: " + metodo);

        if (valor >= pedido.getValorTotal()) {
            pedido.alterarStatus("Pago");
            System.out.println("Pagamento processado! Status do pedido: " + pedido.getStatus());
        } else {
            throw new IllegalArgumentException("Valor do pagamento (R$ " + valor + ") é insuficiente para quitar o pedido (R$ " + pedido.getValorTotal() + ").");
        }
    }

    public void status() {
        System.out.println("Status do cliente:");
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
            throw new IllegalArgumentException("Faltou o tipo do cliente");
        }
        this.tipo = tipo;
    }
}