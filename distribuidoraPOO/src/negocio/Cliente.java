package negocio;

public class Cliente extends Pessoa {
    private String tipo;

    public Cliente(String nome, int idade, String cpf, String telefone, String endereco, String email, String tipo) {
        super(nome, idade, cpf, telefone, endereco, email);
        this.tipo = tipo;
    }

    public void realizarPedido(Pedido pedido) {
        System.out.println("Cliente " + getNome() + " fez o pedido " + pedido.getNumero());
    }

    public void realizarPagamento(double valor, String metodo) {
        System.out.println("Cliente " + getNome() + " pagou R$ " + valor + " usando: " + metodo);
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