package negocio;

public class Motorista extends Funcionario{
    private String CNH;
    private Caminhao caminhaoResponsavel;

    public Motorista(String CNH, Caminhao caminhaoResponsavel){
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
    public void dirigirCaminhao(){

    }
}
