package Aula7.AulaParteII;

import java.time.Instant;
import java.time.LocalTime;
import java.time.Period;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AulaParteII {
    public static void main(String[] args) {
        System.out.println("stream serial x stream parallel");
        System.out.println();

//        IntStream.rangeClosed(0, 10).parallel().forEach(System.out::println);// Paraleliza os cáculos da stream
        // É útil em métodos como o findAny(), por exemplo

        List<Integer> numeros = Stream.iterate(0, n -> n <= 100_000_000, n -> n + 1).toList();

        Long primiero = Instant.now().toEpochMilli();
        Integer somaSerial = numeros.stream().reduce(0,Integer::sum);
        Long segundo = Instant.now().toEpochMilli();
        System.out.println("Sequencial (ms): " + (segundo-primiero));
        Integer somaParalela = numeros.parallelStream().reduce(0,Integer::sum);
        Long terceiro = Instant.now().toEpochMilli();
        System.out.println("Em parelo (ms): " + (terceiro-segundo));
    }
}
