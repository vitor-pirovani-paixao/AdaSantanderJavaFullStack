package Aula6.ExercicioI;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExercicioI {
    public static void main(String[] args) throws IOException {
        Path caminho = Paths.get("src\\Aula6\\ExercicioI\\exercicioI.txt");
        List<String> dados = new ArrayList<>();
        dados.add("João");
        dados.add("170 cm");
        dados.add("35 anos");
        if (!caminho.toFile().exists()){
            Files.createFile(caminho); // Cria o arquivo
            Files.write(caminho, dados, Charset.defaultCharset()); // escreve o arquivo
        }

        List dadosLidos = Files.readAllLines(caminho); // Lê o arquivo
        dadosLidos.forEach(System.out::println);
    }
}
