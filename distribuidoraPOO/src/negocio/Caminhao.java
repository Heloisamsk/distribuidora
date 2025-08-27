package negocio;

import negocio.exceptions.VagaInsuficienteException;

public class Caminhao {
    private String placa;
    private int capacidade;
    private Motorista motorista;
    private String status;
    private Patio patio;

    public Caminhao(String placa, String modelo, int capacidade, String status, Patio patio, Motorista motorista) {
        this.placa = placa;
        this.capacidade = capacidade;
        this.status = status;
        this.patio = patio;
        this.motorista = motorista;
    }
    public Caminhao(String placa){
        this.placa = placa;
    }
    public Caminhao(){

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

    public void entrarPatio(Patio patio, Caminhao caminhao) throws VagaInsuficienteException {
        if (patio == null) {
            throw new IllegalArgumentException("O pátio não pode ser nulo.");
        }
        if (caminhao == null) {
            throw new IllegalArgumentException("O caminhão não pode ser nulo.");
        }
        if (patio.getVagasDisponiveis() > 0) {
            patio.setVagasDisponiveis(patio.getVagasDisponiveis() - 1);
            caminhao.setStatus("NO PATIO");
        } else {
            throw new VagaInsuficienteException("Não há vagas disponíveis no pátio. O caminhão não pode entrar.");
        }
    }

    public void sairPatio(Patio patio) {
        if (patio == null) {
            throw new IllegalArgumentException("O pátio não pode ser nulo.");
        }

        if (patio.getVagasDisponiveis() >= patio.getQtdVagas()) {
            throw new IllegalStateException("O pátio já está com a capacidade máxima de vagas disponíveis.");
        }

        patio.setVagasDisponiveis(patio.getVagasDisponiveis() + 1);
        this.status = "Fora do pátio";


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
