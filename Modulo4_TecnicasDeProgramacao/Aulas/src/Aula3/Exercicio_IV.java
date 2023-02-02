package Aula3;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Exercicio_IV {
    public static void main(String[] args) {
        Supplier<LocalDateTime> fornecedor = LocalDateTime::now;
        System.out.println(fornecedor.get());
    }
}
