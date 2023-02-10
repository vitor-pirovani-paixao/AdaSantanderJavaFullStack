package Aula5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioIII {
    public static void main(String[] args) {
        var funcionarios = List.of(
                new Funcionario("Vitor", new BigDecimal(7000), "TI"),
                new Funcionario("Maria", new BigDecimal(12000), "Gerencia"),
                new Funcionario("José", new BigDecimal(10000), "Gerencia"),
                new Funcionario("Luiz", new BigDecimal(3000), "RH"),
                new Funcionario("Alberto", new BigDecimal(6000), "TI"),
                new Funcionario("Algusto", new BigDecimal(4320), "TI"),
                new Funcionario("Gertrudes", new BigDecimal(4000), "RH")
        );

        var resultado = funcionarios.stream().collect(Collectors.toMap(funcionario -> funcionario.departamento(),
                funcionario -> funcionario.salario(),
                (a,b)-> a.add(b).divide(BigDecimal.valueOf(2))));
        System.out.println(resultado);


    }
}

record Funcionario(String nome, BigDecimal salario, String departamento) {
}
