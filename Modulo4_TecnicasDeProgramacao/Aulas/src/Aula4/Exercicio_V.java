package Aula4;

import java.util.List;
import java.util.stream.Collectors;

public class Exercicio_V {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Rose", 47);
        Pessoa pessoa2 = new Pessoa("Joaquim", 7);
        Pessoa pessoa3 = new Pessoa("João", 25);
        Pessoa pessoa4 = new Pessoa("Maria", 29);
        Pessoa pessoa5 = new Pessoa("José", 56);
        List<Pessoa> pessoas = List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5);

        System.out.println(pessoas
                .stream()
                .filter(pessoa -> pessoa.idade()>=18)
                .map(pessoa -> pessoa.nome())
                .limit(3)
                .collect(Collectors.toSet()));
    }
}
