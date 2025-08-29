package dados;
import negocio.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPatio {

    private ArrayList<Caminhao> caminhoesPatio = new ArrayList();

    public boolean cadastrarCaminhaoPatio(Caminhao caminhao){
        if(this.caminhoesPatio.add(caminhao)){
            return true;
        }
        return false;
    }
    public Caminhao buscarPorPlaca(String placa) {
        for(Caminhao c : this.caminhoesPatio) {
            if (c.getPlaca().equals(placa)) {
                return c;
            }
        }
        return null;
    }
    public void listarTodos() {
        if (this.caminhoesPatio.isEmpty()) {
            System.out.println("Não há caminhoes cadastrados no patio.");
            return;
        }
        System.out.println("Caminhoes: ");
        for (Caminhao c : this.caminhoesPatio) {
            System.out.println(c.getPlaca());
        }
    }
}
