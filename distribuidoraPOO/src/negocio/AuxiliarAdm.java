package negocio;

public class AuxiliarAdm extends Funcionario {
    private String login;

    public AuxiliarAdm(String nome, String cpf, String telefone, String endereco, String email, String cargo, double salario, String login) {
        super(nome, cpf, telefone, endereco, email, cargo, salario);
        this.login = login;
    }

    public void cadastrarFuncionario(Funcionario f) {
        System.out.println("AuxiliarADM " + this.getNome() + " cadastrou o funcionário: " + f.getNome());
    }

    public void cadastrarCaminhao(Caminhao c) {
        System.out.println("AuxiliarADM " + this.getNome() + " cadastrou o caminhão da placa: " + c.getPlaca());
    }

    public void cadastrarCliente(Cliente c) {
        System.out.println("AuxiliarADM " + this.getNome() + " cadastrou o cliente: " + c.getNome());
    }

    public void cadastrarProduto(Produto p) {
        System.out.println("AuxiliarADM " + this.getNome() + " cadastrou o produto: " + p.getNome());
    }


    public void permitirEntrada(Caminhao c) {
        System.out.println("AuxiliarADM " + this.getNome() + " permitiu a entrada do caminhão da placa: " + c.getPlaca());
    }

    //gett e sett login
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
