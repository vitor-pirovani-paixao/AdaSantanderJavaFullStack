package Aula6.ExercicioII;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExercicioII {
    public static void main(String[] args) throws IOException {
        Path caminhoAntigo = Paths.get("src\\Aula6\\ExercicioI\\exercicioI.txt");
        Path caminhoNovo = Paths.get("src\\Aula6\\ExercicioII\\exercicioI.txt");
        if (caminhoAntigo.toFile().exists() && !caminhoNovo.toFile().exists()) {
            Files.move(caminhoAntigo, caminhoNovo);
            System.out.println("Sucesso");
            System.out.println(caminhoAntigo.toAbsolutePath());
            System.out.println(caminhoNovo.toAbsolutePath());
        } else {
            System.out.println("Falha");
            System.out.println("Arquivo existe no diretório de origem? " + caminhoAntigo.toFile().exists());
            System.out.println("Arquivo existe no diretório de destino? " + caminhoNovo.toFile().exists());
        }


    }
}
