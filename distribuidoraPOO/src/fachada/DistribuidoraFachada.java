package fachada;

import dados.RepositorioCliente;
import dados.RepositorioFuncionario;
import dados.RepositorioEstoque;
import dados.RepositorioPatio;
import negocio.*;
import negocio.AuxiliarAdm;
import java.util.List;
import java.util.ArrayList;
public class DistribuidoraFachada {
    private RepositorioCliente repositorioCliente = new RepositorioCliente();
    private RepositorioEstoque repositorioEstoque = new RepositorioEstoque();
    private RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
    private RepositorioPatio repPatio = new RepositorioPatio();
    private NotaFiscal notaFiscal = new NotaFiscal();

    AuxiliarAdm adm = new AuxiliarAdm("adm", 800.00, "Luicas", 35, "789549", "879985664",
            "Rua F", "licas@gmail.com", "adm2025", "1234", repositorioCliente, repositorioEstoque, repPatio);

    // CADASTROS
    public void cadastrarMotorista(Motorista motorista){
        adm.cadastrarMotorista(motorista);
    }
    public void cadastrarCliente(Cliente cliente) {
        adm.cadastrarCliente(cliente);
    }
    public void cadastrarProduto(Produto produto, Estoque estoque) {
        adm.cadastrarProduto(produto, estoque);
    }
    public void cadastrarCaminhao(Caminhao caminhao, Patio patio){
        adm.cadastrarCaminhao(caminhao);
        adm.cadastrarCaminhaoPatio(caminhao, patio);
    }



    // BUSCAR
    public Cliente buscarClientePorCpf(String cpf) {
        return this.repositorioCliente.buscarPorCpf(cpf);
    }
    public Produto buscarProdutoPorCodigo(String codigo) {
        return this.repositorioEstoque.buscarPorCodigo(codigo);
    }
    //LISTAR
    public void listarProdutos() {
        this.repositorioEstoque.listarTodos();
    }
    public void listarClientes() {
        this.repositorioCliente.listarTodos();
    }
    public void listarCaminhoesPatio(){this.repPatio.listarTodos();}

    // REMOVER
    public boolean removerCliente(String cpf) {
        return this.repositorioCliente.remover(cpf);
    }

    public boolean removerProduto(String codigo) {
        return this.repositorioEstoque.remover(codigo);
    }


    // FUNCIONALIDADES
    public void permitirEntrada(Caminhao caminhao, Patio patio){
        adm.permitirEntrada(caminhao, patio);
    }
    public void adicionarFilaSaida(Caminhao caminhao, Patio patio){
        adm.adicionarNaFilaSaida(caminhao, patio);
    }
    public void permirSaida(Caminhao caminhao, Patio patio){
        adm.permitirSaida(caminhao, patio);
    }
    public void baterPonto(Funcionario funcionario){
        funcionario.baterPonto(funcionario.getMatricula());
    }
    public void atualizarPreco(Produto produto, double novoPreco){
        adm.atualizarPreco(produto,novoPreco);
    }
    public Pedido criarPedido(Cliente cliente, ArrayList<Produto> produtosDesejados, Estoque estoque) {

        Pedido pedido = new Pedido(produtosDesejados);
        cliente.realizarPedido(produtosDesejados, estoque);
        List<Pedido> pedidos = cliente.getPedidos();
        System.out.println("Gerando nota fiscal...");
        notaFiscal.gerarNotaFiscal(produtosDesejados, pedido);
        return (Pedido)pedidos.get(pedidos.size() - 1);
    }

    public void pagarPedido(Cliente cliente, Pedido pedido, double valorPago, Estoque estoque) {
        cliente.realizarPagamento(pedido, valorPago, estoque);

    }
}
