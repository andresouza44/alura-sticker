package nasa;

public class ConteudoNasa {
    private String title;
    private String url;

    public ConteudoNasa(){

    }
    public ConteudoNasa(String image, String url) {
        this.title = image;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "nasa.ConteudoNasa{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
