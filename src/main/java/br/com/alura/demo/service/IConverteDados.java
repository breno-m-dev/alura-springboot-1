package br.com.alura.demo.service;

public interface IConverteDados {
    public <T> T obterDados(String json, Class<T> classe);
}
