package Aula7.AulaParteI;

public class MinhaThread extends Thread{
    private final String nome;
    private final Long sleep;
    MinhaThread(String nome, Long sleep){
        this.nome = nome;
        this.sleep = sleep;
    }
    @Override
    public void run(){

        try {
            String nomeDaThreadAtual = Thread.currentThread().getName();
            System.out.printf("Fazendo a thread %s dormir\n", nomeDaThreadAtual);
            Thread.sleep(this.sleep);
            System.out.printf("Saindo da thread %s\n", nomeDaThreadAtual);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
