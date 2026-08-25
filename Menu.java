import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }
    public void executarMenu(Conta conta){

        int option;
        double valor;

        System.out.println("Login realizado! Seja bem vindo(a) " + conta.getNome());
        do {
            System.out.println("\n\n===== BANCO =====\n");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");
            
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println(conta.getNome()+", seu saldo é de R$" + conta.getSaldo());
                    break;

                case 2:
                    System.out.println("Qual valor deseja depositar?");
                    valor = scanner.nextDouble();
                    conta.depositar(valor);
                    break;
                
                case 3:
                    System.out.println("Qual valor deseja sacar?");
                    valor = scanner.nextDouble();
                    conta.sacar(valor);
                    break;

                case 0:
                    System.out.println("Saindo da Conta");
                    break;
            
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (option != 0);
    }
}