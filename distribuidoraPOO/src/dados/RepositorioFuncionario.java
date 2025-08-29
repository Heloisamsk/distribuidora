<<<<<<< HEAD
package dados;
=======
>>>>>>> main

package dados;

import java.util.ArrayList;
import negocio.Funcionario;

public class RepositorioFuncionario {
    private ArrayList<Funcionario> funcionarios = new ArrayList();

<<<<<<< HEAD
    private List<Funcionario> funcionarios = new ArrayList<>();

    /*public RepositorioFuncionario() {
        this.funcionarios = new ArrayList<>();
    }*/

    public void adicionar(Funcionario f) {
        //NAO PRECISA DE EXCECOES EM DADOS
        /*if(f == null) {
            throw new IllegalArgumentException("Funcionário nulo");
        }

        if(buscarPorMatricula(f.getMatricula()) != null) {
            throw new IllegalArgumentException("Funcionário já cadastrado com esta matrícula");
        }*/

        funcionarios.add(f);
    }

    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios); // devolve cópia da lista
    }

    //vai procurar o funcionario pelo cpf ACHO Q NAO VOU USAR ESSE
    /*public Funcionario buscarPorCpf(String cpf){
        if (cpf == null || cpf.trim().isEmpty()){
            return null;
        }
        return funcionarios.stream()
                .filter(f -> f.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }*/

    //busca o func pela matricula
    public Funcionario buscarPorMatricula(String matricula){
        if (matricula == null || matricula.trim().isEmpty()){
            return null;
        }
        return funcionarios.stream()
                .filter(f -> f.getMatricula().equalsIgnoreCase(matricula))
                .findFirst()
                .orElse(null);
=======
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
>>>>>>> main
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
<<<<<<< HEAD
}
=======
}
>>>>>>> main
