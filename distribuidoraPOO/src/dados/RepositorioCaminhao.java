/*package dados;

import negocio.Caminhao;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCaminhao {

    private List<Caminhao> caminhoes;

    public RepositorioCaminhao() {
        this.caminhoes = new ArrayList<>();
    }

    public void adicionar(Caminhao caminhao) {
        if(caminhao == null) {
            throw new IllegalArgumentException("Caminhão nulo");
        }

        if(buscarPorPlaca(caminhao.getPlaca()) != null) {
            throw new IllegalArgumentException("Caminhão já cadastrado com esta placa");
        }

        caminhoes.add(caminhao);
    }

    public List<Caminhao> listarTodos() {
        return new ArrayList<>(caminhoes); // devolve cópia da lista
    }

    public Caminhao buscarPorPlaca(String placa) {
        return caminhoes.stream()
                .filter(c -> c.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public void remover(Caminhao caminhao) {
        caminhoes.remove(caminhao);
    }

    public void entrarPatio(Caminhao caminhao, negocio.Patio patio) {
        if(caminhao == null || patio == null) {
            throw new IllegalArgumentException("Caminhão ou pátio nulo");
        }

        boolean entrou = patio.adicionarCaminhao(caminhao);
        if(entrou) {
            caminhao.setStatus("NO PATIO");
        } else {
            caminhao.setStatus("NA FILA");
        }
    }

    public void sairPatio(Caminhao caminhao, negocio.Patio patio) {
        if(caminhao == null || patio == null) {
            throw new IllegalArgumentException("Caminhão ou pátio nulo");
        }

        boolean removido = patio.removerCaminhao(caminhao);
        if(removido) {
            caminhao.setStatus("FORA DO PATIO");
        }
    }
}


 */