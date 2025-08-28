package fachada;
import negocio.*;
import negocio.exceptions.ClienteNaoExisteException;
import dados.RepositorioCliente;
import dados.*;

import java.util.ArrayList;

public class DistrubuidoraFachada {

    /* Pacote : fachada
Responsabilidade: Servir de intermediário entre UI e as camadas internas.

DistribuidoraFachada

Métodos como:

cadastrarCliente(Cliente c)

registrarVenda(Venda v)

adicionarProdutoEstoque(Produto p)

agendarEntradaCaminhao(Agendamento a)

Chama Comunicação e Negócios.

        //cliente ok
        private final RepositorioCliente repositorioCliente = new RepositorioCliente();

        public void realizarPedido(String cpfCliente, ArrayList<Produto> produtosDesejados, Estoque estoque) {
            Cliente cliente = repositorioCliente.buscarPorCpf(cpfCliente);
            if (cliente == null || !cliente.isCadastrado()) {
                throw new ClienteNaoExisteException("Cliente não cadastrado.");
            }
            cliente.realizarPedido(produtosDesejados, estoque);
        }

        public void realizarPagamento(String cpfCliente, Pedido pedido, double valorPago, Estoque estoque) {
            Cliente cliente = repositorioCliente.buscarPorCpf(cpfCliente);
            if (cliente == null || !cliente.isCadastrado()) {
                throw new ClienteNaoExisteException("Cliente não cadastrado.");
            }
            cliente.realizarPagamento(pedido, valorPago, estoque);
        }

        //AuxiliarAdm
        public void cadastrarMotorista (Motorista motorista){

        }*/

    public void realizarPedido(String cpfCliente, ArrayList<Produto> produtosDesejados, Estoque estoque) {
        /*Cliente cliente = RepositorioCliente.buscarPorCpf(cpfCliente);
        /* nao precisa desse if c a exception so se quiser uma segunda verificação
        if (cliente == null || !cliente.isCadastrado()) {
            throw new ClienteNaoExisteException("Cliente não cadastrado.");
        }
            cliente.realizarPedido(produtosDesejados, estoque);*/
    }

    public void realizarPagamento (String cpfCliente, Pedido pedido, double valorPago, Estoque estoque) {
        /*Cliente cliente = RepositorioCliente.buscarPorCpf (cpfCliente);

        cliente.realizarPagamento(pedido, valorPago, estoque);*/
    }

}