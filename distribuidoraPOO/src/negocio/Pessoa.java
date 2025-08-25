package negocio;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private String endereco;
    private String email;

    public Pessoa(String nome, int idade, String cpf, String telefone, String endereco, String email) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }
    public Pessoa(){

    }

    public String getNome() {
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }


    public String getEndereco() {
        return endereco;
    }


    public String getEmail() {
        return email;
    }

}
