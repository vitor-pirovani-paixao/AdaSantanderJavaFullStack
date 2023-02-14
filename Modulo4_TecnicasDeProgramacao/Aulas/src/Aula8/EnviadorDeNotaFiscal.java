package Aula8;

import java.util.Queue;


public class EnviadorDeNotaFiscal implements Runnable {
    private Queue<NotaFiscal> filaDeNotas;

    public EnviadorDeNotaFiscal(Queue<NotaFiscal> filaDeNotas) {
        this.filaDeNotas = filaDeNotas;
    }

    @Override
    public void run() {
        try {
            System.out.println("Enviando NF: " + this.filaDeNotas.remove());
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }

}
