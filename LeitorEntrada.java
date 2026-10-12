import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitorEntrada {

   public int lerInt(Scanner scanner) {
    int x;

        while (true) {
            try {
                x = scanner.nextInt();
                scanner.nextLine();
                return x;
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números inteiros, insira novamente:");
                scanner.nextLine();
            }
        }
    }

    public double lerDouble(Scanner scanner) {
        while (true) {
            try {
                String entrada = scanner.nextLine().trim().replace(',', '.');
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número, por exemplo 10.50 ou 10,50:");
            }
        }
    }
}

