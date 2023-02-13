package Aula6;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AulaParteI {
    public static void main(String[] args) throws IOException {
        System.out.println("I/O");
        //Diretório raiz: /...
        //Path (Absoluto): /usr/aluno/docuemntos/planilha.csv
        //Path (relativo): /docuemntos/planilha.csv

        // java.io
        File arquivo1 = new File("C:/Users/vitor/OneDrive/Documents/JavaAda/JavaWebFullStack/4_TecnicasDeProgramacao/Aulas/src/Aula6");
        File arquivo2 = new File("C:/Users/vitor/OneDrive", "Documents/JavaAda/JavaWebFullStack/4_TecnicasDeProgramacao/Aulas/src/Aula6/Test.txt");

        // java.nio
        Path caminho1 = Path.of("C:/Users/vitor/OneDrive/Documents/JavaAda/JavaWebFullStack/4_TecnicasDeProgramacao/Aulas/src/Aula6/Test.txt");
        Path caminho2 = Path.of("C:/Users", "vitor", "OneDrive", "Documents", "JavaAda", "JavaWebFullStack", "4_TecnicasDeProgramacao", "Aulas", "src", "Aula6", "Test.txt");

        Path caminho3 = Paths.get("C:/Users/vitor/OneDrive/Documents/JavaAda/JavaWebFullStack/4_TecnicasDeProgramacao/Aulas/src/Aula6/Test.txt");
        Path caminho4 = Paths.get("C:/Users", "vitor", "OneDrive", "Documents", "JavaAda", "JavaWebFullStack", "4_TecnicasDeProgramacao", "Aulas", "src", "Aula6", "Test.txt");

        // Covertento io to nio e vice-versa
        Path convertidoDeFileParaPath = arquivo1.toPath();
        File convertidoDePathParaFile = caminho1.toFile();

        if (arquivo1.exists()) {
            System.out.println(arquivo1.isAbsolute());
            System.out.println(arquivo1.isDirectory());
        }

        //subpath
        System.out.println("Subpath: " + caminho1.subpath(0,3));
        System.out.println("Nome do arquivo: " + caminho1.getFileName());
        System.out.println("Raiz: " + caminho1.getRoot());

        // Resolve -
        Path concat1 = Path.of("Users/vitor/OneDrive/Documents/JavaAda");
        Path concat2 = Path.of("Users/vitor/OneDrive/Documents/JavaAda/JavaWebFullStack/4_TecnicasDeProgramacao/Aulas/src/Aula6/Test.txt");
        System.out.println(concat1.resolve(concat2));

        // relativize: Dá o caminho necessário para sair de um caminho e chegar no outro
        System.out.println(concat1.relativize(concat2));

        //Normalize: simplifica o caminho
        Path redundante = Path.of("C:/Users/../../../../../../../../../Test.txt");
        System.out.println(redundante.normalize());

        //toRealPath
        System.out.println(Path.of("src\\Aula6\\Test.txt").toRealPath());

        // Criação de diretório
        Path workDir = Path.of("src\\Aula6\\teste_dir");
        if (!workDir.toFile().exists()){
            Files.createDirectory(workDir);
        }
        File arquivo = new File("src\\Aula6\\teste_dir\\texto.txt");
        if (!arquivo.exists()){
            Files.createFile(arquivo.toPath());
        }

        // Copiar arquivos e diretórios
        Path caminhoOriginal = Path.of("src\\Aula6\\teste_dir\\texto.txt");
        Path caminhoCopiado = Path.of("src\\Aula6\\teste_dir\\texto1.txt");
        try {
            Files.copy(caminhoOriginal,caminhoCopiado);
        }catch (FileAlreadyExistsException e){
            System.out.println("Arquivo no diretório já existe: " + e.getMessage());
        }

        // Mover arquivos
        Path caminhoOriginal1 = Path.of("src\\Aula6\\teste_dir\\texto1.txt");
        Path caminhoMovido = Path.of("src\\Aula6\\texto1.txt");
//        Files.move(caminhoOriginal1,caminhoMovido);
        // Move pode ser tilizado para renomear um aquivo
        Path caminhoRenomeado = Path.of("src\\Aula6\\teste_dir\\texto2.txt");
//        Files.move(caminhoOriginal1,caminhoRenomeado);

        //Delete
        if (caminhoOriginal1.toFile().exists()) Files.delete(caminhoOriginal1);


    }
}
