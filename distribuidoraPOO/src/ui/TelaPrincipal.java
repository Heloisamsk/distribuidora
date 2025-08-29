package ui;
import fachada.DistribuidoraFachada;
import fachada.DistribuidoraFachada;
import negocio.*;
import negocio.exceptions.ClienteNaoExisteException;
import negocio.exceptions.PontoException;
import negocio.Patio;
import negocio.exceptions.VagaInsuficienteException;

import java.util.ArrayList;


public class TelaPrincipal {
    public static void main(String[] args) throws VagaInsuficienteException {
        System.out.println("=== Sistema da Distribuidora ===");

        DistribuidoraFachada fachada = new DistribuidoraFachada();
        AuxiliarAdm adm = new AuxiliarAdm("adm2025", "568794");
        Caminhao caminhao = new Caminhao("1233");
        Cliente c1 = new Cliente("Lucas", 25, "123456", "9999-0000", "Rua A", "lucas@email.com", "Pessoa Física");
        fachada.cadastrarCliente(c1);
        Produto p1 = new Produto("001", "Arroz", "Pacote 5kg", (double) 25.0F, 10);
        Estoque estoque = new Estoque();
        Motorista motorista = new Motorista("12599", caminhao, "motorista", 4000.00 , "Joao", 30, "1234879", "8788987", "rua f", "@joao", "7989898" );


        fachada.cadastrarProduto(p1, estoque);
        System.out.println(p1.getPreco());
        fachada.atualizarPreco(p1, 10.0F);
        System.out.println(p1.getPreco());
        fachada.listarProdutos();
        fachada.cadastrarMotorista(motorista);
        Patio patio2 = new Patio(5);
        fachada.cadastrarCaminhao(caminhao, patio2);
        fachada.listarCaminhoesPatio();
        fachada.permitirEntrada(caminhao, patio2);
        System.out.println(patio2.getVagasDisponiveis());
        fachada.adicionarFilaSaida(caminhao, patio2);
        fachada.permirSaida(caminhao, patio2);
        System.out.println(patio2.getVagasDisponiveis());


        fachada.listarClientes();
        fachada.listarProdutos();

        fachada.baterPonto(motorista);
        fachada.baterPonto(motorista);
        fachada.baterPonto(adm);

        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(p1);
        System.out.println("criando pedido.....");
         Pedido pedido = fachada.criarPedido(c1, listaProdutos, estoque);
         fachada.pagarPedido(c1, pedido, 250.00, estoque);
         fachada.listarProdutos();





    /*

        Motorista motorista = new Motorista();
        motorista.setMatricula("7856");

        Produto biscoito = new Produto("001", "Biscoito", "Chocolate", 2.50, 3);
        Produto arroz = new Produto("002", "Arroz", "Tipo 1", 5.00, 2);

        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(biscoito);
        listaProdutos.add(arroz);



        adm.cadastrarProduto(biscoito, estoque);
        adm.cadastrarProduto(arroz, estoque);

        System.out.println("\nEstoque inicial:");
        estoque.listarProdutos();

        Cliente cliente = new Cliente("Helo", 25, "87895", "7854699", "Rua 2", "helo@", "CPF");
        adm.cadastrarCliente(cliente);



        // Cliente realiza pedido
        cliente.realizarPedido(listaProdutos, estoque);

        // Obter o último pedido realizado
        Pedido ultimoPedido = cliente.getPedidos().get(cliente.getPedidos().size() - 1);

        // Cliente realiza pagamento
        try {
            cliente.realizarPagamento(ultimoPedido, ultimoPedido.getValorTotal(), estoque);
        } catch (ClienteNaoExisteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Listar estoque após pagamento
        System.out.println("\nEstoque após pagamento:");
        estoque.listarProdutos();

        System.out.println("\nSistema finalizado.");

        adm.cadastrarMotorista(motorista);

        Caminhao caminhao1 = new Caminhao("ab12");
        Patio patio2 = new Patio(5);

        adm.cadastrarCaminhao(caminhao1);
        adm.permitirEntrada(caminhao1, patio2);
        patio2.listarCaminhoes();
        adm.adicionarNaFilaSaida(caminhao1, patio2);
        adm.permitirSaida(caminhao1, patio2);
        patio2.listarCaminhoes();
        adm.ponto("1234");
        adm.atualizarPreco(biscoito, 3.00);
    }


        /*AuxiliarAdm auxiliar = new AuxiliarAdm();
        auxiliar.setMatricula("0123");

        Caminhao caminhao1 = new Caminhao("ab12");
        Caminhao caminhao2 = new Caminhao("ab13");
        Caminhao caminhao3 = new Caminhao("ab14");
        Caminhao caminhao4 = new Caminhao("ab15");
        Caminhao caminhao5 = new Caminhao("ab16");
        Caminhao caminhao6 = new Caminhao("ab17");

        Patio patio2 = new Patio(5);



        patio2.adicionarCaminhao(caminhao1);
        patio2.adicionarCaminhao(caminhao2);
        patio2.adicionarCaminhao(caminhao3);
        patio2.adicionarCaminhao(caminhao4);
        patio2.adicionarCaminhao(caminhao5);
        patio2.adicionarCaminhao(caminhao6);

        patio2.listarCaminhoes();
        patio2.listarFilas();



      try {
          motorista.ponto(motorista.getMatricula());
          motorista.ponto(motorista.getMatricula());

          motorista.ponto(motorista.getMatricula());
          motorista.baterEntrada(motorista.getMatricula()); // vai dar erro

      }catch (PontoException e) {
          System.out.println("Erro ao registrar ponto: " + e.getMessage());
      }
      try {
          auxiliar.baterEntrada(auxiliar.getMatricula());
          auxiliar.baterEntrada(auxiliar.getMatricula()); // vai dar erro
      } catch (PontoException e){
          System.out.println("Erro ao registrar ponto: " + e.getMessage());

      }
      */
    }
}