package Aula2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Exercicio_II {
    public static void main(String[] args) {
        BigDecimal debito = BigDecimal.valueOf(64000);
        int numeroDeParcelas = 48;
        BigDecimal valorDaParcela = debito.divide(BigDecimal.valueOf(numeroDeParcelas),2, RoundingMode.HALF_UP);

        for (int i = 1; i <= numeroDeParcelas ; i++) {
            Period mesDaParcela = Period.ofMonths(i);
            DayOfWeek diaDoPagamento = LocalDateTime.now().plus(mesDaParcela).getDayOfWeek();
            ZonedDateTime dataDePagamento;
            if (diaDoPagamento == DayOfWeek.SATURDAY || diaDoPagamento == DayOfWeek.SUNDAY){
                dataDePagamento = ZonedDateTime.now().plus(mesDaParcela).with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }else {
                dataDePagamento = ZonedDateTime.now().plus(mesDaParcela);
            }
            System.out.printf("Pacela %d de R$ %.2f vence em %s \n",i,valorDaParcela,dataDePagamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        }
    }
}
