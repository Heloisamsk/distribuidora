package negocio;
import negocio.exceptions.PontoException;

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
    public Funcionario(){

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

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getUltimaEntrada() {
        return ultimaEntrada;
    }

    public LocalDateTime getUltimaSaida() {
        return ultimaSaida;
    }

    public boolean baterEntrada(String matricula) throws PontoException {
        if(ultimaEntrada != null && ultimaSaida == null){
            throw new PontoException("Ja existe uma ENTRADA registrada sem SAIDA");
        }
        ultimaEntrada = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(matricula + "bateu o ponto de entrada as: " + ultimaEntrada.format(fmt));
        return true;
    }

    public boolean baterPontoSaida(String matricula)throws PontoException{
        if(ultimaEntrada == null){
            throw new PontoException("Não é possivel bater a saida sem uma entrada");
        }
        ultimaSaida = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(matricula + "bateu o ponto de saida as: " + ultimaEntrada.format(fmt));

        Duration duracao = Duration.between(ultimaEntrada, ultimaSaida);
        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;

        System.out.println("Tempo trabalhado hoje: " + horas + "h " + minutos + "min");

        ultimaEntrada = null;
        ultimaSaida = null;
        return true;
    }
    public boolean baterPonto(String matricula) throws PontoException{
        if(ultimaEntrada == null){
            return baterEntrada(matricula);
        }
        else{
            return baterPontoSaida(matricula);
 }
}
}