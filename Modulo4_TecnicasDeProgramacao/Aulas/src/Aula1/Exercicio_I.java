package Aula1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exercicio_I {
    public static void main(String[] args) {
        String data = "23/02/1992";
        String hora = "23:58:35";

        LocalDate dataObjeto = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(dataObjeto);
        LocalTime horaObjeto = LocalTime.parse(hora,DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(horaObjeto);
        LocalDateTime dataHora = LocalDateTime.of(dataObjeto,horaObjeto);
        System.out.println(dataHora);


    }
}
