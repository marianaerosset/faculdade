package lista1;

public class Ex.4 {
    public static void main(String[] args) {
        
    }
}

abstract class Animal{
    protected String nome;              //a
    abstract void emitirSom();          //b
    public void dormir(){               //c
        System.out.println("O animal está dormindo.");
    }
}

class Cachorro extends Animal{
    public Cachorro(String nome){
        this.nome = nome;
    }
    @Override
    void emitirSom(){
        System.out.println("Au au au");
    }
}

class Gato extends Animal{
    public Gato(String nome){
        this.nome = nome;
    }
    @Override
    void emitirSom(){
        System.out.println("Miau miau miau");
    }
}

