package negocio;

public class Motorista extends Funcionario{
    private String CNH;
    private Caminhao caminhaoResponsavel;

    public Motorista(String CNH, Caminhao caminhaoResponsavel, String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email){
        super(matricula, cargo, salario, nome, idade, cpf, telefone, endereco, email);
        this.CNH = CNH;
        this.caminhaoResponsavel = caminhaoResponsavel;
    }

    public Caminhao getCaminhaoResponsavel() {

        return caminhaoResponsavel;
    }

    public void setCaminhaoResponsavel(Caminhao caminhaoResponsavel) {

        this.caminhaoResponsavel = caminhaoResponsavel;
    }

    public String getCNH() {

        return CNH;
    }

    public void dirigirCaminhao(Caminhao caminhaoResponsavel){
        this.caminhaoResponsavel.setStatus("Em viagem");

    }
    public void finalizarViagem(Caminhao caminhaoResponsavel){
        this.caminhaoResponsavel.setStatus("Disponível");
    }
    public void mandarConsertarCaminhao(Caminhao caminhaoResponsavel){
        this.caminhaoResponsavel.setStatus("Em conserto");
    }

}

