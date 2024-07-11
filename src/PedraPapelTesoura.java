import java.util.Random;
import java.util.Scanner;

public class PedraPapelTesoura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] options = { "pedra", "papel", "tesoura" };

        while (true) {
            System.out.print("Escolha pedra, papel, ou tesoura: ");
            String playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("pedra") && !playerChoice.equals("papel") && !playerChoice.equals("tesoura")) {
                System.out.println("Escolha inválida, tente novamente.");
                continue;
            }

            int computerIndex = random.nextInt(options.length);
            String computerChoice = options[computerIndex];

            System.out.println("Você escolheu " + playerChoice + ".");
            System.out.println("O computador escolheu " + computerChoice + ".");

            if (playerChoice.equals(computerChoice)) {
                System.out.println("É um empate!");
            } else if (playerChoice.equals("pedra") && computerChoice.equals("tesoura")
                    || playerChoice.equals("papel") && computerChoice.equals("pedra")
                    || playerChoice.equals("tesoura") && computerChoice.equals("papel")) {
                System.out.println("Você venceu!");
            } else {
                System.out.println("O computador venceu!");
            }

            System.out.print("Jogar de novo? (y/n): ");
            String answer = scanner.nextLine().toLowerCase();
            if (!answer.equals("y")) {
                break;
            }
        }

        System.out.println("Obrigado por jogar!");
    }
}
