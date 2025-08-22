package negocio;

public class Caminhao {
    private String placa;
    private int capacidade;
    private Motorista motorista;
    private String status;

    public Caminhao(String placa, String modelo, int capacidadeCarga, String status) {
        this.placa = placa;
        this.capacidade = capacidade;
        this.status = status;
    }

    public String getPlaca() {
        return placa;
    }


    public int getCapacidade() {
        return capacidade;
    }


    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "placa='" + placa + '\'' +
                ", capacidade=" + capacidade +
                ", motorista=" + motorista +
                ", status='" + status + '\'' +
                '}';
    }
}
