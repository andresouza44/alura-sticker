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
                        new Conteudo(atributos.getTitle(), atributos.getImage().substring(0,atributos.getImage().indexOf("@")+1) +
                                atributos.getImage().substring(atributos.getImage().length()-4)))
                .toList();
    }

    @Override
    public void imprimirAtributos(String json) {
        ListaDeConteudosImdb listaDeConteudosImdb = gson.fromJson(json, ListaDeConteudosImdb.class);
        for (ConteudoIMDB item : listaDeConteudosImdb.getItems()) {
            System.out.print("Título: " + item.getTitle());
            System.out.print("\n\u001b[45;1m Classificação: " + item.getImDbRating() + "\u001b[m ");
            System.out.print(GeradorEstrelasRatio.printStar(item.getImDbRating())+"\n\n");

        }
    }
}

