package Aula8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.*;

public class Exercicio {
    public static void main(String[] args) {
        Queue<NotaFiscal> filaDeNotas = new LinkedBlockingQueue<>();
        NotaFiscal notaFiscal1 = new NotaFiscal(UUID.randomUUID(),
                BigDecimal.valueOf(Math.random()).multiply(BigDecimal.valueOf(1000)),
                LocalDateTime.of(2023,2,25,7,23));
        NotaFiscal notaFiscal2 = new NotaFiscal(UUID.randomUUID(),
                BigDecimal.valueOf(Math.random()).multiply(BigDecimal.valueOf(1000)),
                LocalDateTime.of(2023,7,25,23,29));
        NotaFiscal notaFiscal3 = new NotaFiscal(UUID.randomUUID(),
                BigDecimal.valueOf(Math.random()).multiply(BigDecimal.valueOf(1000)),
                LocalDateTime.of(2023,5,15,9,11));
        NotaFiscal notaFiscal4 = new NotaFiscal(UUID.randomUUID(),
                BigDecimal.valueOf(Math.random()).multiply(BigDecimal.valueOf(1000)),
                LocalDateTime.of(2023,2,2,11,45));
        filaDeNotas.add(notaFiscal1);
        filaDeNotas.add(notaFiscal2);
        filaDeNotas.add(notaFiscal3);
        filaDeNotas.add(notaFiscal4);

        EnviadorDeNotaFiscal enviadorDeNF = new EnviadorDeNotaFiscal(filaDeNotas);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(enviadorDeNF,0,2,TimeUnit.SECONDS);



    }

}
