package ui;
import negocio.*;
import negocio.exceptions.ClienteNaoExisteException;
import negocio.exceptions.PontoException;

import java.util.ArrayList;


public class TelaPrincipal {
    // Essas classes chamam métodos da Fachada para executar ações, sem lógica de negócio.
    public static void main(String[] args) {
        System.out.println("=== Sistema da Distribuidora ===");
        Motorista motorista = new Motorista();
        motorista.setMatricula("7856");

        Produto biscoito = new Produto("001", "Biscoito", "Chocolate", 2.50, 3);
        Produto arroz = new Produto("002", "Arroz", "Tipo 1", 5.00, 2);

        ArrayList<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(biscoito);
        listaProdutos.add(arroz);


        Estoque estoque = new Estoque();

        AuxiliarAdm adm = new AuxiliarAdm("adm", 800.00, "Luicas", 35, "789549", "879985664",
                "Rua F", "licas@gmail.com", "adm2025", "1234");
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