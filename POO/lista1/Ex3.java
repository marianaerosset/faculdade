package lista1;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Ex3 {
    public static void main(String[] args) {
        
    }
}

class Pessoa{
    private String nome;
    private Pessoa mae;
    private Pessoa pai;
    public Pessoa(String nome, Pessoa mae, Pessoa pai){ //a I
        this.nome = nome;
        this.mae = mae;
        this.pai = pai;
    }
    public Pessoa(String nome){                         //a II
        this.nome = nome;
        this.mae = null;
        this.pai = null;
    }
    public boolean equals(Pessoa p){                     //b
        if (p == null) return false;
        if (!this.nome.equals(p.nome)) return false;
        if (this.mae == null && p.mae == null) return true;
        if (this.mae == null || p.mae == null) return false;
        return this.mae.equals(p.mae);
    }
    public boolean irmao(Pessoa p){                     //c
        if (p == null || this.equals(p)) return false;
        boolean mesmaMae = (this.mae != null && p.mae != null && this.mae.equals(p.mae));
        boolean mesmoPai = (this.pai != null && p.pai != null && this.pai.equals(p.pai));
        return mesmaMae || mesmoPai;
    }
    public boolean ancestral(Pessoa p){                 //d
        if (p == null) return false;
        if ((this.pai != null && this.pai.equals(p)) || (this.mae != null && this.mae.equals(p))) {
            return true;
        }
        boolean ancestralPeloPai = (this.pai != null && this.pai.ancestral(p));
        boolean ancestralPelaMae = (this.mae != null && this.mae.ancestral(p));
        return ancestralPeloPai || ancestralPelaMae;
    }
}