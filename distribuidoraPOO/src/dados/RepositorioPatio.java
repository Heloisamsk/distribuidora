package dados;

import negocio.Patio;
import negocio.Caminhao;
import java.util.ArrayList;
import java.util.List;

public class RepositorioPatio {
    private Patio patio;

    public RepositorioPatio(int qtdVagas) {
        // Cria um pátio com quantidade de vagas definida
        this.patio = new Patio(qtdVagas);
    }

    public RepositorioPatio() {
        // Cria um pátio padrão
        this.patio = new Patio();
    }

    // 🔹 Retorna o pátio atual
    public Patio getPatio() {
        return patio;
    }

    // 🔹 Adiciona um caminhão ao pátio
    public boolean adicionarCaminhao(Caminhao caminhao) {
        if (caminhao == null) {
            throw new IllegalArgumentException("Caminhão informado é nulo");
        }

        return patio.adicionarCaminhao(caminhao);
    }

    // 🔹 Remove um caminhão do pátio
    public boolean removerCaminhao(Caminhao caminhao) {
        if (caminhao == null) {
            throw new IllegalArgumentException("Caminhão informado é nulo");
        }

        return patio.removerCaminhao(caminhao);
    }

    public List<Caminhao> listarCaminhoesPatio() {
        return new ArrayList<>(patio.getCaminhoesPatioLista());
    }

    public List<Caminhao> listarFilaEntrada() {
        return new ArrayList<>(patio.getFilaEntrada());
    }

    public List<Caminhao> listarFilaSaida() {
        return new ArrayList<>(patio.getFilaSaida());
    }

    public int getVagasDisponiveis() {
        return patio.getVagasDisponiveis();
    }

    public void setVagasDisponiveis(int vagas) {
        patio.setVagasDisponiveis(vagas);
    }
}
