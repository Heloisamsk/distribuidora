
package dados;

import java.util.ArrayList;
import negocio.Agendamento;

public class RepositorioAgendamento {
    private ArrayList<Agendamento> agendamentos = new ArrayList();

    public void cadastrar(Agendamento agendamento) {
        this.agendamentos.add(agendamento);
        System.out.println("Agendamento cadastrado para pedido: " + agendamento.getPedido().getNumero());
    }

    public Agendamento buscarPorPedido(int numeroPedido) {
        for(Agendamento a : this.agendamentos) {
            if (a.getPedido().getNumero() == numeroPedido) {
                return a;
            }
        }

        return null;
    }

    public ArrayList<Agendamento> listarTodos() {
        return new ArrayList(this.agendamentos);
    }

    public boolean atualizar(Agendamento agendamento) {
        for(int i = 0; i < this.agendamentos.size(); ++i) {
            if (((Agendamento)this.agendamentos.get(i)).getPedido().getNumero() == agendamento.getPedido().getNumero()) {
                this.agendamentos.set(i, agendamento);
                return true;
            }
        }

        return false;
    }

    public boolean remover(int numeroPedido) {
        Agendamento a = this.buscarPorPedido(numeroPedido);
        if (a != null) {
            this.agendamentos.remove(a);
            return true;
        } else {
            return false;
        }
    }
}
