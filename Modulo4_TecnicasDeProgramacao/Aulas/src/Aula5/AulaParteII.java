package Aula5;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AulaParteII {
    public static void main(String[] args) {
        System.out.println("Reduce");
        var pessoas = List.of(
                new Pessoa("Vitor", 30),
                new Pessoa("João", 25),
                new Pessoa("Maria", 15),
                new Pessoa("José", 70),
                new Pessoa("Luiz", 27),
                new Pessoa("Alberto", 49),
                new Pessoa("Gertrudes", 96)
        );
        // Calcular o somatório de todas as idades de pessoas
//        System.out.println(
//                pessoas.stream()
//                        .map(pessoa -> pessoa.idade())
//                        .reduce(0,(acumulador,idade)->acumulador+idade)
//        );
        System.out.println(
                pessoas.stream()
                        .reduce(0,(acumulador,pessoa)->acumulador+ pessoa.idade(),(a,b)->a+b)
        );
        System.out.println();

        System.out.println("Stream de tipos primitivos: IntStream(), LongStream(), DoubleStream()...");
        System.out.println(
                pessoas.stream()
                        .mapToInt(Pessoa::idade)
                        .sum()
        );
        // outro exemplo
        IntStream streamDeInterios = IntStream.range(0,10); // Cria uma stream de 0 a 9 de (int)
        System.out.println(streamDeInterios.sum());
        IntStream streamDeInterios2 = IntStream.range(0,10); // Cria uma stream de 0 a 9 de (int). Para incluir o 10 deve-se usar o rangeClosed(0,10)
        System.out.println(streamDeInterios2.average().getAsDouble());

        IntSummaryStatistics statistics = IntStream.range(0,10).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());

        // flatMap : [ [a,b],[c,d]]
        var ab = List.of("a","b");
        var cd = List.of("c","d");

        List<String> strings = Stream.of(ab,cd)
                .flatMap(lista->lista.stream())
                .toList();
        System.out.println(strings);
        System.out.println();

        System.out.println("Optional: Para evitar nullPointerException");
        Optional<Aluno> optional = Optional.of(new Aluno("Vitor", 9.5));
        optional.ifPresent(System.out::println);

    }
}

