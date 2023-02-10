package Aula5;

import java.util.stream.IntStream;

public class ExercicioI {
    public static void main(String[] args) {
        System.out.println("A soma de 0 a 10 é igual a: " + IntStream.rangeClosed(0, 10).sum());
    }
}
