package Aula3;

public class FiltrarAvesQueNadam implements Filtro {

    @Override
    public boolean filtrar(Ave ave){
        return ave.getNada();
    }
}
