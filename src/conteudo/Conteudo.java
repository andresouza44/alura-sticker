package conteudo;

public class Conteudo {
   private String title;
   private String imageUrl;

   public Conteudo(){
   }
    public Conteudo(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' ;
    }
}
