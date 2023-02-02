package Aula3;

public class FiltrarAvesQueVoam implements Filtro {

    @Override
    public boolean filtrar(Ave ave){
        return ave.getVoa();
    }
}
