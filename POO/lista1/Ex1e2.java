import java.util.*;

public class Ex1e2 {
    public static void main(String[] args) {
        
    }
}

class Pais{
    private String iso;
    private String nome;
    private int populacao;
    private double area;
    List<Pais> fronteiras = new ArrayList<>();

    public Pais(String iso, String nome, double area){  //a
        this.iso = iso;
        this.nome = nome;
        this.area = area;
    }
    public void setIso(String iso) {                    //b
        this.iso = iso;
    }
    public String getIso() {
        return iso;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }  
    public String getNome() {
        return nome;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public double getArea() {
        return area;
    }
    public boolean equals(Pais p){                      //c
        return this.iso.equals(p.getIso());
    }
    public boolean fazFronteira(Pais p){                //d
        for(Pais fronteira : this.fronteiras){
            if(fronteira.equals(p)){
                return true;
            }
        }
        return false;
    }
    public double densidadePopulacional(){              //e
        return getPopulacao()/getArea();
    }
    public List<Pais> fronteirasComum(Pais p){          //f
        List<Pais> vizinhos = new ArrayList<>();
        for(Pais fronteira : p.fronteiras){
            if(this.fazFronteira(fronteira)){
                vizinhos.add(fronteira);
            }
        }
        return vizinhos;
    }
}

class Continente{
    private String nome;
    List<Pais> paises = new ArrayList<>();
    public Continente(String nome){                     //a
        this.nome = nome;
    }  
    public void addPais(Pais p){                        //b
        paises.add(p);
    }
    public double areaTotal(){                          //c
        double area = 0;
        for(Pais p : paises) area += p.getArea();
        return area;
    }
    public long populacaoTotal(){                       //d
        long populacao = 0;
        for(Pais p : this.paises) populacao += p.getPopulacao();
        return populacao;
    }
    public double densidadePopulacional(){              //e
        return populacaoTotal()/areaTotal();
    }
    public Pais maiorPopulacao(){                       //f
        Pais maior = paises.get(0);
        for(Pais p : paises){
            if(p.getPopulacao() > maior.getPopulacao()){
                maior = p;
            }
        }
        return maior;
    }
    public Pais menorPopulacao(){                       //g
        Pais menor = paises.get(0);
        for(Pais p : paises){
            if(p.getPopulacao() < menor.getPopulacao()){
                menor = p;
            }
        }
        return menor;
    }
    public Pais maiorArea(){                            //h
        Pais maior = paises.get(0);
        for(Pais p : paises){
            if(p.getArea() > maior.getArea()){
                maior = p;
            }
        }
        return maior;
    }
    public Pais menorArea(){                            //i
        Pais menor = paises.get(0);
        for(Pais p : paises){
            if(p.getArea() < menor.getArea()){
                menor = p;
            }
        }
        return menor;
    }
}
