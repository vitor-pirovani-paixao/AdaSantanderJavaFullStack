package Aula3;

import java.util.function.Function;

public class Exercicio_II {
    public static void main(String[] args) {
        Double numero = 5.;
        Function<Double, Double> aplicadorDeRegra = num -> 2 * num;
        System.out.println(aplicadorDeRegra.apply(numero));
//        System.out.println(dobrar(numero, num -> 2 * num));

    }

//    public static Double dobrar(Double numero, Function<Double, Double> aplicadorDeRegra) {
//        return aplicadorDeRegra.apply(numero);
//    }
}
