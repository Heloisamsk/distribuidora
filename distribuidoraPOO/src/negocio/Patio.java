package negocio;
import java.util.ArrayList;

public class Patio {
    private ArrayList<Caminhao> caminhoesPatioLista;
    private ArrayList<Caminhao> filaEntrada;
    private ArrayList<Caminhao> filaSaida;
    private int vagasDisponiveis;
    private int qtdVagas = 5;

    public Patio(ArrayList<Caminhao> filaEntrada, ArrayList<Caminhao> filaSaida, int vagasDisponiveis, ArrayList<Caminhao> caminhoesPatioLista, int qtdVagas) {
        this.filaEntrada = new ArrayList<>(filaEntrada);
        this.filaSaida = new ArrayList<>(filaSaida);
        this.vagasDisponiveis = vagasDisponiveis;
        this.caminhoesPatioLista = new ArrayList<>(caminhoesPatioLista);
        this.qtdVagas = 5;
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
    }
    public void adicionarCaminhao(int vagasDisponiveis){
        vagasDisponiveis = 4;
    }
    public void removerCaminhao(){};
    public void listarFila(){};
}