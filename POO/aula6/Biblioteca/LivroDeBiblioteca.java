package aula6.Biblioteca;

public class LivroDeBiblioteca extends Livro implements ItemDeBiblioteca {
    private boolean estaEmprestado;
    private String localizacao;
    
    public LivroDeBiblioteca(String titulo, String autor, String isbn, String localizacao){
        super(titulo, autor, isbn);
        this.localizacao = localizacao;
        this.estaEmprestado = false;
    }

    public void modificaEmprestimo(Estado estado){
        if(estado == Estado.EMPRESTADO){
            estaEmprestado = true;
            System.out.println("O livro está emprestado e deve ser");
            System.out.println("devolvido em "+maxDiasEmprestimo+" dias.");
        } else if{
            estaEmprestado = false;
            System.out.println("O livro foi devolvido e está disponível para empréstimo.");
        }
    }
}
