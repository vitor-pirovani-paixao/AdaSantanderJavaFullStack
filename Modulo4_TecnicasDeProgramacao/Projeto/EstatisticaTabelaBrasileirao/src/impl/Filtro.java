package impl;

import dominio.Jogo;

@FunctionalInterface
public interface Filtro {
    Boolean filtrar(Jogo jogo);
}
