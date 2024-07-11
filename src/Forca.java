import java.util.Scanner;

public class Forca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = { "banana", "uva", "maça", "pêra", "manga", "kiwi", "abacaxi", "morango" };

        String word = words[(int) (Math.random() * words.length)];

        StringBuilder display = new StringBuilder(word.length());
        for (int i = 0; i < word.length(); i++) {
            display.append('-');
        }
        int guesses = 7;
        StringBuilder usedLetters = new StringBuilder();

        while (guesses > 0) {
            System.out.println("____________________________________________");
            System.out.println("Palavra: " + display);
            System.out.println(" ");
            System.out.println("Suposições deixadas: " + guesses);
            System.out.println("Letras usadas: " + usedLetters);
            System.out.println(" ");

            System.out.print("Adivinhe uma letra: ");
            String input = scanner.nextLine().toLowerCase();
            char letter = input.charAt(0);

            if (usedLetters.indexOf(input) != -1) {
                System.out.println("Você já adivinhou essa letra, tente novamente.");
                System.out.println(" ");
                continue;
            }

            usedLetters.append(letter);

            boolean correct = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    display.setCharAt(i, letter);
                    correct = true;
                }
            }

            if (!correct) {
                guesses--;
            }

            if (display.indexOf("-") == -1) {
                System.out.println(" ");
                System.out.println("Parabéns, você venceu! A palavra era: " + word);
                return;
            }
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Desculpe, você perdeu. A palavra era: " + word);
    }
}
