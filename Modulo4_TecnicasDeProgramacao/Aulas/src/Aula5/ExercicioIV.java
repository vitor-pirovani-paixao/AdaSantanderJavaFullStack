package Aula5;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioIV {
    public static void main(String[] args) {
        var transacoes = List.of(
                new Transacao("Vitor", new BigDecimal(7000), "Saque"),
                new Transacao("Vitor", new BigDecimal(12000), "Saque"),
                new Transacao("Vitor", new BigDecimal(10000), "Deposito"),
                new Transacao("José", new BigDecimal(3000), "Deposito"),
                new Transacao("José", new BigDecimal(6000), "Transferencia"),
                new Transacao("José", new BigDecimal(4320), "Transferencia"),
                new Transacao("José", new BigDecimal(4000), "Transferencia")
        );

        System.out.println(transacoes.stream()
                .collect(Collectors.groupingBy(transacao -> transacao.cliente(),
                                Collectors.counting()
                        )
                )
        );
    }
}

record Transacao(String cliente, BigDecimal valor, String tipo) {
}
