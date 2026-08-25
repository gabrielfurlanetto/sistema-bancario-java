import java.util.Scanner;

public class SistemaBancario {

    public static void main (String[] args){
        
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        Menu menu = new Menu(scanner);
        boolean programaRodando = true;

        while (programaRodando){
            System.out.println("\n\n===== BANCO =====");
            System.out.println("1 - Login");
            System.out.println("2 - Criar Conta");
            System.out.println("0 - Sair");
            int io = scanner.nextInt();
            scanner.nextLine();

            switch (io) {
                case 1:
                    Login(scanner,menu,banco);
                    break;
                
                case 2:
                    criaConta (scanner,banco);
                    break;
                
                case 0:
                    programaRodando = false;
                    break;
            
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        scanner.close();
    }  


    public static void Login(Scanner scanner, Menu menu, Banco banco){
        Conta conta;
        System.out.println("Digite seu Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();
        conta = banco.buscaConta(nome,senha);
        
        if (conta!=null){
            menu.executarMenu(conta);
        }
        else 
            System.out.println("Usuário ou senha Incorreto\n");
    }

    public static void criaConta (Scanner scanner, Banco banco){
        System.out.println("===== CRIANDO CONTA =====");
        System.out.println("Digite seu Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        System.out.println("Qual o saldo inicial? ");
        double saldo = scanner.nextDouble();
        
        try {
            Conta x = new Conta(nome, senha, saldo);

            if (banco.adicionarConta(x)) {
                System.out.println("Conta criada com sucesso!");
            } else {
                System.out.println("Já existe uma conta com este nome!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


                    