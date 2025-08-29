//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package dados;

import java.util.ArrayList;
import negocio.Caminhao;
import negocio.Cliente;

public class RepositorioCaminhao {
    private ArrayList<Caminhao> caminhoes = new ArrayList();

    public boolean cadastrar(Caminhao caminhao) {
        if(this.caminhoes.add(caminhao)){
            System.out.println("Caminhão cadastrado: " + caminhao.getPlaca());
            return true;
        }
        return false;
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
