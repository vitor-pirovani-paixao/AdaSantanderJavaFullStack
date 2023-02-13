package Aula7.AulaParteI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContadorThread extends Thread{
    public static List<String> lista = Collections.synchronizedList(new ArrayList<>());// thread-safe
//    public static List<String> lista = new ArrayList<>(); // não thread-safe
//    public static AtomicInteger i = new AtomicInteger(-1); // thread-safe
//    public static int i = -1;// não thread-safe

    @Override
    public void run(){

//        synchronized(this){//synchronized não deixa outra thread entrar aqui antes que a atual finalize esse bloco de código
//            Integer contador = i.incrementAndGet();
        lista.add("qqc");
            String nomeDaThread = Thread.currentThread().getName();
            System.out.printf("%s adicionou na lista\n", nomeDaThread);
//        };

    }
}
