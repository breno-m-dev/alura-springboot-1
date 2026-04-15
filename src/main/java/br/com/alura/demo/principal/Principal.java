package br.com.alura.demo.principal;

import br.com.alura.demo.model.DadosSerie;
import br.com.alura.demo.model.DadosTemporada;
import br.com.alura.demo.service.ConsumoApi;
import br.com.alura.demo.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();


    public void exibeMenu(){
        System.out.println();
        var nomeSerie = leitura.nextLine();
        nomeSerie = nomeSerie.replace(" ", "+");
        System.out.println(nomeSerie);

        var json = consumoApi.obterDados(ENDERECO + nomeSerie + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
		for(int i = 1; i <= dados.totalTemporadas() ;i++){
			json = consumoApi.obterDados(ENDERECO + nomeSerie + API_KEY + "+" + "&season=" + i);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);

		}
		temporadas.forEach(System.out::println);
    }

}
