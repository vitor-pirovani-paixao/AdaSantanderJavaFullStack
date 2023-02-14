package Aula8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AulaParteII {
    public static void main(String[] args) {
        Long inicioDoPograma = System.currentTimeMillis();
        ExecutorService executor = null;
        try {
//            executor = Executors.newFixedThreadPool(5);
            executor = Executors.newCachedThreadPool();// Não limita as threads. Cria o quanto for necessário. Cuidado:
            // Pode causar crash no computador se muitas threads forem criadas.
            executor.execute(new NotaFiscalAula("Vitor"));
            executor.execute(new NotaFiscalAula("João"));
            executor.execute(new NotaFiscalAula("Maria"));
            executor.execute(new NotaFiscalAula("José"));
            executor.execute(new NotaFiscalAula("Luiz"));
            executor.execute(new NotaFiscalAula("Joaquim"));// Como o executor só tem 5 threads disponíveis, ele vai
            // executar 5 envios de e-mail e depois executar os restantes nas primieras threads que forem sendo liberadas
            executor.execute(new NotaFiscalAula("Marta"));
            executor.shutdown();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }finally {
            if(executor != null) {
                executor.shutdown();
            }
        }
        Long finalDoPrograma = System.currentTimeMillis();
        System.out.printf("O programa levou %d ms para executar\n", finalDoPrograma-inicioDoPograma);
    }
}
class NotaFiscalAula implements Runnable{

    private final String cliente;

    public NotaFiscalAula(String cliente) {

        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+ ": Enviando NFe para o cliente " + cliente);
            Thread.sleep(2000);
            System.out.println("NFe enviada para " + cliente);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}