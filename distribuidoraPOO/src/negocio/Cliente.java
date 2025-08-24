package negocio;
import java.util.ArrayList;

public class Cliente extends Pessoa {
    private String tipo;

    public Cliente(String nome, int idade, String cpf, String telefone, String endereco, String email, String tipo) {
        super(nome, idade, cpf, telefone, endereco, email);
        this.tipo = tipo;
    }

    public void realizarPedido(Pedido pedido, ArrayList<Produto> produtosSolicitados) {
        System.out.println("Cliente " + getNome() + " iniciou o pedido de número: " + pedido.getNumero());

        for (Produto produto : produtosSolicitados) {
            pedido.adicionarProduto();
        }

        pedido.alterarStatus("Pendente");

        System.out.println("Pedido criado com sucesso! Status: " + pedido.getStatus());
        System.out.println("Valor total do pedido: R$ " + pedido.getValorTotal());
    }

    public void realizarPagamento(Pedido pedido, double valor, String metodo) {
        System.out.println("Cliente " + getNome() + " realizou o pagamento de R$ " + valor + " usando: " + metodo);

        if (valor >= pedido.getValorTotal()) {
            pedido.alterarStatus("Pago");
            System.out.println("Pagamento processado com sucesso! Status do pedido: " + pedido.getStatus());
        } else {
            System.out.println("Valor do pagamento insuficiente.");
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
        this.tipo = tipo;
    }
}