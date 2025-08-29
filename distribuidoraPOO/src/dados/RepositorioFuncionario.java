
package dados;

import java.util.ArrayList;
import negocio.Funcionario;

public class RepositorioFuncionario {
    private ArrayList<Funcionario> funcionarios = new ArrayList();

    public boolean cadastrar(Funcionario funcionario) {
        if(this.funcionarios.add(funcionario)){
            System.out.println("Funcionário cadastrado: " + funcionario.getNome());
            return true;
        }
        return false;
    }

    public Funcionario buscarPorMatricula(String matricula) {
        for(Funcionario f : this.funcionarios) {
            if (f.getMatricula().equals(matricula)) {
                return f;
            }
        }

        return null;
    }

    public ArrayList<Funcionario> listarTodos() {
        return new ArrayList(this.funcionarios);
    }

    public boolean remover(String matricula) {
        Funcionario f = this.buscarPorMatricula(matricula);
        if (f != null) {
            this.funcionarios.remove(f);
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizar(Funcionario funcionario) {
        for(int i = 0; i < this.funcionarios.size(); ++i) {
            if (((Funcionario)this.funcionarios.get(i)).getMatricula().equals(funcionario.getMatricula())) {
                this.funcionarios.set(i, funcionario);
                return true;
            }
        }

        return false;
    }
}
