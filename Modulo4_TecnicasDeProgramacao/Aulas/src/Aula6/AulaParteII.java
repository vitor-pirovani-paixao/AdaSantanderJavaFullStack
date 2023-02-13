package Aula6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AulaParteII {
    public static void main(String[] args) throws IOException {
        System.out.println("Manipulação de Arquivos");

        InputStream inputStream = new FileInputStream("src\\Aula6\\Test.txt");
        int i;
        while ((i = inputStream.read()) != -1) {
            System.out.print((char)i);//Le em bytes e faz parse para caracteres
        }
        System.out.println();

        Reader reader = new FileReader(new File("src\\Aula6\\Test.txt"));
        int j;
        while ((j = reader.read()) != -1) {
            System.out.print((char)j);//Le em bytes e faz parse para caracteres
        }

        reader = new FileReader(new File("src\\Aula6\\Test.txt"));
        Writer writer = new FileWriter(new File("src\\Aula6\\TestWriter.txt"));
        while ((j = reader.read()) != -1) {
            writer.write(j);
        }
        writer.flush();
        System.out.println();

        // Com a nova implentação java.nio
        String texto = "Teste java.nio";
        if (!Path.of("src\\Aula6\\TestJavaNIO.txt").toFile().exists()) Files.writeString(Path.of("src\\Aula6\\TestJavaNIO.txt"), texto);

        List output = Files.readAllLines(Path.of("src\\Aula6\\TestJavaNIO.txt"));
        output.forEach(System.out::println);

        System.out.println();

        System.out.println("Escrevendo e lendo um objeto de um aruivo.txt");
        File caminhoArquivo = new File("src\\Aula6\\contato.txt");
        Contato contato = new Contato("Fulano de Tal","123456789","Rua dos Bobos");
        //Para escrever o novo arquivo...
//        ObjectOutput output1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(caminhoArquivo)));
//        output1.writeObject(contato);// Escreve o objeto em bytes
//        output1.close();
        //Para ler o objeto...
        ObjectInput input1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(caminhoArquivo)));
        try {
            Object contatoLido = input1.readObject();// Escreve o objeto em bytes
            input1.close();
            System.out.println(contatoLido instanceof Contato);
            System.out.println(Contato.class.cast(contatoLido));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
