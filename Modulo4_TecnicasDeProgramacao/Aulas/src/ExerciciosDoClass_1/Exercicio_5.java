package ExerciciosDoClass_1;

import java.time.Duration;
import java.util.Scanner;

public class Exercicio_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de segundos a ser convertida:");
        String segundosTexto = sc.nextLine().trim();
        sc.close();
        Duration segundos = Duration.parse("PT" + segundosTexto + "S");
        long dias = segundos.toDays();
        long horas = segundos.toHoursPart();
        long minutos = segundos.toMinutesPart();
        long segundo = segundos.toSecondsPart();
        System.out.printf("%s segundos equivalem a %s dia(s), %s hora(s), %s minuto(s) e %d segundo(s)",
                segundosTexto, dias, horas, minutos, segundo);


    }
}
