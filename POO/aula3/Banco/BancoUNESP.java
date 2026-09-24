package aula3.Banco;
import java.util.Scanner;

public class BancoUNESP {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha = 0, numConta, idConsulta, i;
        float valor;
        String nome, cpf;
        Conta[] contas = new Conta[100];
        while(escolha!=6){
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Realizar depósito");
            System.out.println("4 - Realizar saque");
            System.out.println("5 - Listar dados da conta");
            System.out.println("6 - Sair");
            escolha = sc.nextInt();
            sc.nextLine();
            switch(escolha){
                case 1:
                    System.out.print("Insira o nome do titular da conta: ");
                    nome = sc.nextLine();
                    System.out.print("Insira o CPF do titular da conta: ");
                    cpf = sc.nextLine();
                    contas[Conta.totContas] = new Conta(nome, cpf);
                    numConta = contas[Conta.totContas-1].getNumConta();
                    System.out.println("Conta criada com ID: " +numConta);
                    break;
                case 2:
                    System.out.print("Insira o ID da conta: ");
                    idConsulta = sc.nextInt();
                    for(i=0; i<Conta.totContas; i++){
                        if(contas[i].getNumConta() == idConsulta){
                            System.out.printf("Saldo: R$ %.2f\n", contas[i].getSaldo());
                            break;
                        }
                    }
                    if(i==Conta.totContas){
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Insira o ID da conta: ");
                    idConsulta = sc.nextInt();
                    for(i=0; i<Conta.totContas; i++){
                        if(contas[i].getNumConta() == idConsulta){
                            System.out.printf("Insira o valor do depósito: ");
                            valor = sc.nextFloat();
                            contas[i].depositar(valor);
                            break;
                        }
                    }
                    if(i==Conta.totContas){
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Insira o ID da conta: ");
                    idConsulta = sc.nextInt();
                    for(i=0; i<Conta.totContas; i++){
                        if(contas[i].getNumConta() == idConsulta){
                            System.out.printf("Insira o valor do saque: ");
                            valor = sc.nextFloat();
                            contas[i].sacar(valor);
                            break;
                        }
                    }
                    if(i==Conta.totContas){
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.print("Insira o ID da conta: ");
                    idConsulta = sc.nextInt();
                    for(i=0; i<Conta.totContas; i++){
                        if(contas[i].getNumConta() == idConsulta){
                            System.out.println("Dados da conta:");
                            System.out.println("Nome: " +contas[i].getNome());
                            System.out.println("CPF: " +contas[i].getCpf());
                            System.out.println("Saldo: R$ " +contas[i].getSaldo());
                            System.out.println("Número da conta: " +contas[i].getNumConta());
                            System.out.println("Agência: " +contas[i].getAgencia());
                            break;
                        }
                    }
                    if(i==Conta.totContas){
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }
}
