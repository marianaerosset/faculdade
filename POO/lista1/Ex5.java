import java.util.*;

public class Ex5 {
    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[3];
        funcionarios[0] = new Gerente("Mariana Elias", 9000);
        funcionarios[1] = new Programador("Vitor Henrique", 5000);
        funcionarios[2] = new Programador("Laura Ishi", 4000);
        
        for(Funcionario f : funcionarios){
            Bonificacao bonificado = (Bonificacao) f;
            System.out.println("Nome: " + f.nome);
            System.out.printf("Salário: R$ %.2f\n", f.calcularSalario());
            System.out.printf("Bônus: R$ %.2f\n", bonificado.calcularBonus());
            System.out.println();
        }
    }
}

abstract class Funcionario{
    protected String nome;
    protected double salarioBase;
    public abstract double calcularSalario();
}

interface Bonificacao{
    double calcularBonus();
}

class Gerente extends Funcionario implements Bonificacao{
    public Gerente(String nome, double salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
    }
    @Override
    public double calcularBonus(){
        return this.salarioBase * 0.2;
    }
    @Override
    public double calcularSalario(){
        return this.salarioBase + calcularBonus();
    }
}

class Programador extends Funcionario implements Bonificacao{
    public Programador(String nome, double salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
    }
    @Override
    public double calcularBonus(){
        return this.salarioBase * 0.1;
    }
    @Override
    public double calcularSalario(){
        return this.salarioBase + calcularBonus();
    }
}