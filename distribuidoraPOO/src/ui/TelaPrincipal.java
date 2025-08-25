package ui;
import negocio.Funcionario;
import negocio.Motorista;


public class TelaPrincipal {
    // Essas classes chamam métodos da Fachada para executar ações, sem lógica de negócio.
    public static void main(String[] args) {
        System.out.println("=== Sistema da Distribuidora ===");
        Motorista motorista = new Motorista();
        motorista.setMatricula("7856");
        motorista.ponto(motorista.getMatricula());
        motorista.ponto(motorista.getMatricula());


    }
}