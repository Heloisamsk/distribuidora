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
    //Metodos entrar e sair do patio
    public void entrarPatio(Patio patio) {
        if (patio.getVagasDisponiveis() > 0) {
            patio.setVagasDisponiveis(patio.getVagasDisponiveis() - 1);
            this.status = "No pátio";
            System.out.println("Caminhão da placa: " + this.placa + " entrou no pátio");
        } else {
            System.out.println("Pátio está cheio, caminhão " + this.placa + " não pode entrar");
        }
    }


    public void sairPatio(Patio patio) {
        patio.setVagasDisponiveis(patio.getVagasDisponiveis() + 1);
        this.status = "Fora do pátio";
        System.out.println("Caminhão da placa: " + this.placa + " saiu do pátio");
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
