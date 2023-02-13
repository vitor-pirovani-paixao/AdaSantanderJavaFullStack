package Aula6.ExercicioIII;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExercicioIII {
    public static void main(String[] args) throws IOException {
        Path caminho = Paths.get("src\\Aula6\\ExercicioIII\\Frase.txt");
        List dadosLidos = Files.readAllLines(caminho);
        List<String> listaDePalavras = dadosLidos.stream()
                .flatMap(linha -> Arrays.stream(linha.toString().split(" ")))
                .map(palavra -> palavra.toString())
                .toList();
        String palavaraMaisLonga = listaDePalavras.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println( "A palavra mais longa é \"" +
                palavaraMaisLonga +
                "\" com " +
                palavaraMaisLonga.length() +
                " letra(s)"
        );


    }
}
