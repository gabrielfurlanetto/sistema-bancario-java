import java.util.Scanner;

public class SistemaBancario {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        double saldo = 100;
        int option;

        do {
            System.out.println("\n\n===== BANCO =====\n");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("0 - Sair");

            option = scanner.nextInt();


            switch (option) {
                case 1:
                    consultar(saldo);
                    break;

                case 2: 
                    saldo = depositar(saldo,scanner);
                    break;
                
                case 3: 
                    saldo = sacar(saldo,scanner);
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;
            
                default:
                    System.out.println("Opção Inválida");
                    break;
            } 
        } while (option != 0); 
        scanner.close();
    }

    public static void consultar(double saldo){
        System.out.println("Seu saldo é de R$" + saldo);
    }

    public static double depositar(double saldo, Scanner scanner){
        System.out.println("Qual valor você deseja guardar?");
        double deposito = scanner.nextDouble();
        if (deposito > 0){
            System.out.println("Você depositou R$" + deposito);
            saldo = saldo + deposito;
        }
        else 
            System.out.println("Valor inválido!");
        return saldo;
    }

    public static double sacar(double saldo, Scanner scanner){
        System.out.println("Qual valor você deseja retirar?");
        double saque = scanner.nextDouble();
        if (saque > 0){
            if (saldo >= saque){
                System.out.println("Você sacou R$" + saque);
                saldo = saldo - saque;
            }
            else 
                System.out.println("Saldo insuficiente!");
        }
        else
            System.out.println("Valor inválido!");
        return saldo;
    }
}

