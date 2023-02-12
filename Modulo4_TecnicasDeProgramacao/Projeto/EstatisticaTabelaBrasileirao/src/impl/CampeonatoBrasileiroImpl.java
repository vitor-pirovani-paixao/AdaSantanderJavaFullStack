package impl;

import dominio.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CampeonatoBrasileiroImpl implements Filtro{

    private Map<Integer, List<Jogo>> brasileirao;
    private List<Jogo> jogos;
    private Integer[] anoDoCampeonato;

    public CampeonatoBrasileiroImpl(Path arquivo,Integer ...ano) throws IOException {
        this.jogos = lerArquivo(arquivo);
        this.anoDoCampeonato = ano;
        this.brasileirao = jogos.stream()
                .filter(jogo->filtrar(jogo)) //filtrar por ano
                .collect(Collectors.groupingBy(
                        Jogo::rodada,
                        Collectors.mapping(Function.identity(), Collectors.toList())));

    }
    @Override
    public Boolean filtrar(Jogo jogo){
        return !Arrays.stream(anoDoCampeonato).filter(ano->ano==jogo.data().data().getYear()).toList().isEmpty();
    }

    public List<Jogo> lerArquivo(Path file) throws IOException {
        List<String> lines = Files.readAllLines(file);
        return this.todosOsJogos(lines);

    }

    public List<Jogo> todosOsJogos(List<String> lines) {
        List<Jogo> jogosDesde2003 = new ArrayList<>();
        for (String line : lines) {
            if (!line.split(";")[0].trim().equalsIgnoreCase("Rodada")) {
                String[] valuesInLine = line.split(";");

                jogosDesde2003.add(
                        new Jogo(Integer.parseInt(valuesInLine[0]),
                                new DataDoJogo(LocalDate.parse(valuesInLine[1], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                                        LocalTime.parse(valuesInLine[2].isEmpty() ?
                                                        "00:00" :
                                                        valuesInLine[2].replace("h", ":"),
                                                DateTimeFormatter.ofPattern("HH:mm")),
                                        this.getDayOfWeek(valuesInLine[3])),
                                new Time(valuesInLine[4]),
                                new Time(valuesInLine[5]),
                                new Time(valuesInLine[6]),
                                valuesInLine[7],
                                Integer.parseInt(valuesInLine[8]),
                                Integer.parseInt(valuesInLine[9]),
                                valuesInLine[10],
                                valuesInLine[11],
                                valuesInLine[12]
                        )
                );
            }
        }
        return jogosDesde2003;
    }

    public IntSummaryStatistics getEstatisticasPorJogo() {
        return this.brasileirao
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.summarizingInt(jogo -> jogo.mandantePlacar() + jogo.visitantePlacar()));
    }

    private Stream<Jogo> retonraStreamDeFlatMapDoMapBarsileirao() {
        return this.brasileirao
                .values()
                .stream()
                .flatMap(Collection::stream);
    }

    public Integer getTotalVitoriasEmCasa() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .filter(jogo -> jogo.mandantePlacar() > jogo.visitantePlacar())
                .toList()
                .size();
    }

    public Long getTotalVitoriasForaDeCasa() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .filter(jogo -> jogo.mandantePlacar() < jogo.visitantePlacar())
                .count();
    }

    public Long getTotalEmpates() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .filter(jogo -> Objects.equals(jogo.mandantePlacar(), jogo.visitantePlacar()))
                .count();
    }

    public Long getTotalJogosComMenosDe3Gols() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .filter(jogo -> jogo.mandantePlacar() + jogo.visitantePlacar() < 3)
                .count();
    }

    public Long getTotalJogosCom3OuMaisGols() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .filter(jogo -> jogo.mandantePlacar() + jogo.visitantePlacar() >= 3)
                .count();
    }

    public Map<Resultado, Long> getTodosOsPlacares() {
        Map<Resultado, Long> placarNumeroDeRep = new HashMap<>();

        List<Resultado> placar = this.retonraStreamDeFlatMapDoMapBarsileirao()
                .map(jogo -> new Resultado(jogo.mandantePlacar(), jogo.visitantePlacar()))
                .toList();
        for (Resultado resultado : placar) {
            placarNumeroDeRep.putIfAbsent(resultado, placar.stream().filter(placarUnico -> placarUnico.equals(resultado)).count());
        }
        return placarNumeroDeRep;
    }

    public Map<Resultado, Long> getPlacarMaisRepetido() {
        Long numeroVezesMaxRep = this.getTodosOsPlacares().values()
                .stream()
                .max((valor1, valor2) -> (int) (valor1 - valor2)).get();
        return this.getTodosOsPlacares().entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), numeroVezesMaxRep))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Resultado, Long> getPlacarMenosRepetido() {
        Long numeroVezesMinRep = this.getTodosOsPlacares().values()
                .stream()
                .min((valor1, valor2) -> (int) (valor1 - valor2)).get();
        return this.getTodosOsPlacares().entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), numeroVezesMinRep))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private List<Time> getTodosOsTimes() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .map(Jogo::mandante)
                .collect(Collectors.toSet())
                .stream()
                .toList();
    }

    private Map<Time, List<Jogo>> getTodosOsJogosPorTimeComoMandantes() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .collect(Collectors.groupingBy(
                        Jogo::mandante));
    }

    private Map<Time, List<Jogo>> getTodosOsJogosPorTimeComoVisitante() {
        return this.retonraStreamDeFlatMapDoMapBarsileirao()
                .collect(Collectors.groupingBy(
                        Jogo::visitante));
    }

    public Map<Time, List<Jogo>> getTodosOsJogosPorTime() {
        Map<Time, List<Jogo>> todosOsJogosPorTime = new HashMap<>(getTodosOsJogosPorTimeComoMandantes());
        getTodosOsJogosPorTimeComoVisitante().forEach(
                (key, value) -> todosOsJogosPorTime.merge(key, value, (lista1, lista2) -> {
                    List<Jogo> listaGeral = new ArrayList<>();
                    listaGeral.addAll(lista1);
                    listaGeral.addAll(lista2);
                    return listaGeral;
                })
        );
        return todosOsJogosPorTime;
    }

    public Integer getNumeroDeVitoriasPorTime(Time time) {
        return this.getTodosOsJogosPorTime().get(time)
                .stream()
                .map(Jogo::vencedor)
                .filter(timeVencedor -> Objects.equals(timeVencedor, time))
                .map(time1 -> 1)
                .reduce(0, Integer::sum);
    }

    public Integer getNumeroDeDerrotasPorTime(Time time) {
        return this.getTodosOsJogosPorTime().get(time)
                .stream()
                .map(Jogo::vencedor)
                .filter(timeVencedor -> !Objects.equals(timeVencedor, time)
                        && !Objects.equals(timeVencedor, new Time("-")))
                .map(time1 -> 1)
                .reduce(0, Integer::sum);
    }

    public Integer getNumeroDeEmpatesPorTime(Time time) {
        return this.getTodosOsJogosPorTime().get(time).size()
                - this.getNumeroDeDerrotasPorTime(time)
                - this.getNumeroDeVitoriasPorTime(time);
    }

    public Integer getNumeroDePontosPorTime(Time time) {
        return this.getNumeroDeEmpatesPorTime(time) + 3 * this.getNumeroDeVitoriasPorTime(time);
    }

    public List<PosicaoTabela> getTabela() {
        List<PosicaoTabela> tabela = new ArrayList<>();
        Time time;
        for (int i = 0; i < getTodosOsTimes().size(); i++) {
            time = getTodosOsTimes().get(i);
            tabela.add(new PosicaoTabela(time,
                    getNumeroDePontosPorTime(time),
                    getNumeroDeVitoriasPorTime(time),
                    getNumeroDeDerrotasPorTime(time),
                    getNumeroDeEmpatesPorTime(time),
                    getTotalDeGolsPorTime(time),
                    getTotalDeGolsSofridoPorTime(time),
                    getSaldoDeGolsPorTime(time)
            ));
        }

        return tabela.stream()
                .sorted(Comparator.comparing(PosicaoTabela::pontos)
                        .reversed()
                        .thenComparing(Comparator.comparing(PosicaoTabela::vitorias)
                                .thenComparing(PosicaoTabela::saldoDeGols)
                                .reversed()
                        ))
                .toList();
    }

    private DayOfWeek getDayOfWeek(String dia) {
        if (dia.equalsIgnoreCase("Segunda-feira")) {
            return DayOfWeek.MONDAY;
        } else if (dia.equalsIgnoreCase("terça-feira")) {
            return DayOfWeek.TUESDAY;
        } else if (dia.equalsIgnoreCase("quarta-feira")) {
            return DayOfWeek.WEDNESDAY;
        } else if (dia.equalsIgnoreCase("quinta-feira")) {
            return DayOfWeek.THURSDAY;
        } else if (dia.equalsIgnoreCase("sexta-feira")) {
            return DayOfWeek.FRIDAY;
        } else if (dia.equalsIgnoreCase("sábado")) {
            return DayOfWeek.SATURDAY;
        } else {
            return DayOfWeek.SUNDAY;
        }
    }


    public Map<Integer, Integer> getTotalGolsPorRodada() {
        return this.brasileirao
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entrada -> entrada.getValue()
                                .stream()
                                .map(jogo -> jogo.mandantePlacar() + jogo.visitantePlacar())
                                .toList()
                                .stream()
                                .reduce(0, Integer::sum)));
    }

    public Integer getTotalDeGolsQuandoMandante(Time time) {
        return this.getTodosOsJogosPorTimeComoMandantes().get(time)
                .stream()
                .map((Jogo::mandantePlacar))
                .reduce(0, Integer::sum);
    }

    public Integer getTotalDeGolsSofridosQuandoMandante(Time time) {
        return this.getTodosOsJogosPorTimeComoMandantes().get(time)
                .stream()
                .map((Jogo::visitantePlacar))
                .reduce(0, Integer::sum);
    }

    private Integer getTotalDeGolsQuandoVisitante(Time time) {
        return this.getTodosOsJogosPorTimeComoVisitante().get(time)
                .stream()
                .map((Jogo::visitantePlacar))
                .reduce(0, Integer::sum);
    }

    private Integer getTotalDeGolsSofridosQuandoVisitante(Time time) {
        return this.getTodosOsJogosPorTimeComoVisitante().get(time)
                .stream()
                .map((Jogo::mandantePlacar))
                .reduce(0, Integer::sum);
    }

    public Integer getTotalDeGolsPorTime(Time time) {
        return this.getTotalDeGolsQuandoVisitante(time) + this.getTotalDeGolsQuandoMandante(time);
    }

    public Integer getTotalDeGolsSofridoPorTime(Time time) {
        return this.getTotalDeGolsSofridosQuandoVisitante(time) + this.getTotalDeGolsSofridosQuandoMandante(time);
    }

    public Integer getSaldoDeGolsPorTime(Time time) {
        return this.getTotalDeGolsPorTime(time) - this.getTotalDeGolsSofridoPorTime(time);
    }

    public Map<Integer, Double> getMediaDeGolsPorRodada() {

        return this.getTotalGolsPorRodada()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entrada -> (entrada.getValue() /
                                (double) this.brasileirao.values()
                                        .stream()
                                        .map(List::size)
                                        .toList()
                                        .get(0))));
    }


}