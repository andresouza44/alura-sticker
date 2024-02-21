import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListaDeConteudos {
    @SerializedName("items")
   private List <Conteudo> item ;


    public ListaDeConteudos(List<Conteudo> item) {
        this.item = item;
    }

    public  ListaDeConteudos(Conteudo item) {

    }

    public List<Conteudo> getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "moviesList=" + item +
                '}';
    }
}
