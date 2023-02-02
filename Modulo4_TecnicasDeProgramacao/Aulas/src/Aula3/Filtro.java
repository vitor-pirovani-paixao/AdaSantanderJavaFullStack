package Aula3;

@FunctionalInterface // Interface que tem apenas um método abstrato. Usado para implementação lambda
public interface Filtro {

    boolean filtrar (Ave ave);
}
