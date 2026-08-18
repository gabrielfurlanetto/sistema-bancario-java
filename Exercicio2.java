import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.println("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("Soma = "+(numero1+numero2));
        System.out.println("Subtração = "+(numero1-numero2));
        System.out.println("Multiplicação = "+(numero1*numero2));
        System.out.println("Divisão = "+(numero1/numero2));
        System.out.println("Resto = "+(numero1%numero2));

        if (numero1%2==0){
            System.out.println("O primeiro número digitado é par!");
        }
        else   
            System.out.println("O primeiro número digitado é impar!");

        if (numero2%2==0){
            System.out.println("O segundo número digitado é par!");
        }
        else   
            System.out.println("O segundo número digitado é impar! KKKKKK");
    }
}