package Aula5;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExercicioVI {
    public static void main(String[] args) {
        System.out.println(
                Stream.iterate(1, n -> n <= 20, n -> n + 1).sorted((n1, n2) -> n2 - n1).toList().get(1)
        );
    }
}
