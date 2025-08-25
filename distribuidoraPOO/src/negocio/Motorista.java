package negocio;

public class Motorista extends Funcionario{
    private String CNH;
    private Caminhao caminhaoResponsavel;

    public Motorista(String CNH, Caminhao caminhaoResponsavel, String cargo, double salario, String nome, int idade, String cpf, String telefone, String endereco, String email, String matricula){
        super(cargo, salario, nome, idade, cpf, telefone, endereco, email, matricula);
        this.CNH = CNH;
        this.caminhaoResponsavel = caminhaoResponsavel;
    }
    public Motorista(){

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
        if (this.caminhaoResponsavel != null){
            this.caminhaoResponsavel.setStatus("Em viagem");
        }else {
            System.out.println("Erro: motorista sem caminhão não pode dirigir");
        }
    }

    public void finalizarViagem(Caminhao caminhaoResponsavel){
        this.caminhaoResponsavel.setStatus("Disponivel");
    }
    public void consertarCaminhao(Caminhao caminhaoResponsavel){
        this.caminhaoResponsavel.setStatus("Em conserto");
    }
    public void ponto(String matricula){
        baterPonto(matricula);
    }

}

