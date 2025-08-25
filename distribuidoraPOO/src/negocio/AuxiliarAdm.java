package negocio;
import negocio.exceptions.CpfJaExistenteException;
import negocio.exceptions.EntradaImpossibilitadaException;
import negocio.exceptions.ProdutoJaExistenteException;

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
        if (funcionario == null) {
            throw new IllegalArgumentException("O funcionário a ser cadastrado não pode ser nulo.");
        }
        for (Funcionario f : funcionariosLista){
            if (f.getCpf().equals(funcionario.getCpf())){
                throw new CpfJaExistenteException("O CPF já está cadastrado.");
            }
        }
            funcionariosLista.add(funcionario);
            System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o funcionário: " + funcionario.getNome());

    }

    public void cadastrarCaminhao(Caminhao caminhao) {
        caminhoesLista.add(caminhao);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o caminhão da placa: " + caminhao.getPlaca());
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente == null){
            throw new IllegalArgumentException("Cliente inválido");
        }
        for (Cliente c : clientesLista){
            if (c.getCpf().equals(cliente.getCpf())){
                throw new CpfJaExistenteException("Cliente já cadastrado");
            }
        }
        clientesLista.add(cliente);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o cliente: " + cliente.getNome());
    }

    public void cadastrarProduto(Produto produto) throws ProdutoJaExistenteException {
        if (produto== null){
            throw new IllegalArgumentException("Produto inváido");
        }
        for (Produto prod : produtosLista){
            if (prod.getCodigo().equals(produto.getCodigo())){
                throw new ProdutoJaExistenteException("O produto já está cadastrado.");
            }
        }
        produtosLista.add(produto);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o produto: " + produto.getNome());
    }

    public void permitirEntrada(Caminhao caminhao, Patio patio) {
        if (caminhao == null){
            throw new IllegalArgumentException("Caminhão inválido.");
        }
        if(patio.getVagasDisponiveis() < 1){
            throw new EntradaImpossibilitadaException("Pátio está cheio, não é possivel permitir entrada.");
        }
        patio.adicionarCaminhao(caminhao);
    }

    public void ponto(String matricula){
        baterPonto(matricula);
    }

}