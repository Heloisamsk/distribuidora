package negocio;

import java.util.LinkedList;
import java.util.List;

public class Patio {
    private List<Caminhao> filaEntrada;
    private List<Caminhao> filaSaida;
    private int vagasDisponiveis;

    public Patio(int capacidade) {
        this.filaEntrada = new LinkedList<>();
        this.filaSaida = new LinkedList<>();
        this.vagasDisponiveis = capacidade;
    }

    public void adicionarCaminhaoFila(Caminhao c) {
        if (c != null) {
            this.filaEntrada.add(c);
            System.out.println("Caminhão da placa " + c.getPlaca() + " foi colocado na fila de entrada);
        }
    }

    public void removerCaminhaoFila(Caminhao c) {
        if (c != null) {
            if (this.filaEntrada.remove(c)) {
                System.out.println("Caminhão da placa " + c.getPlaca() + " removido da fila de entrada.");
            } else {
                System.out.println("Caminhão da placa " + c.getPlaca() + " não encontrado na fila de entrada.");
            }
        }
    }

    public void listarFila() {
        if (this.filaEntrada.isEmpty()) {
            System.out.println("Fila de entrada ta vazia");
        } else {
            System.out.println("Caminhões na fila de entrada:");
            for (Caminhao caminhao : this.filaEntrada) {
                System.out.println("- Placa: " + caminhao.getPlaca() + ", Status: " + caminhao.getStatus());
            }
        }
    }

    public List<Caminhao> getFilaEntrada() {
        return filaEntrada;
    }

    public List<Caminhao> getFilaSaida() {
        return filaSaida;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
}
