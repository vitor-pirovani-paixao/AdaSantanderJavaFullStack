package ExerciciosDoClass_1;

import java.time.*;

public class Exercicio_3 {
    public static void main(String[] args) {
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);
        Instant desde1970 = agora.toInstant(ZoneOffset.of("-3"));
        System.out.println(desde1970);
        LocalDateTime fromInstant = LocalDateTime.ofInstant(desde1970, ZoneId.of("America/Sao_Paulo"));
        System.out.println(fromInstant);

    }
}
