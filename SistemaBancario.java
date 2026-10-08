import java.util.Scanner;

public class SistemaBancario {

    public static void main (String[] args){
    
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        Menu menu = new Menu(scanner,banco);
        Autenticacao autenticacao = new Autenticacao(banco);
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
                    fazerLogin(scanner, autenticacao, menu);
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


    public static void criaConta(Scanner scanner, Banco banco){
        System.out.println("===== CRIANDO CONTA =====");
        System.out.println("Digite seu Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        System.out.println("Qual o saldo inicial? ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        
        try {
            if (banco.adicionarConta(nome, senha, saldo)) {
                System.out.println("Conta criada com sucesso!");
            } else {
                System.out.println("Já existe uma conta com este nome!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fazerLogin(Scanner scanner, Autenticacao autenticacao, Menu menu) {

        System.out.println("Digite seu Nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        Conta conta = autenticacao.login(nome, senha);

        if (conta != null) {
            menu.executarMenu(conta);
        } else {
            System.out.println("Falha no login");
        }
}
}


                    