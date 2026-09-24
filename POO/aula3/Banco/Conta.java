package aula3.Banco;

public class Conta {
    // Atributos
    private String nome;
    private String cpf;
    private float saldo;
    private int numConta;
    private int agencia;
    public static int totContas = 0;

    // Construtor
    public Conta(String nome, String cpf){
        this(nome, cpf, 0, totContas+1001, 1);
        totContas++;
    }
    public Conta(String nome, String cpf, float saldo, int numConta, int agencia){
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
        this.numConta = numConta;
        this.agencia = agencia;
    }

    // Métodos getters e setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public float getSaldo(){
        return saldo;
    }
    public int getNumConta(){
        return numConta;
    }
    public int getAgencia(){
        return agencia;
    }

    // Outros métodos
    public void depositar(float valor){
        saldo += valor;
    }
    public void sacar(float valor){
        if(saldo >= valor){
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}
