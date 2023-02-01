package ExerciciosDoClass_1;

import java.time.Duration;
import java.time.LocalTime;

public class Exercicio_2 {
    public static void main(String[] args) throws InterruptedException {
        LocalTime agora = LocalTime.now();
        if (true) {
            Thread.sleep(20);
        }
        LocalTime depois = LocalTime.now();
        long duracao = Duration.between(agora, depois).toMillis();
        System.out.printf("O tempo total de execução foi %d milissegundos", duracao);
    }
}
