package Aula3;

import java.util.ArrayList;
import java.util.List;

public class Ave {
    private String nome;
    private Boolean isVoa;
    private Boolean isNada;

    Ave(String nome, Boolean isVoa, Boolean isNada) {
        this.nome = nome;
        this.isVoa = isVoa;
        this.isNada = isNada;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getVoa() {
        return isVoa;
    }

    public Boolean getNada() {
        return isNada;
    }


}
