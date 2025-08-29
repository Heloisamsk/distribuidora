package negocio;
import negocio.exceptions.CaminhaoNaoCadastradoException;
import negocio.exceptions.CpfJaExistenteException;
import negocio.exceptions.CaminhaoJaExisteException;
import java.util.ArrayList;
import dados.RepositorioCliente;
import dados.RepositorioEstoque;
import dados.RepositorioCaminhao;
import dados.RepositorioFuncionario;

public class AuxiliarAdm extends Funcionario {
    private String login;
    private ArrayList<Cliente> clientesLista;
    //private ArrayList<Caminhao> caminhoesLista;
    private ArrayList<Produto> produtosLista;

    private RepositorioCaminhao repCaminhao = new RepositorioCaminhao();
    private RepositorioEstoque repEstoque = new RepositorioEstoque();
    private RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
    private RepositorioCliente repCliente;
    private RepositorioEstoque repositorioEstoque;
    private static final String loginCadastro = "adm2025";
    private Produto produto;

    public AuxiliarAdm(String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email, String login, String matricula, RepositorioCliente repCliente, RepositorioEstoque repEstoque){
        super(cargo, salario, nome, idade, cpf, telefone, endereco, email, matricula);
        this.login = login;
        this.repCliente = repCliente;
        this.repEstoque = repEstoque;
        this.clientesLista = new ArrayList<>();
       // this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();
    }

    public AuxiliarAdm(){
        this.clientesLista = new ArrayList<>();
       // this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();
    }

    public void cadastrarMotorista(Motorista motorista) {
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas o adminitrador com permissao pode cadastrar funcionarios");
        }
        if (motorista == null) {
            throw new IllegalArgumentException("O funcionário a ser cadastrado não pode ser nulo.");
        }
        if(motorista.getNome() == null){
            throw new IllegalArgumentException("o nome nao pode ser nulo");
        }
        if(motorista.getCpf() == null){
            throw new IllegalArgumentException("O cpf nao pode ser null");
        }
        for (Funcionario f : repFuncionario.listarTodos()){
            if (f.getCpf().equals(motorista.getCpf())){
                throw new CpfJaExistenteException("O CPF já está cadastrado.");
            }
        }
            if(repFuncionario.cadastrar(motorista)){
                motorista.setCadastrado(true);
            }
    }
    public void cadastrarCaminhao(Caminhao caminhao) {
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas o adminitrador com permissao pode cadastrar caminhoes");
        }
        if(caminhao == null){
            throw new IllegalArgumentException("O funcionario a ser cadastrado nao pode ser null");
        }
        if (repCaminhao.buscarPorPlaca(caminhao.getPlaca()) != null){
            throw new CaminhaoJaExisteException("Caminhao ja cadastrado");
        }
        if(repCaminhao.cadastrar(caminhao)){
            System.out.println("Caminhao cadastrado com sucesso");
            caminhao.setCadastrado(true);
        }
    }
    // funcionando
    public void cadastrarCliente(Cliente cliente) {
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas o administrador pode cadastrar novos clientes");
        }
        if (cliente == null){
            throw new IllegalArgumentException("Cliente invalido.");
        }
        if (repCliente.buscarPorCpf(cliente.getCpf()) != null) {
            throw new CpfJaExistenteException("Cliente já cadastrado");
        }
        if (repCliente.cadastrar(cliente)) {
            System.out.println("Cliente cadastrado com sucesso!");
            cliente.setCadastrado(true);
        }
    }

    public void cadastrarProduto(Produto produto, Estoque estoque){
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas administrades com permissao podem cadastrar um produto");
        }
        if (produto== null){
            throw new IllegalArgumentException("Produto inváido");
        }
        if(repEstoque.cadastrarProduto(produto, estoque)){
            System.out.println("produto cadastrado");
            produto.setCadastrado(true);
        }
    }

    public void permitirEntrada(Caminhao caminhao, Patio patio) {
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas administradores com autorizacao podem permitir a entrada de caminhoes");
        }
        if (caminhao == null){
            throw new IllegalArgumentException("Caminhão inválido.");
        }
        if(patio == null){
            throw new IllegalArgumentException("Patio inválido.");
        }
        if(!caminhao.getCadastrado()){
            throw new CaminhaoNaoCadastradoException("caminhao nao esta cadastrado");
        }
        boolean entrou = patio.adicionarCaminhao(caminhao);
        if(entrou){
            System.out.println("caminhao entrou no patio.");

        }else{
            System.out.println("o caminhao foi pra fila de espera de entrada no patio");
        }
    }
    //funcionando
    // primeiro tem que add na fila de saida e depois permitir a saida
    public void adicionarNaFilaSaida(Caminhao caminhao, Patio patio){
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas administradores com autorizacao podem permitir a saida de caminhoes");
        }
        if (caminhao == null){
            throw new IllegalArgumentException("Caminhão inválido.");
        }
        if(patio == null){
            throw new IllegalArgumentException("Patio inválido.");
        }

        // Adiciona o caminhão na fila de saída e nao usa o print, logo nao precisa usar o boolean
        patio.adicionarFilaSaida(caminhao);
   // }

        /*boolean filaSaida = patio.adicionarFilaSaida(caminhao);
        if(filaSaida){
            System.out.println("caminhao esta na fila de saida");
        }*/

    }
    // funcionando
    public void permitirSaida(Caminhao caminhao, Patio patio){
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas administradores com autorizacao podem permitir a saida de caminhoes");
        }
        if (caminhao == null){
            throw new IllegalArgumentException("Caminhão inválido.");
       }
        if(patio == null){
            throw new IllegalArgumentException("Patio inválido.");
        }
        if(patio.liberarSaida(caminhao)){
            System.out.println("caminhao saiu do patio.");
        }
    }

    public void atualizarPreco(Produto produto, double novoPreco){
        if(novoPreco<0){
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        } else if (novoPreco==0){
            throw new IllegalArgumentException("O produto não pode custar 0");
        }
        produto.setPreco(novoPreco);
        System.out.println("novo: " + novoPreco);
    }

    public void ponto(String matricula){
        baterPonto(matricula);
    }

}