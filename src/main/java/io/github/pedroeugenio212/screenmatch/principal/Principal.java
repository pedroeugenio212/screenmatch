package io.github.pedroeugenio212.screenmatch.principal;

import io.github.pedroeugenio212.screenmatch.model.DadosSerie;
import io.github.pedroeugenio212.screenmatch.model.DadosTemporada;
import io.github.pedroeugenio212.screenmatch.service.ConsumoApi;
import io.github.pedroeugenio212.screenmatch.service.ConverteDados;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal
{

    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=139960a6";

    public void exibeMenu()
    {

//	System.out.println("Digite o nome da série:");
//	var nomeSerie = leitura.nextLine();
//	var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
//	DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
//	System.out.println(dados);
//
//	List<DadosTemporada> temporadas = new ArrayList<>();
//	for (int i = 1; i < dados.totalTemporadas(); i++)
//	{
//	    json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY);
//	    DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
//	    temporadas.add(dadosTemporada);
//	}
//
//	temporadas.forEach(e -> e.episodios()
//		.forEach(t -> System.out.println(t.titulo())));
	List<String> nomes = Arrays.asList("Pedro","Beca", "Maria", "Raul");
	nomes.stream()
		.sorted() 
		.limit(2)
		.filter(e -> e.startsWith("B"))
		.map(e -> e.toUpperCase())
		.forEach(System.out::println);
    }
}
