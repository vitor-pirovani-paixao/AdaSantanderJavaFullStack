package Aula4;

import java.util.List;
import java.util.stream.Stream;

public class Exercicio_III {
    public static void main(String[] args) {
        List<String> numerosEmTexto = Stream.iterate(1, n -> n <= 10, n -> n + 1).map(Object::toString).toList();
        List<Integer> numerosDetexto = numerosEmTexto.stream().map(Integer::parseInt).toList();
        System.out.println(numerosDetexto);
    }
}
