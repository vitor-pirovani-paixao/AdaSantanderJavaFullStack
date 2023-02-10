package Aula5;

import java.util.List;
import java.util.stream.Collectors;

public class ExercicioII {
    public static void main(String[] args) {
        var pessoas = List.of(
                new Pessoa("Vitor", 30),
                new Pessoa("João", 25),
                new Pessoa("Maria", 15),
                new Pessoa("José", 70),
                new Pessoa("Luiz", 27),
                new Pessoa("Alberto", 49),
                new Pessoa("Gertrudes", 96)
        );

        System.out.println("Pessoas maiores de 40 anos (true) e menores ou iguais 40 anos (false)");
        System.out.println(
                pessoas.stream()
                        .collect(Collectors.partitioningBy(pessoa -> pessoa.idade()>40))
        );
    }
}
