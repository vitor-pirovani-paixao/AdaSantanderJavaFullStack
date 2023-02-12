package dominio;

public record PosicaoTabela(Time time,
                            Integer pontos,
                            Integer vitorias,
                            Integer derrotas,
                            Integer empates,
                            Integer golsPositivos,
                            Integer golsSofridos,
                            Integer saldoDeGols) {

    @Override
    public String toString() {
        return  time +
                ", pontos=" + pontos + // desenvolver forma de obter a pontuação
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                ", golsPositivos=" + golsPositivos +
                ", golsSofridos=" + golsSofridos +
                ", saldoDeGols=" + saldoDeGols +
                '}';
    }
}
