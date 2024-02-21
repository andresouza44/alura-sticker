package themovie;

import com.google.gson.annotations.SerializedName;
import themovie.ConteudoTheMovie;

import java.util.List;

public class ListaDeconteudoTheMovie {
    @SerializedName("results")
    private List<ConteudoTheMovie> results;

    @SerializedName("total_pages")
    private String total_pages;
    private String page;

    public ListaDeconteudoTheMovie(List<ConteudoTheMovie> results, String total_pages) {
        this.total_pages = total_pages;
        this.results = results;
    }

    public String getPage() {
        return page;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public List<ConteudoTheMovie> getResults() {
        return results;
    }


}
