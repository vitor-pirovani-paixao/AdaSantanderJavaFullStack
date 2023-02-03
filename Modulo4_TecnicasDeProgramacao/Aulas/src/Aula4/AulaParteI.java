package Aula4;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AulaParteI {
    public static void main(String[] args) {

        System.out.println("STREAMS");
        Stream<String> streamVazia = Stream.empty();// Criam uma stream vazia
        System.out.println(streamVazia.count());
        Stream<Integer> numeros = Stream.of(10, -10, 2, 2, 4, 5, 6, 7, 8, 9);
//        System.out.println(numeros.count());
        System.out.println();

        System.out.println("Stream infinita");
        // generate() vai rodar infinitamnet a lambda passada para ele
        // iterate() pode ser tanto finito quanto infinito. Recebe uma seed, uma lambda de checagem (se for finito) e
        // uma lambda de execução
//        Stream.generate(() -> Math.random()).forEach(elemento -> System.out.println(elemento));
//        Stream.iterate(2, num -> num + 2).forEach(elem -> System.out.println(elem));
        Stream.iterate(1, num -> num < 10, num -> num * 2).forEach(elem -> System.out.println(elem));
        System.out.println();

        System.out.println("Stream Finita");
        System.out.println("-Métodos terminais");
//        System.out.println("count()" + numeros.count());
//        System.out.println("min() " + numeros.min((num1,num2)->num1-num2).get());
        System.out.println("max(): " + numeros.max((num1, num2) -> num1 - num2).get());
        System.out.println();

        System.out.println("findAny(): Busca qualquer elemento dentro da stream e findFirst(): busca o rpimeiro elemento");
        Stream<Integer> numerosImpares1 = Stream.iterate(1, n -> n < 10, n -> n + 2);
        System.out.println(numerosImpares1.findAny().get());
        Stream<Integer> numerosImpares2 = Stream.iterate(1, n -> n < 10, n -> n + 2);
        System.out.println(numerosImpares2.findFirst().get());
        System.out.println();

        System.out.println("allMatch():verifica se todos antedem critério, anyMatch():se algum antende, e noneMatch(): se nenhum");
        Stream<Integer> todosSaoImpares1 = Stream.iterate(1, n -> n < 10, n -> n + 2);
        System.out.println(todosSaoImpares1.allMatch(n -> n % 2 != 0));
        Stream<Integer> todosSaoImpares2 = Stream.iterate(1, n -> n < 10, n -> n + 2);
        System.out.println(todosSaoImpares2.anyMatch(n -> n % 2 != 0));
        Stream<Integer> todosSaoImpares3 = Stream.iterate(1, n -> n < 10, n -> n + 2);
        System.out.println(todosSaoImpares3.noneMatch(n -> n % 2 != 0));
        System.out.println();

        System.out.println("forEach()");
        Stream<Integer> sequencia = Stream.iterate(2, n -> n < 9, n -> n + 2);
        sequencia.forEach(num -> System.out.println(num));
        System.out.println();


        System.out.println("reduce()");
        Stream<Integer> sequencia2 = Stream.iterate(2, n -> n < 9, n -> n + 2);
        System.out.println(sequencia2.reduce(0, (acumulador, num) -> acumulador + num));
        System.out.println();

        System.out.println("filter(...).collect(...)");
        Stream<Integer> sequencia3 = Stream.iterate(1, n -> n < 9, n -> n + 1);
        Set<Integer> numerosPares = sequencia3.filter(num->num%2==0).collect(Collectors.toSet());
        System.out.println(numerosPares);
        System.out.println();

    }
}
