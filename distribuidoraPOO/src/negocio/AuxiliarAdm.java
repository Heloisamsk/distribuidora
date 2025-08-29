package negocio;
<<<<<<< HEAD
import dados.RepositorioCaminhao;
import dados.RepositorioCliente;
import dados.RepositorioFuncionario;
import dados.RepositorioProduto;
import negocio.exceptions.MatriculaJaExistenteException;
=======
import dados.*;
>>>>>>> main
import negocio.exceptions.CaminhaoNaoCadastradoException;
import negocio.exceptions.CpfJaExistenteException;
import negocio.exceptions.CaminhaoJaExisteException;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.List;

public class AuxiliarAdm extends Funcionario {
    private String login;
    //private ArrayList<Cliente> clientesLista;
    private final RepositorioCliente repositorioCliente = new RepositorioCliente();
    //private ArrayList<Funcionario> funcionariosLista;
    private final RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionario();
    //private ArrayList<Caminhao> caminhoesLista;
    private final RepositorioCaminhao repositorioCaminhao = new RepositorioCaminhao();
    //private ArrayList<Produto> produtosLista;
    private final RepositorioProduto repositorioProduto = new RepositorioProduto();
    //private Patio patio;
=======
import negocio.Funcionario;
import negocio.exceptions.VagaInsuficienteException;

public class AuxiliarAdm extends Funcionario {
    private String login;
    private ArrayList<Cliente> clientesLista;
    //private ArrayList<Caminhao> caminhoesLista;
    private ArrayList<Produto> produtosLista;

    private RepositorioCaminhao repCaminhao = new RepositorioCaminhao();
    private RepositorioEstoque repEstoque = new RepositorioEstoque();
    private RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
    private RepositorioPatio repPatio = new RepositorioPatio();
    private RepositorioCliente repCliente;
    private RepositorioEstoque repositorioEstoque;
>>>>>>> main
    private static final String loginCadastro = "adm2025";
    private Produto produto;

    public AuxiliarAdm(String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email, String login, String matricula, RepositorioCliente repCliente, RepositorioEstoque repEstoque, RepositorioPatio repPatio){
        super(cargo, salario, nome, idade, cpf, telefone, endereco, email, matricula);
        this.login = login;
<<<<<<< HEAD
        //this.patio = patio;
        /*this.clientesLista = new ArrayList<>();
        this.funcionariosLista = new ArrayList<>();
        this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();*/
    }
    public AuxiliarAdm(){
       //construtor vazio
        /*this.clientesLista = new ArrayList<>();
        this.funcionariosLista = new ArrayList<>();
        this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();*/
=======
        this.repCliente = repCliente;
        this.repEstoque = repEstoque;
        this.repPatio = repPatio;
        this.clientesLista = new ArrayList<>();
       // this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();
>>>>>>> main
    }

    public AuxiliarAdm(String login, String matricula){
        super(matricula);
        this.login = login;
        matricula = matricula;
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
<<<<<<< HEAD
        if(repositorioFuncionario.buscarPorMatricula(motorista.getMatricula()) != null){
            throw new MatriculaJaExistenteException("Matricula já cadastrada");
        }

        repositorioFuncionario.adicionar(motorista);
        motorista.setCadastrado(true);
        /*for (Funcionario f : funcionariosLista){
=======
        if(motorista.getNome() == null){
            throw new IllegalArgumentException("o nome nao pode ser nulo");
        }
        if(motorista.getCpf() == null){
            throw new IllegalArgumentException("O cpf nao pode ser null");
        }
        for (Funcionario f : repFuncionario.listarTodos()){
>>>>>>> main
            if (f.getCpf().equals(motorista.getCpf())){
                throw new CpfJaExistenteException("O CPF já está cadastrado.");
            }
        }
            if(repFuncionario.cadastrar(motorista)){
                motorista.setCadastrado(true);
            }*/
    }

    public List<Funcionario> listarFuncionarios(){
        return repositorioFuncionario.listarTodos();
    }

    public void removerFuncionario(Funcionario funcionario){
        repositorioFuncionario.remover(funcionario);
    }

    public void cadastrarCaminhao(Caminhao caminhao) {
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas o adminitrador com permissao pode cadastrar caminhoes");
        }
        if(caminhao == null){
            throw new IllegalArgumentException("O funcionario a ser cadastrado nao pode ser null");
        }
<<<<<<< HEAD
        if(repositorioCaminhao.buscarPorPlaca(caminhao.getPlaca()) != null){
            throw new CaminhaoJaExisteException("Caminhão já cadastrado");
        }

        repositorioCaminhao.adicionar(caminhao);

        /*for(Caminhao c : caminhoesLista){
            if(c.getPlaca().equals(caminhao.getPlaca())){
                throw new CaminhaoJaExisteException("Caminhao com essa placa ja cadastrado");
            }
=======
        if (repCaminhao.buscarPorPlaca(caminhao.getPlaca()) != null){
            throw new CaminhaoJaExisteException("Caminhao ja cadastrado");
>>>>>>> main
        }
        if(repCaminhao.cadastrar(caminhao)){
            System.out.println("Caminhao cadastrado com sucesso");
            caminhao.setCadastrado(true);
<<<<<<< HEAD
            System.out.println("caminhao cadastrado");
             //print na ui
        }*/
    }

    public List<Caminhao> listarCaminhao(Caminhao caminhao){
        return repositorioCaminhao.listarTodos();
    }

    public void removerCaminhao(Caminhao caminhao){
        repositorioCaminhao.remover(caminhao);
    }

=======
        }
    }
    public void cadastrarCaminhaoPatio(Caminhao caminhao, Patio patio){
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas o adminitrador com permissao pode cadastrar caminhoes");
        }
        if(caminhao == null || patio == null){
            throw new IllegalArgumentException("Caminhao ou patio nao podem ser nulos");
        }
        if (repPatio.buscarPorPlaca(caminhao.getPlaca()) != null){
            throw new CaminhaoJaExisteException("Caminhao ja cadastrado");
        }
        repPatio.cadastrarCaminhaoPatio(caminhao);


    }
>>>>>>> main
    // funcionando
    public void cadastrarCliente(Cliente cliente) {
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas o administrador pode cadastrar novos clientes");
        }
        if (cliente == null){
            throw new IllegalArgumentException("Cliente invalido.");
        }
<<<<<<< HEAD
        if(repositorioCliente.buscarPorCpf(cliente.getCpf()) != null){
            throw new CpfJaExistenteException("CPF já cadastrado");
        }
        repositorioCliente.adicionar(cliente);

        /*for (Cliente c : clientesLista){
            if (c.getCpf().equals(cliente.getCpf())){
                throw new CpfJaExistenteException("Cliente já cadastrado");
            }
=======
        if (repCliente.buscarPorCpf(cliente.getCpf()) != null) {
            throw new CpfJaExistenteException("Cliente já cadastrado");
>>>>>>> main
        }
        if (repCliente.cadastrar(cliente)) {
            System.out.println("Cliente cadastrado com sucesso!");
            cliente.setCadastrado(true);
        }*/
    }

    public List<Cliente> listarClientes(){
        return repositorioCliente.listarTodos();
    }

    public void removerCliente(Cliente cliente){
        repositorioCliente.remover(cliente);
    }

    public void cadastrarProduto(Produto produto, Estoque estoque){
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas administrades com permissao podem cadastrar um produto");
        }
        if (produto== null){
            throw new IllegalArgumentException("Produto inváido");
        }
<<<<<<< HEAD
        if (repositorioProduto.buscarPorCodigo(produto.getCodigo()) != null) {
            throw new ProdutoJaExistenteException("Produto já cadastrado");
        }
        repositorioProduto.cadastrarProduto(produto);

        //estoque.cadastrarProduto(produto);
        //System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o produto: " + produto.getNome());
        //esse print é só p mostrar e ele coloca na ui
    }

    public List<Produto> listarProdutos(){
        return repositorioProduto.listarTodos();
    }

    public void removerProduto(Produto produto){
        if(produto != null) {
            repositorioProduto.remover(produto.getCodigo());
        }
    }

    public void permitirEntrada(Caminhao caminhao, Patio patio) {
=======
        if(repEstoque.cadastrarProduto(produto, estoque)){
            System.out.println("produto cadastrado");
            produto.setCadastrado(true);
        }
    }

    public void permitirEntrada(Caminhao caminhao, Patio patio) throws VagaInsuficienteException {
>>>>>>> main
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
            caminhao.entrarPatio(patio, caminhao);

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
        patio.adicionarFilaSaida(caminhao);
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
            caminhao.sairPatio(patio);
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
    }

    public void ponto(String matricula){
        baterPonto(matricula);
    }

}