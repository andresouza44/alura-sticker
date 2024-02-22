package pexels;

import com.google.gson.Gson;
import conteudo.Conteudo;
import conteudo.ExtratorDeConteudo;

import java.util.List;

public class ExtratorDeConteudoPexels implements ExtratorDeConteudo {
    Gson gson = new Gson();

    @Override
    public List<Conteudo> extrairConteudos(String json) {
        ListaDeConteudosPexels conteudoPexels = gson.fromJson(json, ListaDeConteudosPexels.class);

        return conteudoPexels.getPhotos().stream()
               .map(atributos -> new Conteudo(atributos.alt(), atributos.src().original())).toList();
    }

    @Override
    public void imprimirAtributos(String json) {
        ListaDeConteudosPexels conteudosPexels = gson.fromJson(json, ListaDeConteudosPexels.class);
        for (ConteudoPexels photo : conteudosPexels.getPhotos()) {
            System.out.println("Título: " + photo.alt());
            System.out.println("Fotógrafo: " + photo.photographer() + "\n");
        }

    }
}
