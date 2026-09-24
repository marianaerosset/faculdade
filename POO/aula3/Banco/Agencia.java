package aula3.Banco;

public class Agencia {
    // Atributos
    private String nome;
    private int numAgencia;
    private int numBanco;
    private Conta[] contas;

    // Construtor
    public Agencia(String nome, int numAgencia, int numBanco){
        this.nome = nome;
        this.numAgencia = numAgencia;
        this.numBanco = numBanco;
        this.contas = new Conta[100];
    }

    // Métodos
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public int getNumAgencia(){
        return numAgencia;
    }
    public int getNumBanco(){
        return numBanco;
    }
    public void setContas(Conta[] contas){
        this.contas = contas;
    }
    public Conta[] getContas(){
        return contas;
    }
    public void buscarConta(int numConta){
        for(Conta conta : contas){
            if(conta.getNumConta() == numConta){
                System.out.println("Conta encontrada: " + conta.getNome());
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
}
