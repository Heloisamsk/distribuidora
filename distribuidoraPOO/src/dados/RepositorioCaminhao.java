package dados;

import negocio.Caminhao;
import java.util.ArrayList;
import java.util.List;

public class RepositorioCaminhao {

    private ArrayList<Caminhao> caminhoes;

    public RepositorioCaminhao() {
        this.caminhoes = new ArrayList<>();
    }

    public void cadastrar(Caminhao caminhao) {
        caminhoes.add(caminhao);
        System.out.println("Caminhão cadastrado: " + caminhao.getPlaca());
    }

    public Caminhao buscarPorPlaca(String placa) {
        for (Caminhao c : caminhoes) {
            if (c.getPlaca().equals(placa)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Caminhao> listarTodos() {
        return new ArrayList<>(caminhoes);
    }

    public boolean atualizar(Caminhao caminhao) {
        for (int i = 0; i < caminhoes.size(); i++) {
            if (caminhoes.get(i).getPlaca().equals(caminhao.getPlaca())) {
                caminhoes.set(i, caminhao);
                return true;
            }
        }
        return false;
    }

    public boolean remover(String placa) {
        Caminhao c = buscarPorPlaca(placa);
        if (c != null) {
            caminhoes.remove(c);
            return true;
        }
        return false;
    }

   /* private List<Caminhao> caminhoes = new ArrayList<>();

    public void adicionar(Caminhao caminhao) {
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
    }*/

    //eh no rep de patio
    /*public void entrarPatio(Caminhao caminhao, negocio.Patio patio) {
        if(caminhao == null || patio == null) {
            throw new IllegalArgumentException("Caminhão ou pátio nulo");
        }

        /*boolean entrou = patio.adicionarCaminhao(caminhao);
        if(entrou) {
            caminhao.setStatus("NO PATIO");
        } else {
            caminhao.setStatus("NA FILA");
        }
    }

    public void sairPatio(Caminhao caminhao, negocio.Patio patio) {
        if(caminhao == null || patio == null) {
            throw new IllegalArgumentException("Caminhão ou pátio nulo");
        }*/

        //boolean removido = patio.removerCaminhao(caminhao);
        /*if(removido) {
            caminhao.setStatus("FORA DO PATIO");
        }*/
}