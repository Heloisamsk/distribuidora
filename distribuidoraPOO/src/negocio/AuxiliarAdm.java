package negocio;
import negocio.exceptions.CpfJaExistenteException;
import negocio.exceptions.ProdutoJaExistenteException;
import negocio.exceptions.CaminhaoJaExisteException;
import java.util.ArrayList;

public class AuxiliarAdm extends Funcionario {
    private String login;
    private ArrayList<Cliente> clientesLista;
    private ArrayList<Funcionario> funcionariosLista;
    private ArrayList<Caminhao> caminhoesLista;
    private ArrayList<Produto> produtosLista;
    //private Patio patio;
    private static final String loginCadastro = "adm2025";
    private Produto produto;

    public AuxiliarAdm(String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email, String login, String matricula){
        super(cargo, salario, nome, idade, cpf, telefone, endereco, email, matricula);
        this.login = login;
        //this.patio = patio;
        this.clientesLista = new ArrayList<>();
        this.funcionariosLista = new ArrayList<>();
        this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();
    }
    public AuxiliarAdm(){
        this.clientesLista = new ArrayList<>();
        this.funcionariosLista = new ArrayList<>();
        this.caminhoesLista = new ArrayList<>();
        this.produtosLista = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void cadastrarMotorista(Motorista motorista) {
        if(!loginCadastro.equals(this.login)){
            throw new SecurityException("Apenas o adminitrador com permissao pode cadastrar funcionarios");
        }
        if (motorista == null) {
            throw new IllegalArgumentException("O funcionário a ser cadastrado não pode ser nulo.");
        }
        for (Funcionario f : funcionariosLista){
            if (f.getCpf().equals(motorista.getCpf())){
                throw new CpfJaExistenteException("O CPF já está cadastrado.");
            }
        }
            if(funcionariosLista.add(motorista)){
                System.out.println("func cadastrado");
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
        for(Caminhao c : caminhoesLista){
            if(c.getPlaca().equals(caminhao.getPlaca())){
                throw new CaminhaoJaExisteException("Caminhao com essa placa ja cadastrado");
            }
        }
        if(caminhoesLista.add(caminhao)){
            caminhao.setCadastrado(true);
            //System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o caminhão com placa: " + caminhao.getPlaca());
             //print na ui
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
        for (Cliente c : clientesLista){
            if (c.getCpf().equals(cliente.getCpf())){
                throw new CpfJaExistenteException("Cliente já cadastrado");
            }
        }
        if(clientesLista.add(cliente)){
            System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o cliente: " + cliente.getNome());
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
        estoque.cadastrarProduto(produto);
        //System.out.println("AuxiliarAdm " + this.getNome() + " cadastrou o produto: " + produto.getNome());
        //esse print é só p mostrar e ele coloca na ui
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

        patio.adicionarCaminhao(caminhao); // só executa a ação e o if e else faz na ui com os prints

        if(patio.adicionarCaminhao(caminhao)){
            System.out.println("caminhao entrou no patio.");

        }else{
            System.out.println("o caminhao foi pra fila de espera de entrada no patio");
        }
    }
    //funcionando
    // primeiro tem que add na fila de saida e depois permitir a saida
    public void adicionarNaFilaSaida(String login, Caminhao caminhao, Patio patio){
        if(!loginCadastro.equals(login)){
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
    public void permitirSaida(String login, Caminhao caminhao, Patio patio){
        if(!loginCadastro.equals(login)){
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
    }

    public void ponto(String matricula){
        baterPonto(matricula);
    }

}