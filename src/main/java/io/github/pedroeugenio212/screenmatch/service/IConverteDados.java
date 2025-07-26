package io.github.pedroeugenio212.screenmatch.service;

public interface IConverteDados
{
    <T> T obterDados(String json, Class<T> classe);
}
