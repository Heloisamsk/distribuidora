package fachada;

import dados.RepositorioCliente;
import dados.RepositorioFuncionario;
import dados.RepositorioEstoque;
import negocio.*;
import negocio.AuxiliarAdm;
import java.util.List;
import java.util.ArrayList;
public class DistribuidoraFachada {
    private RepositorioCliente repositorioCliente = new RepositorioCliente();
    private RepositorioEstoque repositorioEstoque = new RepositorioEstoque();
    private RepositorioFuncionario repFuncionario = new RepositorioFuncionario();
    AuxiliarAdm adm = new AuxiliarAdm("adm", 800.00, "Luicas", 35, "789549", "879985664",
            "Rua F", "licas@gmail.com", "adm2025", "1234", repositorioCliente, repositorioEstoque);

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
    public void cadastrarCaminhao(Caminhao caminhao){
        adm.cadastrarCaminhao(caminhao);
    }
    public void cadastrarMotorista(AuxiliarAdm adm, Motorista motorista){
        adm.cadastrarMotorista(motorista);
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

    // REMOVER
    public boolean removerCliente(String cpf) {
        return this.repositorioCliente.remover(cpf);
    }

    public boolean removerProduto(String codigo) {
        return this.repositorioEstoque.remover(codigo);
    }



    public Pedido criarPedido(Cliente cliente, ArrayList<Produto> produtosDesejados, Estoque estoque) {
        cliente.realizarPedido(produtosDesejados, estoque);
        List<Pedido> pedidos = cliente.getPedidos();
        return (Pedido)pedidos.get(pedidos.size() - 1);
    }

    public void pagarPedido(Cliente cliente, Pedido pedido, double valorPago, Estoque estoque) {
        cliente.realizarPagamento(pedido, valorPago, estoque);
    }

    public Venda registrarVenda(Pedido pedido, NotaFiscal notaFiscal) {
        Venda venda = new Venda(pedido, notaFiscal);
        venda.finalizarPedido();
        return venda;
    }


}
