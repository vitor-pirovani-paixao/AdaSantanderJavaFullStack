package Aula5;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioV {
    public static void main(String[] args) {
        var pessoas = List.of(
                new Livro("Vitor", 30),
                new Livro("João", 25),
                new Livro("Maria", 15),
                new Livro("José", 70),
                new Livro("Luiz", 27),
                new Livro("Alberto", 49),
                new Livro("Gertrudes", 96)
        );
        System.out.println("O(A) autor(a) mais popular baseado no núemro de cópias vendidas é " +
                pessoas.stream()
                        .max(Comparator.comparingInt(Livro::copiasVendidas)).get().autor()
        );

    }
}
record Livro (String autor, Integer copiasVendidas){}
