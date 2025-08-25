package ui;
import negocio.Funcionario;
import negocio.Motorista;
import negocio.exceptions.PontoException;


public class TelaPrincipal {
    // Essas classes chamam métodos da Fachada para executar ações, sem lógica de negócio.
    public static void main(String[] args) {
        System.out.println("=== Sistema da Distribuidora ===");
        Motorista motorista = new Motorista();
        motorista.setMatricula("7856");
      try {
          motorista.ponto(motorista.getMatricula());
          motorista.ponto(motorista.getMatricula());

          motorista.ponto(motorista.getMatricula());
          motorista.baterEntrada(motorista.getMatricula());
      }catch (PontoException e) {
          System.out.println("Erro ao registrar ponto: " + e.getMessage());
      }



        System.out.println("continua rodando");

    }
}