package io.github.pedroeugenio212.screenmatch.principal;

import io.github.pedroeugenio212.screenmatch.model.DadosSerie;
import io.github.pedroeugenio212.screenmatch.model.DadosTemporada;
import io.github.pedroeugenio212.screenmatch.model.Episodio;
import io.github.pedroeugenio212.screenmatch.service.ConsumoApi;
import io.github.pedroeugenio212.screenmatch.service.ConverteDados;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal
{

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=139960a6";

    public void exibeMenu()
    {

	System.out.println("Digite o nome da série:");
	var nomeSerie = leitura.nextLine();
	var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
	DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
	System.out.println(dados);

	List<DadosTemporada> temporadas = new ArrayList<>();
	for (int i = 1; i < dados.totalTemporadas(); i++)
	{
	    json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
	    DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
	    temporadas.add(dadosTemporada);
	}

//	System.out.println("\n Top 5 episódios");
	List<Episodio> episodios = temporadas.stream()
		.flatMap(t -> t.episodios().stream()
		.map(d -> new Episodio(t.numero(), d))
		).collect(Collectors.toList());

//	episodios.stream()
//		.sorted(Comparator.comparing(Episodio::getAvaliacao).reversed())
//		.limit(5)
//		.map(e -> e.getTitulo().toUpperCase())
//		.forEach(System.out::println);
//	System.out.println("Digite o nome do episódio:");
//	var trechoTitulo = leitura.nextLine();
//	Optional<Episodio> episodioBuscado = episodios.stream()
//		.filter(e -> e.getTitulo().toUpperCase().contains(trechoTitulo.toUpperCase()))
//		.findFirst();
//
//	if (episodioBuscado.isPresent())
//	{
//	    System.out.println("Episódio encontrado!");
//	    System.out.println("Título:	" + episodioBuscado.get().getTitulo());
//	    System.out.println("Temporada: " + episodioBuscado.get().getTemporada());
//	} else
//	{
//	    System.out.println("Episódio não encontrado...");
//	}
//	System.out.println("A partir de que ano você deseja ver os episódios?");
//	var ano = leitura.nextInt();
//	leitura.nextLine();
//
//	LocalDate dataBusca = LocalDate.of(ano, 1, 1);
//
//	episodios.stream()
//		.filter(e -> e.getDataLancamento() != null && e.getDataLancamento().isAfter(dataBusca))
//		.forEach(e -> System.out.println(
//		"Temporada: " + e.getTemporada()
//		+ ", Episódio: " + e.getTitulo()
//		+ ", Data Lançamento: " + e.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
//	));
	Map<Integer, Double> avaliacoesPorTemporada = episodios.stream()
		.collect(Collectors.groupingBy(Episodio::getTemporada,
					       Collectors.averagingDouble(Episodio::getAvaliacao)));
	System.out.println(avaliacoesPorTemporada);
    }
}
