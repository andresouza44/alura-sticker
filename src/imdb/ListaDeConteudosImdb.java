package imdb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaDeConteudosImdb {
    @SerializedName("items")
   private List <ConteudoIMDB> items;

    public ListaDeConteudosImdb(List<ConteudoIMDB> item) {
        this.items = item;
    }

    public ListaDeConteudosImdb(ConteudoIMDB item) {

    }

    public List<ConteudoIMDB> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ListaDeConteudosImdb{" +
                "items=" + items +
                '}';
    }
}
