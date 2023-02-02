package Aula3;

import java.util.Objects;
import java.util.function.Predicate;

public class Exercicio_I {
    public static void main(String[] args) {
        Integer numero = 2;
        System.out.println(testaParOuImpar(numero, num -> num % 2 == 0));

    }

    public static String testaParOuImpar(Integer numero, Predicate<Integer> aplicadorDeregra) {
        return aplicadorDeregra.test(numero) ? "Par" : "Ímpar";
    }
}
