package br.com.alura.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imdbRating") String avaliacao){
//@JsonProperty("ImdbVotes") @jsonproperty serve pra ler e escrever
    //@JsonAlias usa só para ler
    //da pra procurar mais de uma palavra com o json alias
    //tipo @JsonAlias("Title", "Titulo") String titulo,


}
