package Aula7.AulaParteI;

public class AulaParteI {
    public static void main(String[] args) {
        System.out.println("Programação multi thread (paralela)");
        System.out.println("THREAD -> uma unidade de execução");
        System.out.println("PROCESSO -> um grupo de threads que se relacionam");

        //CONCORRÊNCIA

//        //Criando uma thread no Java
//        var nomeDaThreadAtual = Thread.currentThread().getName();
//        System.out.println("Thread atual: " + nomeDaThreadAtual);
//        MinhaThread minhaThread = new MinhaThread("Minha Thread", 2000L);
//        minhaThread.start(); // Responsável por iniciar uma nova Thread. Se não for chamado, as tarefas ficaram todas alocadas na Thread antiga
////        minhaThread.run();

//        //Usando a classe Thread para criar uma nova Thread. Essa classe precisa do método runable para funcionar
//        Runnable meuRanable = new MeuRanable();
//        Thread minhaThread = new Thread(meuRanable);// runnable é uma lambda
//        minhaThread.start();
//        //Outra maneira seria..
//        new Thread(()->{
//            try {
//                String nomeDaThreadAtual = Thread.currentThread().getName();
//                System.out.printf("Fazendo a thread %s dormir\n", nomeDaThreadAtual);
//                Thread.sleep(2000);
//                System.out.printf("Saindo da thread %s\n", nomeDaThreadAtual);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }).start();

//        //Criando Multiplas Threads
//        Runnable meuRunable = new MeuRanable();
//        Thread thread1 = new Thread(meuRunable);// Diferentes threads podem chamar o mesmo runable
//        Thread thread2 = new Thread(meuRunable);
//        Thread thread3 = new Thread(meuRunable);
//        Thread thread4 = new Thread(meuRunable);
//        thread1.start(); // Não pode dar start na mes thread mais de uma vez
//        thread2.start();
//        thread3.start();
//        thread4.start();

        //Problema de concorrencia entre threads
        // o contador "i" pode sair desajustado, pois durante o tempo de impressão na tela
        // outra thread já entrou e o modificou, pois é um atributo estático
        // Isso é feito para exemplificar o caso em que diferentes threads alteram o mesmo valor
        // o que pode causar problemas
        ContadorThread thread1 = new ContadorThread();
        ContadorThread thread2 = new ContadorThread();
        ContadorThread thread3 = new ContadorThread();
        ContadorThread thread4 = new ContadorThread();
        ContadorThread thread5 = new ContadorThread();
        ContadorThread thread6 = new ContadorThread();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        // Caso eu queira que a thread5 termine primeiro para deois executar outra thread, basta usar o join
        // Lembrando que a thread que espera é a que está chamando, neste exemplo, a thread main vai espera a thread5 finalizar
        try {
            thread5.join();
            thread6.yield(); // passa a vez de execução para a próxima thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Criando uma pausa antes de imprimir
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ContadorThread.lista.size());// Deveria ser sempre 6 pq são 6 threads, porém, ArrayList
        // não é thread-safe. Deve-se usar o Collections.synchronizedList para isso.
        //  System.out.println(++ContadorThread.i);

    }
}
