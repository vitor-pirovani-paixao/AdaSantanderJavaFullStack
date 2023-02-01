package ExerciciosDoClass_1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio_6 {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a data da primiera dose (Formato dd/MM/yyyy):");
        LocalDate dataPrimieraDose = LocalDate.parse(sc.nextLine().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataProximaAplicacao;
        for (int i = 1; i < 4; i++) {
            DayOfWeek diaDaAplicacao = dataPrimieraDose.plusMonths(3 * i).getDayOfWeek();
            if (diaDaAplicacao == DayOfWeek.SATURDAY) {
                dataProximaAplicacao = dataPrimieraDose.plusMonths(3 * i).with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            } else if (diaDaAplicacao == DayOfWeek.SUNDAY) {
                dataProximaAplicacao = dataPrimieraDose.plusMonths(3 * i).with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            } else {
                dataProximaAplicacao = dataPrimieraDose.plusMonths(3 * i);
            }
            System.out.printf("Dose %d: Aplicação em %s (%s)\n",
                    i + 1,
                    dataProximaAplicacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    dataProximaAplicacao.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()));
        }
    }
}
