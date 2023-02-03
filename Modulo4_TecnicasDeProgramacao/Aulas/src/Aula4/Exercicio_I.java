package Aula4;

import java.util.List;
import java.util.stream.Stream;

public class Exercicio_I {
    public static void main(String[] args) {
        List<Integer> numerosInteiros = Stream.iterate(1, n -> n <= 10, n -> n + 1).toList();
        numerosInteiros.stream().filter(num->num%2==0).forEach(System.out::println);
    }
}
