package negocio;

public class Caminhao {
    private String placa;
    private double capacidade;
    private Motorista motorista;
    private String status;

    //Construtor
    public Caminhao(String placa, double capacidade, Motorista motorista, String status) {
        this.placa = placa;
        this.capacidade = capacidade;
        this.motorista = motorista;
        this.status = status;
        if (motorista != null) {
            motorista.setCaminhaoResponsavel(this);
        }
    }

    //Metodos entrar e sair do patio
    public void entrarPatio(Patio patio) {
        if (patio.getVagasDisponiveis() > 0) {
            patio.setVagasDisponiveis(patio.getVagasDisponiveis() - 1);
            this.status = "No pátio";
            System.out.println("Caminhão da placa " + this.placa + " entrou no pátio");
        } else {
            System.out.println("Pátio ta cheio, caminhão " + this.placa + " não pode entrar");
        }
    }


    public void sairPatio(Patio patio) {
        patio.setVagasDisponiveis(patio.getVagasDisponiveis() + 1);
        this.status = "Fora do pátio";
        System.out.println("Caminhão da placa " + this.placa + " saiu do pátio");
    }


    //Placa GET SET
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getPlaca() {

        return placa;
    }

    //Capacidade GET SET
    public void setCapacidade (Double capacidade){
        this.capacidade = capacidade;
    }

    public double getCapacidade {
        return capacidade
    }

    //Motorista GET SET
    public void setMotorista(Motorista motorista){
        this.motorista = motorista;
    }

    public String getMotorista() {
        return motorista;
    }

    //Status get set
    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
