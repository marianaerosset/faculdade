import java.util.Scanner;

public class MediaAlun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira o número de alunos: ");
        int x = sc.nextInt();
        for(int i = 1; i<=x; i++){
            //System.out.printf("Insira a primeira nota do aluno %d: ", i);
            System.out.printf("Insira as 3 notas do aluno %d: ", i);
            double n1 = sc.nextDouble();
            //System.out.printf("Insira a segunda nota do aluno %d: ", i);
            double n2 = sc.nextDouble();
            //System.out.printf("Insira a terceira nota do aluno %d: ", i);
            double n3 = sc.nextDouble();

            double media = (n1+n2+n3)/3;
            if(media<5){
                System.out.printf("\nAluno %d: Reprovado com média %.2f\n", i, media);
            } else {
                System.out.printf("\nAluno %d: Aprovado com média %.2f\n", i, media);
            }
        }

        sc.close();
    }
}
