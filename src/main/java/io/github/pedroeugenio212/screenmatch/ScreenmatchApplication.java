package io.github.pedroeugenio212.screenmatch;

import io.github.pedroeugenio212.screenmatch.model.DadosSerie;
import io.github.pedroeugenio212.screenmatch.service.ConsumoApi;
import io.github.pedroeugenio212.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner
{

    public static void main(String[] args)
    {
	SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
	var consumoApi = new ConsumoApi();
	var json = consumoApi.obterDados("https://www.omdbapi.com/?t=simpsons&apikey=139960a6");

	System.out.println(json);
	ConverteDados conversor = new ConverteDados();
	DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
	System.out.println(dados);
	
    }

}
