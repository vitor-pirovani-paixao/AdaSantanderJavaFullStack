package Aula3;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class AulaParteI {
    private static Ave gaivota;

    public static void main(String[] args) {

        System.out.println("Programação Funcional");

        Ave aguia = new Ave("Águia", true, false);
        Ave pinguim = new Ave("Pinguim", false, true);
        Ave gaivota = new Ave("Gaivota", true, true);

        ArrayList<Ave> aves = new ArrayList<>();
        aves.add(aguia);
        aves.add(pinguim);
        aves.add(gaivota);
        // Com interface
        //Filtro filtroVoa = new FiltrarAvesQueVoam();
        //Filtro filtroNada = new FiltrarAvesQueNadam();

        //Com Classe anônima
//        Filtro filtroVoa = new Filtro() {
//            @Override
//            public boolean filtrar(Ave ave) {
//                return ave.getVoa();
//            }
//        };
//
//        Filtro filtroNada = new Filtro() {
//            @Override
//            public boolean filtrar(Ave ave) {
//                return ave.getNada();
//            }
//        };        //Com Classe anônima
//        Filtro filtroVoa = new Filtro() {
//            @Override
//            public boolean filtrar(Ave ave) {
//                return ave.getVoa();
//            }
//        };
//
//        Filtro filtroNada = new Filtro() {
//            @Override
//            public boolean filtrar(Ave ave) {
//                return ave.getNada();
//            }
//        };
//
//        ArrayList<Ave> avesFiltradas = filtrarAve(aves, filtroVoa);

            // Com lambda
        // Só funciona quando a interface tem apenas um método abstrato, pois é esse método
        // que é subentendido ser o método lambda.
//        ArrayList<Ave> avesFiltradas = filtrarAve(aves, (ave) -> ave.getVoa());
        ArrayList<Ave> avesFiltradas = filtrarAve(aves, Ave::getVoa);

        // Predicate tem um método de filtragem que se chama test e retorna um boolean.

        for (Ave ave : avesFiltradas) {
            System.out.println(ave.getNome());
        }
        System.out.println();

        System.out.println("FUNCTION: Recebe um objeto, aplica um método lambda passado e retorna outro objeto");
        System.out.println("Funciona como o map()");
        ArrayList<String> nomeAves = tranformaObjAve(aves,(ave -> ave.getNome()));
        System.out.println(nomeAves);
        System.out.println();

        System.out.println("CONSUMER: Recebe um objeto e não retorna nada");
        System.out.println("Funciona como o forEach()");
        imprimirNomesAves(aves,(ave -> System.out.println(ave.getNome())));
    }

    public static void imprimirNomesAves(ArrayList<Ave> aves, Consumer<Ave> consumidor){
        for (Ave ave: aves) {
            consumidor.accept(ave);
        }
    }

    public static ArrayList<String> tranformaObjAve(ArrayList<Ave> aves, Function<Ave,String> transformador){
        ArrayList<String> nomesAves = new ArrayList<>();

        for (Ave ave: aves) {
            nomesAves.add(transformador.apply(ave));
        }
        return nomesAves;
    }

    public static ArrayList<Ave> filtrarAve(ArrayList<Ave> aves, Filtro filtro) {
        ArrayList<Ave> avesFiltradas = new ArrayList<>();
        for (Ave ave : aves) {
            if (filtro.filtrar(ave)) {
                avesFiltradas.add(ave);
            }
        }
        return avesFiltradas;
    }
}
