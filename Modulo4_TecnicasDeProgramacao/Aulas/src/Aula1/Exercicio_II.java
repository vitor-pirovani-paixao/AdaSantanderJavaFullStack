package Aula1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Exercicio_II {
    public static void main(String[] args) {
        BigDecimal valorTotal = BigDecimal.valueOf(64000);
        int numeroDeParcelas = 48;
        BigDecimal valorDaParcela = valorTotal.divide(BigDecimal.valueOf(numeroDeParcelas), 2, RoundingMode.HALF_UP);
        LocalDateTime dataHoraAtuais = LocalDateTime.now();

        for (int i = 1; i <= numeroDeParcelas ; i++) {
            System.out.printf("Pacela %d de R$ %.2f vence em %s \n",i,valorDaParcela,dataHoraAtuais.plusMonths(i));
        }
    }
}
