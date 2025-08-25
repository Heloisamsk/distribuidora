package negocio;
import java.util.ArrayList;


public class AuxiliarAdm extends Funcionario {
    private String login;
    private ArrayList<Cliente> clientesLista;
    private ArrayList<Funcionario> funcionariosLista;
    private ArrayList<Caminhao> caminhoesLista;
    private ArrayList<Produto> produtosLista;
    private Patio patio;

    public AuxiliarAdm(Patio patio, String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email, String login, String matricula) {
        super(cargo, salario, nome, idade, cpf, telefone, endereco, email, matricula);
        this.login = login;
        this.patio = patio;

        this.clientesLista = new ArrayList<>();
        this.funcionariosLista = new ArrayList<>();
        this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();
    }
    public AuxiliarAdm(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionariosLista.add(funcionario);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o funcionário: " + funcionario.getNome());
    }

    public void cadastrarCaminhao(Caminhao caminhao) {
        caminhoesLista.add(caminhao);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o caminhão da placa: " + caminhao.getPlaca());
    }

    public void cadastrarCliente(Cliente cliente) {
        clientesLista.add(cliente);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o cliente: " + cliente.getNome());
    }

    public void cadastrarProduto(Produto produto) {
        produtosLista.add(produto);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o produto: " + produto.getNome());
    }

    public void permitirEntrada(Caminhao caminhao) {
        patio.adicionarCaminhao(caminhao);
    }
    public void ponto(String matricula){
        baterPonto(matricula);
    }

}