package negocio;
import java.util.ArrayList;

public class Patio {
    private ArrayList<Caminhao> caminhoesPatioLista;
    private ArrayList<Caminhao> filaEntrada;
    private ArrayList<Caminhao> filaSaida;
    private int vagasDisponiveis;
    private int qtdVagas ;

    public Patio( int vagasDisponiveis, int qtdVagas) {
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.vagasDisponiveis = vagasDisponiveis;
        this.caminhoesPatioLista = new ArrayList<>();
        this.qtdVagas = qtdVagas;
    }
    public Patio(){
        this.filaEntrada = new ArrayList<>();
        this.filaSaida = new ArrayList<>();
        this.caminhoesPatioLista = new ArrayList<>();
    }
    public Patio(int qtdVagas){
        this.qtdVagas = qtdVagas;
    }

    public ArrayList<Caminhao> getFilaEntrada() {
        return filaEntrada;
    }

    public void setFilaEntrada(ArrayList<Caminhao> filaEntrada) {
        this.filaEntrada = filaEntrada;
    }

    public ArrayList<Caminhao> getFilaSaida() {
        return filaSaida;
    }

    public void setFilaSaida(ArrayList<Caminhao> filaSaida) {
        this.filaSaida = filaSaida;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Patio{" +
                "filaEntrada=" + filaEntrada +
                ", filaSaida=" + filaSaida +
                ", vagasDisponiveis=" + vagasDisponiveis +
                '}';
    }public boolean adicionarCaminhao(Caminhao caminhao){
        vagasDisponiveis = qtdVagas;
        if(caminhoesPatioLista.size() < vagasDisponiveis){
            caminhoesPatioLista.add(caminhao);
            System.out.println("add");
            vagasDisponiveis--;
            return true;
        }else{
            System.out.println("O patio esta cheio aguarde na fila: ");
            filaEntrada.add(caminhao);
            return false;
        }

    }

    public boolean removerCaminhao(Caminhao caminhao){
        if(caminhao == null){
            throw new IllegalArgumentException("Caminhao informado eh nulo");
        }
        if(caminhoesPatioLista.contains(caminhao)){
            caminhoesPatioLista.remove(caminhao);
            filaSaida.add(caminhao);
            vagasDisponiveis++;
            System.out.println("Caminhao placa: " + caminhao.getPlaca() + "esta na fila de saida do patio ou saiu do patio");
            return true;
        }
        else{
            throw new IllegalArgumentException("O caminhao placa:" + caminhao.getPlaca() + "nao esta no patio");
        }
    }
    public void listarFila(){
        System.out.println("Fila de entrada: ");
        if(filaEntrada.isEmpty()){
            System.out.println("Fila de entrada vazia");
        }
        else{
            for(Caminhao caminhao : filaEntrada){
                System.out.println("-" + caminhao);
            }
        }

        System.out.println("Fila de saida: ");
        if(filaSaida.isEmpty()){
            System.out.println("A lista esta vazia");
        } else{
            for(Caminhao caminhao : filaSaida){
                System.out.println("-" + caminhao);

            }
        }
    }

}