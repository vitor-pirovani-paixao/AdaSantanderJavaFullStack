package Aula4;

import java.util.List;

public class Exercicio_IV {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(2, 6, -1, 65, 3, 4);
        System.out.println(numeros.stream().sorted().toList());
    }
}
