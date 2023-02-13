package Aula7.AulaParteI;

public class MeuRanable implements Runnable{
    @Override
    public void run() {
        try {
            String nomeDaThreadAtual = Thread.currentThread().getName();
            System.out.printf("Fazendo a thread %s dormir\n", nomeDaThreadAtual);
            Thread.sleep(2000);
            System.out.printf("Saindo da thread %s\n", nomeDaThreadAtual);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
