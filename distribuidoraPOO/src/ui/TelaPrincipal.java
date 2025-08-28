package ui;
import dados.*;
import negocio.*;
import negocio.exceptions.ClienteNaoExisteException;
import negocio.Patio;
import negocio.exceptions.VagaInsuficienteException;

import java.util.ArrayList;
import java.util.Date;



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

        RepositorioProduto repositorio = new RepositorioProduto();
        Estoque estoque = new Estoque(repositorio);

        AuxiliarAdm adm = new AuxiliarAdm("adm", 800.00, "Luicas", 35, "789549", "879985664",
                "Rua F", "licas@gmail.com", "adm2025", "1234");

        adm.cadastrarProduto(biscoito, estoque);
        adm.cadastrarProduto(arroz, estoque);

        System.out.println("\nEstoque inicial:");
        estoque.listarProdutos();

        Cliente cliente = new Cliente("Helo", 25, "87895", "7854699", "Rua 2", "helo@", "CPF");
        adm.cadastrarCliente(cliente);

        cliente.realizarPedido(listaProdutos, estoque);

        Pedido ultimoPedido = cliente.getPedidos().get(cliente.getPedidos().size() - 1);

        try {
            cliente.realizarPagamento(ultimoPedido, ultimoPedido.getValorTotal(), estoque);
        } catch (ClienteNaoExisteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\nEstoque após pagamento:");
        estoque.listarProdutos();

        RepositorioCaminhao repoCaminhao = new RepositorioCaminhao();

        Caminhao caminhao1 = new Caminhao("ab12");
        Caminhao caminhao2 = new Caminhao("ab13");

        repoCaminhao.cadastrar(caminhao1);
        repoCaminhao.cadastrar(caminhao2);

        Patio patio2 = new Patio(5);

        try {
            caminhao1.entrarPatio(patio2, caminhao1);
            caminhao2.entrarPatio(patio2, caminhao2);
        } catch (VagaInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\nCaminhões no pátio:");
        for (Caminhao c : repoCaminhao.listarTodos()) {
            System.out.println(c);
        }

        caminhao1.sairPatio(patio2);
        System.out.println("\nApós saída do caminhão ab12:");
        for (Caminhao c : repoCaminhao.listarTodos()) {
            System.out.println(c);
        }

        System.out.println("\nSistema finalizado.");

        adm.cadastrarMotorista(motorista);
        adm.cadastrarCaminhao(caminhao1);
        adm.permitirEntrada(caminhao1, patio2);
        patio2.listarCaminhoes();
        adm.adicionarNaFilaSaida(caminhao1, patio2);
        adm.permitirSaida(caminhao1, patio2);
        patio2.listarCaminhoes();
        adm.ponto("1234");
        adm.atualizarPreco(biscoito, 3.00);

        //testando repositorio de agendamento
        RepositorioAgendamento repoAgendamento = new RepositorioAgendamento();

        Agendamento agendamento1 = new Agendamento(ultimoPedido, caminhao1, new Date());
        repoAgendamento.cadastrar(agendamento1);

        System.out.println("\nLista de agendamentos:");
        for (Agendamento a : repoAgendamento.listarTodos()) {
            System.out.println("Pedido: " + a.getPedido().getNumero() +
                    " | Caminhão: " + a.getCaminhao().getPlaca() +
                    " | Status: " + a.getStatus());
        }

        agendamento1.confirmarAgendamento();
        System.out.println("\nAgendamento confirmado: Pedido " + agendamento1.getPedido().getNumero() +
                " | Status: " + agendamento1.getStatus());

        agendamento1.cancelarAgendamento();
        System.out.println("\nAgendamento cancelado: Pedido " + agendamento1.getPedido().getNumero() +
                " | Status: " + agendamento1.getStatus());


        //testando repositorio cliente
        RepositorioCliente repoCliente = new RepositorioCliente();

        Cliente c1 = new Cliente("Helo", 25, "87895", "7854699", "Rua 2", "helo@", "CPF");
        Cliente c2 = new Cliente("Luca", 30, "12345", "9999999", "Rua 3", "luca@", "CPF");

        repoCliente.cadastrar(c1);
        repoCliente.cadastrar(c2);

        System.out.println("Clientes cadastrados:");
        for (Cliente c : repoCliente.listarTodos()) {
            System.out.println(c.getNome() + " | CPF: " + c.getCpf());
        }

        Cliente buscado = repoCliente.buscarPorCpf("12345");
        System.out.println("Cliente buscado: " + buscado.getNome());

        repoCliente.remover("87895");
        System.out.println("Após remoção:");
        for (Cliente c : repoCliente.listarTodos()) {
            System.out.println(c.getNome() + " | CPF: " + c.getCpf());
        }

        RepositorioFuncionario repoFuncionario = new RepositorioFuncionario();
        Funcionario funcionario1 = new Funcionario("Auxiliar", 2000.0, "João", 28, "111", "888888", "Rua A", "joao@", "F001");
        Funcionario funcionario2 = new Funcionario("Gerente", 5000.0, "Maria", 35, "222", "999999", "Rua B", "maria@", "F002");

        funcionario1.setCadastrado(true);
        funcionario2.setCadastrado(true);

        repoFuncionario.cadastrar(funcionario1);
        repoFuncionario.cadastrar(funcionario2);

        System.out.println("\nFuncionários cadastrados:");
        for (Funcionario f : repoFuncionario.listarTodos()) {
            System.out.println(f.getNome() + " | Matrícula: " + f.getMatricula());
        }

        // Atualizando funcionário
        funcionario1.setSalario(2200.0);
        repoFuncionario.atualizar(funcionario1);

        // Removendo funcionário
        repoFuncionario.remover("F002");

        System.out.println("\nApós atualização e remoção de funcionários:");
        for (Funcionario f : repoFuncionario.listarTodos()) {
            System.out.println(f.getNome() + " | Matrícula: " + f.getMatricula() + " | Salário: " + f.getSalario());
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