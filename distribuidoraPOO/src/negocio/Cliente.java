package negocio;

public class Cliente {

    public Cliente(String nome, String cpf, String telefone, String endereco, String email, String tipo) {
        super(nome, cpf, telefone, endereco, email);
        this.tipo = tipo;
    }

    public void realizarPedido(Pedido pedido) {
        System.out.println("Cliente " + this.getNome() + " fez o pedido " + pedido.getId() + ".");
        // Lógica para processar o pedido.
    }

    public void realizarPagamento(double valor, String metodo) {
        System.out.println("Cliente " + this.getNome() + " pagou R$:" + valor + " usando:" + metodo);
        // Lógica para processar o pagamento.
    }

    public void status() {
        System.out.println("Status do cliente:");
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Tipo: " + this.getTipo());
    }

    // gett e sett tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}