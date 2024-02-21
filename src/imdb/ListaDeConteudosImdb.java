package imdb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaDeConteudosImdb {
    @SerializedName("items")
   private List <ConteudoIMDB> item ;

    public ListaDeConteudosImdb(List<ConteudoIMDB> item) {
        this.item = item;
    }

    public ListaDeConteudosImdb(ConteudoIMDB item) {

    }

    public List<ConteudoIMDB> getItem() {
        return item;
    }

}
