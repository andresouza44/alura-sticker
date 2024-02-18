import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieList {
    @SerializedName("items")
    List<Movie> item;

    public MovieList(List<Movie> item) {
        this.item = item;
    }

    public List<Movie> getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "moviesList=" + item +
                '}';
    }
}
