package Aula2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Exercicio_I {
    public static void main(String[] args) {
        ZoneId fusoSP = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime horaComFusoHorario = ZonedDateTime.of(LocalDateTime.now(),fusoSP);
        System.out.println(horaComFusoHorario);
    }
}
