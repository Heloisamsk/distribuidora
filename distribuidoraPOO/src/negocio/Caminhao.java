package negocio;

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

    public void entrarPatio(Patio patio, Caminhao caminhao) {
        if (patio == null) {
            throw new IllegalArgumentException("O pátio nao pode ser nulo");
        }
        if (caminhao == null) {
            throw new IllegalArgumentException("O caminhao não pode ser nulo");
        }

        try {
            boolean adicionado = patio.adicionarCaminhao(caminhao);
            if (adicionado) {
                caminhao.setStatus("NO PATIO");
                System.out.println("Caminhao " + caminhao.getPlaca() + " entrou no patio com sucesso.");
            } else {
                caminhao.setStatus("NA FILA");
                System.out.println("Caminhao " + caminhao.getPlaca() + " aguarda na fila do patio.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao tentar adicionar caminhao: " + e.getMessage());
        }
    }


    public void sairPatio(Patio patio) {
        if (patio == null) {
            throw new IllegalArgumentException("O patio nao pode ser nulo");
        }
        if (patio.getVagasDisponiveis() >= patio.getQtdVagas()) {
            System.out.println("Atenção: O pátio já está com todas as vagas disponíveis!");
        } else {
            patio.setVagasDisponiveis(patio.getVagasDisponiveis() + 1);
        }

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
