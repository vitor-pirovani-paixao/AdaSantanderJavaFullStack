package Aula3;

import java.util.List;
import java.util.function.Consumer;

public class Exercicio_III {
    public static void main(String[] args) {
        List<Integer> lista = List.of(2, 3, 5, 6, 7);
        Consumer<Integer> consumidor = System.out::println;
        lista.forEach(consumidor);
//        imprimeLista(lista, System.out::println);

    }

//    public static void imprimeLista(List<Integer> lista, Consumer<Integer> consumidor){
//        for (Integer elemento: lista) {
//            consumidor.accept(elemento);
//        }
//    }

}
