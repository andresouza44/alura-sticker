package imdb;

import com.google.gson.Gson;
import conteudo.Conteudo;
import conteudo.ExtratorDeConteudo;
import metodos.GeradorEstrelasRatio;

import java.util.List;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo {
    Gson gson = new Gson();

    @Override
    public List<Conteudo> extrairConteudos(String json) {
        ListaDeConteudosImdb listaDeConteudosImdb = gson.fromJson(json, ListaDeConteudosImdb.class);

        return listaDeConteudosImdb.getItems().stream()
            .map(atributos ->
                    new Conteudo(atributos.title(),getCorrectUrlPoster(atributos.image())))
            .toList();
    }

    @Override
    public void imprimirAtributos(String json) {
        ListaDeConteudosImdb listaDeConteudosImdb = gson.fromJson(json, ListaDeConteudosImdb.class);
        for (ConteudoIMDB item : listaDeConteudosImdb.getItems()) {
            System.out.print("Título: " + item.title());
            System.out.print("\n\u001b[45;1m Classificação: " + item.imDbRating() + "\u001b[m ");
            System.out.print(GeradorEstrelasRatio.printStar(item.imDbRating())+"\n\n");

        }
    }

    private String getCorrectUrlPoster (String url){
        return url.substring(0,url.indexOf("@")+1)
                + url.substring(url.length()-4);

    }
}
