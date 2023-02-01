package Aula2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Exercicio_III {
    public static void main(String[] args) {
        LocalDate dataDeNascimento = LocalDate.of(1992,2,23);
        System.out.println(dataDeNascimento.getDayOfWeek());
        System.out.println(dataDeNascimento.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek());
        System.out.println(dataDeNascimento.with(TemporalAdjusters.firstDayOfYear()).getDayOfWeek());
        System.out.println(dataDeNascimento.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek());
        System.out.println(dataDeNascimento.with(TemporalAdjusters.lastDayOfYear()).getDayOfWeek());
        System.out.println(dataDeNascimento.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
    }
}
