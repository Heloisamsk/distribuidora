package negocio;

public class Caminhao {
    private String placa;
    private int capacidade;
    private Motorista motorista;
    private String status;
    private Patio patio;

    public Caminhao(String placa, String modelo, int capacidadeCarga, String status, Patio patio, Motorista motorista) {
        this.placa = placa;
        this.capacidade = capacidade;
        this.status = status;
        this.patio = patio;
        this.motorista = motorista;
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
    public void entrarPatio(Patio patio, Caminhao caminhao) {
        boolean adicionado = patio.adicionarCaminhao(caminhao);
        if(adicionado){
            caminhao.setStatus("NO PATIO");
        }else{
            caminhao.setStatus("NA FILA");
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
