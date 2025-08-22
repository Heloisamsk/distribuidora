package negocio;

import java.util.Date;

public class Agendamento {
    private Pedido pedido; // Agora Agendamento está ligado a um Pedido
    private Caminhao caminhao;
    private Date dataHoraPrevista;
    private String status;

    // O construtor agora recebe um Pedido em vez de um ID e um Cliente
    public Agendamento(Pedido pedido, Caminhao caminhao, Date dataHoraPrevista) {
        this.pedido = pedido;
        this.caminhao = caminhao;
        this.dataHoraPrevista = dataHoraPrevista;
        this.status = "Pendente.";
    }

    public void confirmarAgendamento() {
        this.status = "Confirmado";
        System.out.println("Agendamento do pedido " + this.pedido.getNumero() + " do cliente " + this.pedido.getCliente().getNome() + " para o caminhão " + this.caminhao.getPlaca() + " confirmado.");
    }

    public void cancelarAgendamento() {
        this.status = "Cancelado";
        System.out.println("Agendamento do pedido " + this.pedido.getNumero() + " do cliente " + this.pedido.getCliente().getNome() + " para o caminhão " + this.caminhao.getPlaca() + " cancelado.");
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}