package Aula5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AulaParteI {
    public static void main(String[] args) {
        System.out.println("Collectors");

        //Coletor básico
        List<Integer> streamColetada = Stream.of(1, 2, 3).toList();
        System.out.println(streamColetada);
        Set<Integer> streamColetadaSet = Stream.of(1, 2, 3)
                .collect(Collectors.toSet());
        System.out.println(streamColetada);

        //Coletor para outra implentação - Para TreeSet
        TreeSet<Integer> streamColetadaTreeSet = Stream.of(1, 2, 3)
                .collect(Collectors.toCollection(TreeSet::new));
//                .collect(Collectors.toCollection(()->new TreeSet<>()));

        // Coletor como reduce
        StringBuilder reduzindo = Stream.of("c", "a", "s", "a")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(reduzindo);

        // Coletor como joining
        System.out.println(String.join(", ", List.of("Feijão", "Arroz", "Batata")));
        System.out.println(Stream.of("Feijão", "Arroz", "Batata").collect(Collectors.joining(", ")));

        //averagingInt
        System.out.println("Aqui");
        System.out.println(Stream.of("Feijão", "Arroz", "Batata")
                .collect(Collectors.averagingInt(String::length)));

        //toMap
        System.out.println(Stream.of("Feijão", "Arroz", "Batata")
                .collect(Collectors.toMap(palavra -> palavra, String::length)));

        //toMap2 com merge
        System.out.println(Stream.of("Feijão", "Arroz", "Batata", "carne")
                .collect(Collectors.toMap(String::length, //chave
                        palavra -> palavra,// valor
                        (palavra1, palavra2) -> String.join(", ", List.of(palavra1, palavra2)) // Faz o merge se a chave for igual, neste caso, o tamanho da string
                )));

        //toMap3 com merge e mudando para uma nova implementação
        Map<Integer,String> map3 = Stream.of("Feijão", "Arroz", "Batata", "carne")
                .collect(Collectors.toMap(
                        String::length, //chave
                        palavra -> palavra,// valor
                        (palavra1, palavra2) -> String.join(", ", List.of(palavra1, palavra2)), // Faz o merge se a chave for igual, neste caso, o tamanho da string
                        TreeMap::new //Novo Tipo
                ));
        System.out.println(map3.getClass());

        //Agrupando, mudando a implentação do return para TreeMap e a implentação do valor ineterno para List<String>
        Map<Integer,List<String>> map4 = Stream.of("Feijão", "Arroz", "Batata", "carne")
                .collect(Collectors.groupingBy(
                        String::length, //chave
                        TreeMap:: new,// Mudando o tipo do return
                        Collectors.toCollection(ArrayList::new)// Mudando o valor interno dos agrupamentos
                ));
        System.out.println(map4);

        //Partitionig. Retorna um Map com chave True or False dependendo do retorno do Predicate
        Map<Boolean,List<String>> map5 = Stream.of("Feijão", "Arroz", "Batata", "carne")
                .collect(Collectors.partitioningBy(palavra->palavra.length()>5));
        System.out.println(map5);

        //Exercício: Dado uma lista de alunos, particionar entre aprovados e reprovados
        List<Aluno> alunos = List.of(new Aluno("Vitor",10.),
                new Aluno("João",1.),
                new Aluno("Maria",7.),
                new Aluno("José",6.9),
                new Aluno("Luiz",9.));
        System.out.println(alunos.stream().collect(Collectors.partitioningBy(aluno -> aluno.nota()>=7)));


    }

}

