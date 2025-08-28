package dados;

import negocio.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class RepositorioFuncionario {

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
    }

    public void remover(Funcionario f) {
        funcionarios.remove(f);
    }
}