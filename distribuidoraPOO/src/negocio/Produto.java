package negocio;

public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(String codigo, String nome, String descricao, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }


    public String getNome() {
        return nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void atualizarPreco(double novoPreco){
        if(novoPreco<0){
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        } else if (novoPreco==0){
            throw new IllegalArgumentException("O produto não pode custar 0");
        }
        this.setPreco(novoPreco);
    }
}
