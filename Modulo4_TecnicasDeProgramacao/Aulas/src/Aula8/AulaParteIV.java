package Aula8;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AulaParteIV {
    public static void main(String[] args) {
        // Até agora foram utilizados...
        // ExecutorService
        // Executors
        // newSingleThreadPool()
        // newFixedThreadPool(nThreads)
        // newCashedThreadPool()
        //execute(Runnable)
        //submit(Callable<T>)
        //shutDown()
        //shutDownNow()
        //awaitTermination(int, TimeUnit)

        //Para agendamentos: scheduler.schedule(Callable, delay, TimeUnit)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
        scheduler.schedule(new Tarefa(),5, TimeUnit.SECONDS);
        scheduler.shutdown();


        // Agendar tarefas recorrentes
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);
//        scheduler.scheduleAtFixedRate(new TarefaRunnable(),2,3,TimeUnit.SECONDS); // 3 s de tarefa em tarefa
//        scheduler.scheduleWithFixedDelay(new TarefaRunnable(),2,3,TimeUnit.SECONDS); // 3 s após o término da tafefa corrente. Só vai usar uma thread

    }
}

class Tarefa implements Callable<List<String>>{

    @Override
    public List<String> call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return List.of("Executando");
    }
}

class TarefaRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}