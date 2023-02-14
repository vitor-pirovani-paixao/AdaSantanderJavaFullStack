package Aula8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AulaParteI {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = null;
        try {
            Thread thread = new Thread(()-> System.out.println("olá"));
            thread.setDaemon(true);// Finaliza a thread assim que o programa acabar, mesmo que ela ainda esteja em execução

            System.out.println("Executor. Ajuda a criar threads ou multiplas threads");
           executor = Executors.newSingleThreadExecutor();
            // Com o executor se consegue dar start na mesma thread
            executor.execute(new Tarefa());

//        executor.execute(new Tarefa());
//        executor.execute(new Tarefa());
//        executor.execute(new Tarefa());
//        executor.execute(new Tarefa());
            // Obrigatório para finalizar a thread quando usando a classe Executors
            // Deve sempre estar dentro de um finally, pois qualquer outro erro dentro do código
            // nãio atrapalha a finalização da thread. Caso contrário ela executa indefinidamente
            executor.awaitTermination(2, TimeUnit.SECONDS); // Tempo que leva para encerrar depois que o shutdown é chamado
            executor.shutdown(); // Avisa para finalizar as Threads
//        executor.shutdownNow(); // Encerra sem aviso. Throws java.lang.InterruptedException
        }catch (Exception e){
            throw e;
        }finally {
            if(executor !=null){
                executor.shutdownNow();
            }
        }

    }

    public static class Tarefa implements Runnable{
        @Override
        public void run(){
            try {
                System.out.println("Esperando...");
                Thread.sleep(5000);
                System.out.println("Foi!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lancarExcecao();// Fornçando um erro na tarefa
            System.out.println(Thread.currentThread().getName() + ": Imprimindo Runnable");
        }
    }

    public static void lancarExcecao(){
        throw new RuntimeException("Minha exceção");
    }
}
