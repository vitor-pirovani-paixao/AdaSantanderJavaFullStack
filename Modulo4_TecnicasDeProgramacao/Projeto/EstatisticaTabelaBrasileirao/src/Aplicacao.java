import dominio.PosicaoTabela;
import dominio.Resultado;

import impl.CampeonatoBrasileiroImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;


public class Aplicacao {

    public static void main(String[] args) throws IOException {

        // obter caminho do arquivo
        Path file = Path.of("campeonato-brasileiro.csv");

        // obter a implementação: (ponto extra - abstrair para interface)
        System.out.println("---------Estatíticas de 2003 até 2021-------");
        // Para tabela da temporada, digite apenas o ano da temporara, ou, no caso da temporada 2020/2021, digite os dois anos
        CampeonatoBrasileiroImpl resultados =new CampeonatoBrasileiroImpl(file, 2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021);

        // imprimir estatisticas
        imprimirEstatisticas(resultados);

        // imprimir tabela ordenada
        imprimirTabela(resultados.getTabela());

    }

    private static void imprimirEstatisticas(CampeonatoBrasileiroImpl brasileirao) {
        IntSummaryStatistics statistics = brasileirao.getEstatisticasPorJogo();

        System.out.println("Estatisticas (Total de gols) - " + statistics.getSum());
        System.out.println("Estatisticas (Total de jogos) - " + statistics.getCount());
        System.out.println("Estatisticas (Media de gols) - " + statistics.getAverage());

        Map<Resultado, Long> placarMaisRepetido = brasileirao.getPlacarMaisRepetido();

        System.out.println("Estatisticas (Placar(es) mais repetido(s)) - "
                + placarMaisRepetido.keySet().stream().toList() +
                " (" + placarMaisRepetido.values().stream().toList().get(0) + " jogo(s) cada)");

        Map<Resultado, Long> placarMenosRepetido = brasileirao.getPlacarMenosRepetido();

        System.out.println("Estatisticas (Placar(es) menos repetido(s)) - "
                + placarMenosRepetido.keySet().stream().toList() +
                " (" + placarMenosRepetido.values().stream().toList().get(0) + " jogo(s) cada)");

        Long jogosCom3OuMaisGols = brasileirao.getTotalJogosCom3OuMaisGols();
        Long jogosComMenosDe3Gols = brasileirao.getTotalJogosComMenosDe3Gols();

        System.out.println("Estatisticas (3 ou mais gols) - " + jogosCom3OuMaisGols);
        System.out.println("Estatisticas (-3 gols) - " + jogosComMenosDe3Gols);

        Integer totalVitoriasEmCasa = brasileirao.getTotalVitoriasEmCasa();
        Long vitoriasForaDeCasa = brasileirao.getTotalVitoriasForaDeCasa();
        Long empates = brasileirao.getTotalEmpates();

        System.out.println("Estatisticas (Vitorias Fora de casa) - " + vitoriasForaDeCasa);
        System.out.println("Estatisticas (Vitorias Em casa) - " + totalVitoriasEmCasa);
        System.out.println("Estatisticas (Empates) - " + empates);

        System.out.println("Rodada   \tGols  \tMédia");
        brasileirao.getTotalGolsPorRodada().forEach((k,v)-> System.out.println("\t"+ k + "\t-\t"
                + v + "\t\t " + brasileirao.getMediaDeGolsPorRodada().get(k)));
    }


    public static void imprimirTabela(List<PosicaoTabela> posicoes) {
        System.out.println();
        System.out.println("## TABELA CAMPEONADO BRASILEIRO: ##");
        int colocacao = 1;
        for (PosicaoTabela posicao : posicoes) {
            System.out.println(colocacao +". " + posicao);
            colocacao++;
        }

        System.out.println();
        System.out.println();
    }
}