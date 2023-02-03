package Aula4;

import java.util.List;
import java.util.stream.Stream;

public class Exercicio_II {
    public static void main(String[] args) {
        List<Integer> numerosInteiros = Stream.iterate(1, n -> n <= 10, n -> n + 1).toList();
        System.out.println(numerosInteiros);
        System.out.println("A soma é igua a " + numerosInteiros.stream().reduce(0, (acumulador, num) -> acumulador + num));
    }
}
