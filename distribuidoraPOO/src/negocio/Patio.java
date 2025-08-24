package negocio;
import java.util.ArrayList;

public class Patio {
    private ArrayList<Caminhao> caminhoesPatioLista;
    private ArrayList<Caminhao> filaEntrada;
    private ArrayList<Caminhao> filaSaida;
    private int vagasDisponiveis;
    private int qtdVagas;

    public Patio(ArrayList<Caminhao> filaEntrada, ArrayList<Caminhao> filaSaida, int vagasDisponiveis, ArrayList<Caminhao> caminhoesPatioLista, int qtdVagas) {
        this.filaEntrada = new ArrayList<>(filaEntrada);
        this.filaSaida = new ArrayList<>(filaSaida);
        this.vagasDisponiveis = vagasDisponiveis;
        this.caminhoesPatioLista = new ArrayList<>(caminhoesPatioLista);
        this.qtdVagas = qtdVagas;
    }

    public ArrayList<Caminhao> getFilaEntrada() {
        return filaEntrada;
    }

    public void setFilaEntrada(ArrayList<Caminhao> filaEntrada) {
        this.filaEntrada = filaEntrada;
    }

    public ArrayList<Caminhao> getFilaSaida() {
        return filaSaida;
    }

    public void setFilaSaida(ArrayList<Caminhao> filaSaida) {
        this.filaSaida = filaSaida;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Patio{" +
                "filaEntrada=" + filaEntrada +
                ", filaSaida=" + filaSaida +
                ", vagasDisponiveis=" + vagasDisponiveis +
                '}';
    }public boolean adicionarCaminhao(Caminhao caminhao){
        if(caminhoesPatioLista.size() < qtdVagas){
            caminhoesPatioLista.add(caminhao);
            return true;
        }else{
            System.out.println("O patio esta cheio aguarde na fila: ");
            filaEntrada.add(caminhao);
            return false;
        }

    }

    public boolean removerCaminhao(Caminhao caminhao){
        if(caminhoesPatioLista.contains(caminhao)){
            caminhoesPatioLista.remove(caminhao);
            filaSaida.add(caminhao);
            vagasDisponiveis++;
            System.out.println("Caminhao placa: " + caminhao.getPlaca() + "esta na fila de saida do patio ou saiu do patio");
            return true;
        }
        else{
            System.out.println("O caminhao placa:" + caminhao.getPlaca() + "nao esta no patio");
            return false;
        }
    }
    public void listarFila(){};
}