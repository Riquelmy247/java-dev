import java.util.concurrent.TimeUnit;

public class Cronometro {
    public static void main(String[] args) throws InterruptedException {
        int seconds = 5;

        for (int i = seconds; i >= 0; i--) {
            System.out.println("Tempo restante: " + i + " segundos");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Acabou o tempo!");
    }
}