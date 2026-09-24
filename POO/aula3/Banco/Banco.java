package aula3.Banco;

public class Banco {
    // Atributos
    private String nome;
    private String cnpj;
    private float deposito;
    private int numBanco;
    private Agencia[] agencias;

    // Construtor
    public Banco(String nome, String cnpj, int numBanco){
        this.nome = nome;
        this.cnpj = cnpj;
        this.numBanco = numBanco;
        this.agencias = new Agencia[10];
    }

    // Métodos
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public String getCnpj(){
        return cnpj;
    }
    public float getDeposito(){
        return deposito;
    }
    public int getNumBanco(){
        return numBanco;
    }
    public void setAgencias(Agencia[] agencias){
        this.agencias = agencias;
    }
    public Agencia[] getAgencias(){
        return agencias;
    }
    public void depositar(float valor){
        this.deposito += valor;
    }
    public void sacar(float valor){
        if(valor > deposito){
            System.out.println("Saldo insuficiente.");
        } else {
            this.deposito -= valor;
        }
    }
}
