package Aula1;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Exercicio_III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o dia do seu nascimento?");
        String dia = sc.nextLine().trim();
        System.out.println("Qual o mês do seu nascimento?");
        String mes = sc.nextLine().trim();
        System.out.println("Qual o ano do seu nascimento?");
        String ano = sc.nextLine().trim();

        LocalDate dataNasciemnto = LocalDate.parse(ano+"-"+mes+"-"+dia);
        LocalDate hoje = LocalDate.now();
        System.out.printf("Você tem %s ano(s) de idade", Period.between(dataNasciemnto,hoje).getYears());
        sc.close();
    }
}
