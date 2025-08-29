<<<<<<< HEAD
=======
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

>>>>>>> main
package dados;

import java.util.ArrayList;
import negocio.Caminhao;
import negocio.Cliente;

public class RepositorioCaminhao {
    private ArrayList<Caminhao> caminhoes = new ArrayList();

<<<<<<< HEAD
    private List<Caminhao> caminhoes = new ArrayList<>();

    /*public RepositorioCaminhao() {
        this.caminhoes = new ArrayList<>();
    }*/

    public void adicionar(Caminhao caminhao) {
        /*if(caminhao == null) {
            throw new IllegalArgumentException("Caminhão nulo");
        }

        if(buscarPorPlaca(caminhao.getPlaca()) != null) {
            throw new IllegalArgumentException("Caminhão já cadastrado com esta placa");
        }*/

        caminhoes.add(caminhao);
    }

    public List<Caminhao> listarTodos() {
        return new ArrayList<>(caminhoes); // devolve cópia da lista
=======
    public boolean cadastrar(Caminhao caminhao) {
        if(this.caminhoes.add(caminhao)){
            System.out.println("Caminhão cadastrado: " + caminhao.getPlaca());
            return true;
        }
        return false;
>>>>>>> main
    }

    public Caminhao buscarPorPlaca(String placa) {
        for(Caminhao c : this.caminhoes) {
            if (c.getPlaca().equals(placa)) {
                return c;
            }
        }
        return null;
    }


    public ArrayList<Caminhao> listarTodos() {
        return new ArrayList(this.caminhoes);
    }

<<<<<<< HEAD
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
=======
    public boolean atualizar(Caminhao caminhao) {
        for(int i = 0; i < this.caminhoes.size(); ++i) {
            if (((Caminhao)this.caminhoes.get(i)).getPlaca().equals(caminhao.getPlaca())) {
                this.caminhoes.set(i, caminhao);
                return true;
            }
        }

        return false;
    }

    public boolean remover(String placa) {
        Caminhao c = this.buscarPorPlaca(placa);
        if (c != null) {
            this.caminhoes.remove(c);
            return true;
        } else {
            return false;
        }
    }
}
>>>>>>> main
