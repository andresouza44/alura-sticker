package themovie;

import com.google.gson.Gson;
import conteudo.Conteudo;
import conteudo.ExtratorDeConteudo;
import metodos.GeradorEstrelasRatio;

import java.util.List;

public class ExtratorDeConteudoTheMovie implements ExtratorDeConteudo {

    Gson gson = new Gson();
    String baseUrlPoster = "https://image.tmdb.org/t/p/w500";

    @Override
    public List<Conteudo> extrairConteudos(String json) {
        ListaDeconteudoTheMovie listaDeconteudoTheMovie = gson.fromJson(json, ListaDeconteudoTheMovie.class);
        return listaDeconteudoTheMovie.getResults().stream()
                .map(atributos ->
                        new Conteudo(atributos.title(),
                                baseUrlPoster + atributos.poster_path())).toList();
    }

    @Override
    public void imprimirAtributos(String json) {
        ListaDeconteudoTheMovie listaDeconteudoTheMovie = gson.fromJson(json, ListaDeconteudoTheMovie.class);
        for (ConteudoTheMovie result : listaDeconteudoTheMovie.getResults()) {
            System.out.print("Título: " + result.title());
            System.out.print("\n\u001b[45;1m Classificação: " + result.vote_average() + "\u001b[m ");
            System.out.print(GeradorEstrelasRatio.printStar(result.vote_average())+"\n\n");

        }

        //TODO

    }
}
