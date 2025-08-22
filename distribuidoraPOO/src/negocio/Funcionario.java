package negocio;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario(String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email) {
        super(nome, idade, cpf, telefone, endereco, email);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    /*public boolean baterPonto(int entrada, int saida) {
        // 8 e 18
       double horas = saida - entrada - 2;
        return true;
    }*/
}