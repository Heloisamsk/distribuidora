package ui;
import negocio.*;
import negocio.exceptions.PontoException;


public class TelaPrincipal {
    // Essas classes chamam métodos da Fachada para executar ações, sem lógica de negócio.
    public static void main(String[] args) {
        System.out.println("=== Sistema da Distribuidora ===");
        Motorista motorista = new Motorista();
        motorista.setMatricula("7856");



        Produto biscoito = new Produto("012","bisoito", "chocolat", 2.50, 3);
        Pedido pedido = new Pedido();
        pedido.adicionarProduto(biscoito);

        Estoque estoque = new Estoque();
        estoque.adicionarProduto(biscoito);
        estoque.listarProdutos();
        System.out.println("\n");
        estoque.consultarProduto("012");

        AuxiliarAdm adm = new AuxiliarAdm("albqq", "adm2025");
        Cliente cliente = new Cliente("helo", "7589");
        Cliente cliente1 = new Cliente("ola", "789556");
        adm.cadastrarCliente(cliente);
        cliente.realizarPedido(pedido);




        /* AuxiliarAdm auxiliar = new AuxiliarAdm();
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

        System.out.println("continua rodando");
*/
    }
}