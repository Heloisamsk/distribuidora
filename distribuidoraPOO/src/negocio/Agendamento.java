package negocio;

import java.util.Date;

public class Agendamento {
    private int id;
    private Caminhao caminhao;
    private Date dataHoraPrevista;
    private String status;

    public Agendamento(int id, Caminhao caminhao, Date dataHoraPrevista) {
        this.id = id;
        this.caminhao = caminhao;
        this.dataHoraPrevista = dataHoraPrevista;
        this.status = "Pendente";
    }

    public void confirmarAgendamento() {
        this.status = "Confirmado";
        System.out.println("Agendamento " + this.id + " do caminhão " + this.caminhao.getPlaca() + " confirmado.");
    }

    public void cancelarAgendamento() {
        this.status = "Cancelado";
        System.out.println("Agendamento " + this.id + " do caminhão " + this.caminhao.getPlaca() + " cancelado.");
    }


    // gett sett id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //gett sett caminhao
    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    //gett e sett hora
    public Date getDataHoraPrevista() {
        return dataHoraPrevista;
    }

    public void setDataHoraPrevista(Date dataHoraPrevista) {
        this.dataHoraPrevista = dataHoraPrevista;
    }

    //gett sett status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
