package ExerciciosDoClass_1;

import java.time.*;

public class Exercicio_4 {
    public static void main(String[] args) {
        ZoneId fusoHorario = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime dataHora = ZonedDateTime.of(LocalDateTime.of(1993,5,26,15,23,2),fusoHorario);
        Instant instante1 = dataHora.toInstant();
        Instant instante2 = Instant.now();
        Duration diferenca = Duration.between(instante1,instante2);
        System.out.println("Difereça em horas: " + diferenca.toHours());
        System.out.println("Difereça em minutos: " + diferenca.toMinutes());
        System.out.println("Difereça em segundos: " + diferenca.toSeconds());
    }
}
