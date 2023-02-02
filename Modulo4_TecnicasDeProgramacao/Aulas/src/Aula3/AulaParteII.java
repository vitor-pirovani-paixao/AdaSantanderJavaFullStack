package Aula3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AulaParteII {
    public static void main(String[] args) {
        Ave aguia = new Ave("Aguia", true, false);
        Ave pinguim = new Ave("Pinguim", false, true);
        Ave gaivota = new Ave("Gaivota", true, true);
        Ave pardal = new Ave("Pardal", true, false);
        Ave coruja = new Ave("Coruja", true, false);

        ArrayList<Ave> aves = new ArrayList<>(List.of(aguia,pinguim,gaivota,pardal,coruja));

        Collections.sort(aves,(obj1,obj2)->obj1.getNome().compareToIgnoreCase(obj2.getNome()));
        aves.forEach(ave -> System.out.println(ave.getNome()));

    }
}
