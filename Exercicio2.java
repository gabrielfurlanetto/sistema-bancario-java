import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1 - Verifica se é par ou ímpar");
            System.out.println("2 - Verifica Soma,Sub,Mult,Div e Resto");
            System.out.println("0 - Sair do Programa");
            choice = scanner.nextInt();
            switch (choice){    
                case 1:
                    System.out.println("Digite o primeiro número: ");
                    double numero3 = scanner.nextDouble();

                    System.out.println("Digite o segundo número: ");
                    double numero4 = scanner.nextDouble();

                    if (numero3%2==0){
                    System.out.println("O primeiro número digitado é par!");
                    }
                    else   
                        System.out.println("O primeiro número digitado é impar!");

                    if (numero4%2==0){
                        System.out.println("O segundo número digitado é par!");
                    }
                    else   
                        System.out.println("O segundo número digitado é impar!");
                    break;
                
                case 2:
                    System.out.println("Digite o primeiro número: ");
                    double numero1 = scanner.nextDouble();

                    System.out.println("Digite o segundo número: ");
                    double numero2 = scanner.nextDouble();

                    System.out.println("Soma = "+(numero1+numero2));
                    System.out.println("Subtração = "+(numero1-numero2));
                    System.out.println("Multiplicação = "+(numero1*numero2));
                    System.out.println("Divisão = "+(numero1/numero2));
                    System.out.println("Resto = "+(numero1%numero2));
                    break;
                
                case 0:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
            }
        } while (choice!=3);
    }
}

    