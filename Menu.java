import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Banco banco;

    public Menu(Scanner scanner, Banco banco) {
        this.scanner = scanner;
        this.banco = banco;
    }
    public void executarMenu(Conta conta){

        int option;
        double valor;

        System.out.println("\nLogin realizado! Seja bem vindo(a) " + conta.getNome());
        do {
            System.out.println("\n===== BANCO ===== Conta Nº " + conta.getNumero() + "\n");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Extrato Bancário");
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
                    if(conta.creditar(valor)){
                        System.out.println("Deposito realizado com sucesso");
                    }
                    else{
                        System.out.println("Falha na tentativa de depósito");
                    }
                    break;
                
                case 3:
                    System.out.println("Qual valor deseja sacar?");
                    valor = scanner.nextDouble();
                    if (conta.debitar(valor)){
                        System.out.println("Você sacou R$" + valor);
                    }
                    else{
                        System.out.println("Não foi possível realizar o saque.");
                    }
                    break;

                case 4:
                    System.out.println("Número da conta destino: "); 
                    int numeroConta = scanner.nextInt();
                    scanner.nextLine();
                    Conta conta2 = banco.buscaContaNumero(numeroConta); //estou aqui 
                    if (conta2 == null) System.out.println("Numero da conta destinatário incorreto!");
                    else{
                        System.out.println("Qual o valor desejas transferir?");
                        valor = scanner.nextDouble();
                        scanner.nextLine();
                        if(banco.transferir(conta,conta2,valor)){
                            System.out.println("Transferência realizada com sucesso");
                        }
                        else {
                            System.out.println("Falha na transferência");
                        }

                    }
                    break;

                case 5:
                    System.out.println("\n===== EXTRATO BANCÁRIO =====");
                    conta.imprimeExtrato();
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