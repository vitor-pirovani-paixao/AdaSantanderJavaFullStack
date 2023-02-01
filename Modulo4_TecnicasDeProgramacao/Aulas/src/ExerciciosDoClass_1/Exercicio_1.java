package ExerciciosDoClass_1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a primiera data?(Formato dd/MM/yyyy)");
        String dataTexto1 = sc.nextLine().trim();
        LocalDate data1 = LocalDate.parse(dataTexto1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Qual a segunda data?(Formato dd/MM/yyyy)");
        String dataTexto2 = sc.nextLine().trim();
        LocalDate data2 = LocalDate.parse(dataTexto2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        sc.close();

        System.out.printf("Entre as duas datas fonecidas há %s ano(s), %s mes(es) e %s dia(s) de diferença",
                Period.between(data1, data2).getYears() > 0 ?
                        Period.between(data1, data2).getYears() :
                        -Period.between(data1, data2).getYears(),
                Period.between(data1, data2).getMonths() > 0 ?
                        Period.between(data1, data2).getMonths() :
                        -Period.between(data1, data2).getMonths(),
                Period.between(data1, data2).getDays() > 0 ?
                        Period.between(data1, data2).getDays() :
                        -Period.between(data1, data2).getDays());

    }
}
