/*package dados;

import negocio.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFuncionario {

    private List<Funcionario> funcionarios;

    public RepositorioFuncionario() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionar(Funcionario f) {
        if(f == null) {
            throw new IllegalArgumentException("Funcionário nulo");
        }

        if(buscarPorMatricula(f.getMatricula()) != null) {
            throw new IllegalArgumentException("Funcionário já cadastrado com esta matrícula");
        }

        funcionarios.add(f);
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios); // devolve cópia da lista
    }

    public Funcionario buscarPorMatricula(String matricula) {
        return funcionarios.stream()
                .filter(f -> f.getMatricula().equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);
    }

    public void remover(Funcionario f) {
        funcionarios.remove(f);
    }
}
*/