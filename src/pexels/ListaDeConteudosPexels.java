package pexels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListaDeConteudosPexels {

    @SerializedName("photos")
    private List<ConteudoPexels> photos;


    public ListaDeConteudosPexels(List<ConteudoPexels> photos) {
        this.photos = photos;
    }


    public List<ConteudoPexels> getPhotos() {
        return photos;
    }

    @Override
    public String toString() {
        return "ListaDeConteudosPexels{" +
                "photos=" + photos +
                '}';
    }
}
