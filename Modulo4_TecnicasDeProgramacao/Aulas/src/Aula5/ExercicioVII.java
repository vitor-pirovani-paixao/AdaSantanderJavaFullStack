package Aula5;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExercicioVII {
    public static void main(String[] args) {
        String texto = "Um texto é uma manifestação da linguagem. Pode ser definido como tudo " +
                "aquilo que é dito por um emissor e interpretado por um receptor. Dessa forma, " +
                "tudo que é interpretável é um texto. Outra forma de conceituação é pensar que " +
                "tudo aquilo que produz um sentido completo, que seja uma mensagem compreensível, é um texto.\n" +
                "Enquanto uma manifestação linguística, o texto é produzido em um dado espaço e momento. " +
                "Cenário e tempo compõem o que se chama de contexto. Além disso, são considerados informações " +
                "contextuais: quem fala o texto; quem o escuta; quais são as ideologias, ética e moral do " +
                "instante da produção e execução textuais, entre outros elementos. Para interpretar um texto, " +
                "é fundamental levar em consideração tais informações vinculadas ao contexto.";

        Map<String,Long> listaDePalavras= Arrays.stream(texto.split(" ", 0))
                .map(palavra->palavra.trim())
                .map(palavra->palavra.replace(",",""))
                .map(palavra->palavra.replace(".",""))
                .map(palavra->palavra.replace(";",""))
                .collect(Collectors.groupingBy(palavra->palavra,
                        Collectors.counting()));
        listaDePalavras.forEach((k,v)-> System.out.println(k+":"+v));

    }
}
