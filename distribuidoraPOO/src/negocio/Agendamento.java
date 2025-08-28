package negocio;

import java.util.Date;

public class Agendamento {
    private Pedido pedido;
    private Caminhao caminhao;
    private Date dataHoraPrevista;
    private StatusAgendamento status;

    public Agendamento(Pedido pedido, Caminhao caminhao, Date dataHoraPrevista) {
        this.pedido = pedido;
        this.caminhao = caminhao;
        this.dataHoraPrevista = dataHoraPrevista;
        this.status = StatusAgendamento.PENDENTE;
    }

    public void confirmarAgendamento() {
        if (this.status != StatusAgendamento.PENDENTE){
            throw new IllegalArgumentException("O agendamento não pode ser confirmado, pois seu status atual é: " + this.status);
        }
        this.status = StatusAgendamento.CONFIRMADO;
    }

    public void cancelarAgendamento() {
        if (this.status != StatusAgendamento.CONFIRMADO){
            throw new IllegalArgumentException("O agendamento não pode ser confirmado, pois seu status atual é: " + this.status);
        }
        this.status = StatusAgendamento.CANCELADO;

    }

    // getters e setters
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public Date getDataHoraPrevista() {
        return dataHoraPrevista;
    }

    public void setDataHoraPrevista(Date dataHoraPrevista) {
        this.dataHoraPrevista = dataHoraPrevista;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }
}