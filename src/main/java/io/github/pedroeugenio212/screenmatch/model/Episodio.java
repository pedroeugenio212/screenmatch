package io.github.pedroeugenio212.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio
{

    private Integer temporada;

    private String titulo;

    private Integer numeroEpisodio;

    private Double avaliacao;

    private LocalDate dataLancamento;

    public Episodio(Integer numeroTemporada, DadosEpisodio dadosEpisodio)
    {
	this.temporada = numeroTemporada;
	this.titulo = dadosEpisodio.titulo();
	this.numeroEpisodio = dadosEpisodio.numero();

	try
	{
	    this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
	} catch (NumberFormatException ex)
	{
	    this.avaliacao = 0.0;
	}

	try
	{
	    this.dataLancamento = LocalDate.parse(dadosEpisodio.dataLancamento());
	} catch (DateTimeParseException ex)
	{
	    this.dataLancamento = null;
	}
    }
    

    public Integer getTemporada()
    {
	return temporada;
    }

    public Episodio setTemporada(Integer temporada)
    {
	this.temporada = temporada;
	return this;
    }

    public String getTitulo()
    {
	return titulo;
    }

    public Episodio setTitulo(String titulo)
    {
	this.titulo = titulo;
	return this;
    }

    public Integer getNumeroEpisodio()
    {
	return numeroEpisodio;
    }

    public Episodio setNumeroEpisodio(Integer numeroEpisodio)
    {
	this.numeroEpisodio = numeroEpisodio;
	return this;
    }

    public Double getAvaliacao()
    {
	return avaliacao;
    }

    public Episodio setAvaliacao(Double avaliacao)
    {
	this.avaliacao = avaliacao;
	return this;
    }

    public LocalDate getDataLancamento()
    {
	return dataLancamento;
    }

    public Episodio setDataLancamento(LocalDate dataLancamento)
    {
	this.dataLancamento = dataLancamento;
	return this;
    }

    @Override
    public String toString()
    {
	return "temporada=" + temporada
		+ ", titulo='" + titulo + '\''
		+ ", numeroEpisodio=" + numeroEpisodio
		+ ", avaliacao=" + avaliacao
		+ ", dataLancamento=" + dataLancamento;
    }

}
