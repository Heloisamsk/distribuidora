package negocio;
import negocio.exceptions.CpfJaExistenteException;
import negocio.exceptions.EntradaImpossibilitadaException;
import negocio.exceptions.ProdutoJaExistenteException;
import negocio.exceptions.CaminhaoJaExisteException;
import java.util.ArrayList;


public class AuxiliarAdm extends Funcionario {
    private String login;
    private ArrayList<Cliente> clientesLista;
    private ArrayList<Funcionario> funcionariosLista;
    private ArrayList<Caminhao> caminhoesLista;
    private ArrayList<Produto> produtosLista;
    private Patio patio;
    private static final String loginCadastro = "adm2025";
    private Produto produto;

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

    public void cadastrarFuncionario(String login, Funcionario funcionario) {
        if(!loginCadastro.equals(login)){
            throw new SecurityException("Apenas o adminitrador com permissao pode cadastrar funcionarios");
        }
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
    public void cadastrarCaminhao(String login, Caminhao caminhao) {
        if(!loginCadastro.equals(login)){
            throw new SecurityException("Apenas o adminitrador com permissao pode cadastrar caminhoes");
        }
        if(caminhao == null){
            throw new IllegalArgumentException("O funcionario a ser cadastrado nao pode ser null");
        }
        for(Caminhao c : caminhoesLista){
            if(c.getPlaca().equals(caminhao.getPlaca())){
                throw new CaminhaoJaExisteException("Caminhao com essa placa ja cadastrado");
            }
        }
        caminhoesLista.add(caminhao);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o caminhão com placa: " + caminhao.getPlaca());
    }

    public void cadastrarCliente(String login, Cliente cliente) {
        if(!loginCadastro.equals(login)){
            throw new SecurityException("Apenas o administrador pode cadastrar novos clientes");
        }
        if (cliente == null){
            throw new IllegalArgumentException("Cliente invalido.");
        }
        for (Cliente c : clientesLista){
            if (c.getCpf().equals(cliente.getCpf())){
                throw new CpfJaExistenteException("Cliente já cadastrado");
            }
        }
        clientesLista.add(cliente);
        System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o cliente: " + cliente.getNome());
    }

    public void cadastrarProduto(String login,Produto produto) throws ProdutoJaExistenteException {
        if(!loginCadastro.equals(login)){
            throw new SecurityException("Apenas administrades com permissao podem cadastrar um produto");
        }
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

    public void permitirEntrada(String login, Caminhao caminhao, Patio patio) {
        if(!loginCadastro.equals(login)){
            throw new SecurityException("Apenas administradores com autorizacao podem permitir a entrada de caminhoes");
        }
        if (caminhao == null){
            throw new IllegalArgumentException("Caminhão inválido.");
        }
        if(patio == null){
            throw new IllegalArgumentException("Patio inválido.");
        }
        if(patio.adicionarCaminhao(caminhao)){
            System.out.println("caminhao entrou no patio.");

        }else{
            System.out.println("o caminhao foi pra fila de espera de entrada no patio");
        }
    }

    public void atualizarPreco(Produto produto, double novoPreco){
        if(novoPreco<0){
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        } else if (novoPreco==0){
            throw new IllegalArgumentException("O produto não pode custar 0");
        }
        produto.setPreco(novoPreco);
    }

    public void ponto(String matricula){
        baterPonto(matricula);
    }

}