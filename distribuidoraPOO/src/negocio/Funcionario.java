package negocio;

public class Funcionario extends Pessoa {
    private String cargo;
    private Double salario;

    public Funcionario(String cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    }
    public boolean baterPonto(){

    }
    public void receberAumento(Double aumento) {
        this.salario += aumento;
    }
}

}
