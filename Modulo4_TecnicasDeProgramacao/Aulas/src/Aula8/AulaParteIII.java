package Aula8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AulaParteIII {
    public static void main(String[] args) {
        // Runnable não pode ter retorno, mas o Callable sim
        // Se precisar de retorno da Thread, usa-se um callable
        ExecutorService executor = null;
        try {
            executor = Executors.newCachedThreadPool();
//            Future<BigDecimal> future = executor.submit(new GetTaxaBanco()); // Retorno da operação call é finalizada
//
//            Thread.sleep(2000);
//            System.out.println(future.isDone());; // Se a operação já finalizou (true)
//
//            System.out.println(future.get());// Para obter o resultado se usa o get.
//            // Não precisa do shutdown porque ele espera a finalização da thread
//            //executor.shutdown();

            //Retorno de uma lista de threads
            List<GetTaxaBanco> lista = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                lista.add(new GetTaxaBanco());
            }
            List<Future<BigDecimal>> listaDeFuture = executor.invokeAll(lista);
            listaDeFuture.forEach(future -> {
                try {
                    System.out.println("Taxa: " + future.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e.getMessage());
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            if (executor != null) executor.shutdown();
        }
    }
}

class GetTaxaBanco implements Callable<BigDecimal> {

    @Override
    public BigDecimal call() throws Exception {
        System.out.println("Thread: " + Thread.currentThread().getName());
//        Thread.sleep(1000);
        return BigDecimal.valueOf(Math.random());
    }
}
