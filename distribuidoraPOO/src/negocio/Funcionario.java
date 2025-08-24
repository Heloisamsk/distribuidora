package negocio;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private String matricula;
    private LocalDateTime ultimaEntrada;
    private LocalDateTime ultimaSaida;

    public Funcionario(String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email, String matricula) {
        super(nome, idade, cpf, telefone, endereco, email);
        this.cargo = cargo;
        this.salario = salario;
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public LocalDateTime getUltimaEntrada() {
        return ultimaEntrada;
    }

    public LocalDateTime getUltimaSaida() {
        return ultimaSaida;
    }

    public boolean baterEntrada(String matricula){
        if(ultimaEntrada != null && ultimaSaida == null){
            System.out.println("Uma entrada ja foi registrada, sem saida!");
            return false;
        }
        ultimaEntrada = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(matricula + "bateu o ponto de entrada as: " + ultimaEntrada.format(fmt));
        return true;
    }
    public boolean baterPontoSaida(String matricula){
        if(ultimaEntrada == null){
            System.out.println("Nao eh possivel bater saida, sem uma entrada");
            return false;
        }
        ultimaSaida = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(matricula + "bateu o ponto de saida as: " + ultimaEntrada.format(fmt));

        Duration duracao = Duration.between(ultimaEntrada, ultimaSaida);
        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;

        System.out.println("Tempo trabalhado hoje: " + horas + "h " + minutos + "min");

        // Resetar entrada para permitir novo ciclo no próximo dia
        ultimaEntrada = null;
        ultimaSaida = null;
        return true;
    }
}