package Aula1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Aula {
    public static void main(String[] args) {

        // DATAS

        // Primeira classes (Date) - Obsoleto

        Date data = new Date(); // Fixa a data sempre aqui desde 1970.

        System.out.println(data.getTime());

        // Posteriormnet surgiu o Calendar. Ele não precisa ser instanciado, pois é static
        // Tem problema com fuso-horário.
        Calendar dataDeNascimento = Calendar.getInstance();
        dataDeNascimento.set(Calendar.YEAR,1992);
        dataDeNascimento.set(Calendar.MONTH, 2);
        dataDeNascimento.set(Calendar.DAY_OF_MONTH, 23);

        System.out.println(dataDeNascimento);

        // A partir do Java 1.8 foi desenvolvido a nova API de datas:
        // API é java.time
        // LocalDate para datas, LocalTime para horas e LocalDateTime para data e hora
        LocalDate agoraData = LocalDate.now();
        System.out.println(agoraData);
        LocalTime agoraHora = LocalTime.now();
        System.out.println(agoraHora);

        LocalDate nascimento = LocalDate.of(1992,2,23);
        System.out.println("Data de nascimento: " + nascimento);

        LocalTime horaEspecificada  = LocalTime.of(15,25,39);
        System.out.println("Hora: " + horaEspecificada);

        LocalDateTime dataHora = LocalDateTime.of(1992,2,23,7,55,33);
        System.out.println(dataHora);
        //ou
        LocalDateTime dataHora2 = LocalDateTime.of(nascimento,horaEspecificada);
        System.out.println(dataHora2);

        System.out.println("Convertendo String em data...");
        System.out.println("Por padrão é yyyy-MM-dd");
        System.out.println("MM é para mês e mm é para minuto");
        LocalDate textoParaDataPadrao = LocalDate.parse("1992-02-23");
        System.out.println(textoParaDataPadrao);
        System.out.println("Mudando o padrão para dd/MM/yyyy");
        LocalDate textoParaData = LocalDate.parse("23/02/1992", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(textoParaData+"\n");

        System.out.println("Convertendo texto em hora...");
        System.out.println("Por padrão é HH:mm:ss");
        System.out.println("HH para formato 24h e hh para formato 12h ");
        LocalTime textoParaHoraPadrao = LocalTime.parse("23:25:01");
        System.out.println(textoParaHoraPadrao);
        LocalTime textoParaHora = LocalTime.parse("23:57", DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(textoParaHora+"\n");

        System.out.println("Convertendo texto em data e hora...");
        System.out.println("Por padrão é yyyy-MM-ddTHH:mm:ss");
        String dataHoraPadrao = "1992-02-23T07:25:23";
        LocalDateTime textoParaDataHoraPadrao= LocalDateTime.parse(dataHoraPadrao);
        System.out.println(textoParaDataHoraPadrao);
//        LocalDateTime textoParaDataHora = LocalDateTime.parse("2023-01-22 21:55 PM",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a"));
        LocalDateTime textoParaDataHora = LocalDateTime.parse("2023-01-22 09:55 AM",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a"));
        System.out.println(textoParaDataHora+"\n");

        System.out.println("Convertendo data e/ou hora para String...");
        LocalDate now = LocalDate.now();
        String dataFormatada = now.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        System.out.println(now + " para " + dataFormatada);

        LocalDate nowPlus = now.plusYears(3);
        nowPlus = nowPlus.plusDays(69);
        nowPlus = nowPlus.plusMonths(13);
        nowPlus = nowPlus.plusWeeks(3);
        System.out.println(nowPlus);

        LocalDate nowMinus = nowPlus.minusYears(3);
        nowMinus = nowMinus.minusDays(69);
        nowMinus = nowMinus.minusMonths(13);
        nowMinus = nowMinus.minusWeeks(3);
        System.out.println(nowMinus+"\n");

        System.out.println("Datas com Fuso-horário");
        ZoneId fusoSP = ZoneId.of("America/Sao_Paulo");
        ZoneId fusoLA = ZoneId.of("America/Los_Angeles");

        ZonedDateTime dateTimeSP= ZonedDateTime.of(LocalDateTime.now(),fusoSP);
        ZonedDateTime dateTimeLA= ZonedDateTime.of(LocalDateTime.now(),fusoLA);
        System.out.println(dateTimeSP);
        System.out.println(dateTimeLA);


    }
}