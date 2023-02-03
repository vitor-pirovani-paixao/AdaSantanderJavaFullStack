package Aula4;

import javax.naming.OperationNotSupportedException;
import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Stream;

public class AulaParteII {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Vitor", 30);
        Pessoa pessoa2 = new Pessoa("Deyse", 31);
        Pessoa pessoa3 = new Pessoa("João", 15);
        Pessoa pessoa4 = new Pessoa("Maria", 17);
        Pessoa pessoa5 = new Pessoa("José", 56);

        System.out.println("---Métodos intermediários do Stream---");
        System.out.println();

        List<Pessoa> pessoas = List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5);
        System.out.println("Exibindo pessoas maiores de 18 com o filter()");
        pessoas.stream().filter(pessoa -> pessoa.idade() >= 18).toList().forEach(pessoa -> System.out.println(pessoa.nome()));
        System.out.println();

        System.out.println("distinct(): retorna uma stream, eliminado os elmentos repetidos");
        List<Integer> listaNumeros = List.of(1, 2, 2, 2, 2, 2, 5, 6, 8, 8);
        System.out.println(listaNumeros.stream().distinct().toList());
        System.out.println();

        System.out.println("limit():limita a quantidade de elemntos a serem tratados pelo stream");
        System.out.println("skip(): faz o strem começar a tratar os numeros a partir da quantidade do skip");
        List<Integer> impares = Stream.iterate(1, n -> n < 13, n -> n + 2).toList();
        System.out.println(impares);
        System.out.println(impares.stream().limit(2).toList() +" limit(2)");
        System.out.println(impares.stream().skip(3).toList()+" skip(3)");
        System.out.println();

        System.out.println("map(): transforma um objeto em outro");
        List<String> nomes = List.of("viTor","JoÃO","MARia","Maria","Vitor");
        System.out.println(nomes.stream().map(String::toLowerCase).distinct().toList());

    }
}
