package Aula2;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Aula {
    public static void main(String[] args) {

        //LocalDate, LocalTime e LocalDatetime são imutáveis
        // Para usar o now e mudar algum valor (dia, hora, min, etc.) se usa o with
        LocalDateTime agoraAjusatado = LocalDateTime.now().withHour(5); // Configura a hora para ser às 5. Demais valores permanecem inalterados
        System.out.println(agoraAjusatado);
        LocalDate dataDeNascimento = LocalDate.of(1992,2,23);
        System.out.println(dataDeNascimento.getDayOfWeek());
        LocalDate primeiroDiaDoMesDeNascimento = dataDeNascimento.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(primeiroDiaDoMesDeNascimento.getDayOfWeek());
        LocalDate ultimoDiaDoMes = dataDeNascimento.with(TemporalAdjusters.lastDayOfMonth());
        DayOfWeek diaDaSemana = ultimoDiaDoMes.getDayOfWeek();
        System.out.println(ultimoDiaDoMes.getDayOfWeek());


        LocalDateTime dataParaDateTime = LocalDate.now().atTime(LocalTime.now());
        System.out.println(dataParaDateTime);

        LocalDateTime horaParaDateTime = LocalTime.now().atDate(LocalDate.now());
        System.out.println(horaParaDateTime+"\n");

        System.out.println("PERIOD: Representa um perídod de dias, meses e anos");
        ZoneId fusoSP = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime dataComFusoHorario = ZonedDateTime.of(LocalDateTime.now(),fusoSP);
        System.out.println(dataComFusoHorario);
        System.out.println("Usando o PERIOD para adicionar tempo (2anos, 3 meses, 5 dias)...");
        Period periodo = Period
                //.ofMonths(3);
        .of(2,3,5);
        ZonedDateTime novaDataComFusoHorario = dataComFusoHorario.plus(periodo);
        System.out.println(novaDataComFusoHorario);
        LocalDate hoje = LocalDate.now();
        Period tempoDeVida = Period.between(dataDeNascimento,hoje);
        System.out.println("Perido.getYears(): " + tempoDeVida.getYears());
        System.out.println("Perido.getMonths(): " + tempoDeVida.getMonths());
        System.out.println("Perido.getDays(): " + tempoDeVida.getDays());
        System.out.println("Perido.toTotalMonths(): " + tempoDeVida.toTotalMonths());
        long diasEntre = ChronoUnit.DAYS.between(dataDeNascimento,hoje);
        System.out.println("ChronoUnit.DAYS.between(dataDeNascimento,hoje) =  " + diasEntre+"\n");

        System.out.println("DURATION: Representa uma duração de horas, minutos e segundos");
        LocalTime horaAtual = LocalTime.now();
        Duration tresHorasDuracao = Duration.ofHours(3);
        LocalTime horaMaisTres = horaAtual.plus(tresHorasDuracao);
        System.out.println(horaMaisTres);
        Duration intervaloDeTempo = Duration.between(LocalTime.of(0,0),LocalTime.now());
        System.out.println(intervaloDeTempo.toHours());
        System.out.println(intervaloDeTempo.toMinutes());
        System.out.println();

        System.out.println("INSTANT: Representa o número de segundos e nanosegundos desde 1/1/1970");

        Instant instant = dataComFusoHorario.toInstant();
        long milisegundosDesde1970 = instant.toEpochMilli();
        System.out.println(milisegundosDesde1970);
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("-3")).toEpochMilli());
        System.out.println(ZonedDateTime.now().toInstant().toEpochMilli());



    }
}
