import conteudo.Conteudo;
import imdb.ExtratorDeConteudoIMDB;
import metodos.GeradorEstrelasRatio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws Exception {
        String API_KEY = null;
        try {
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream("./properties/config.properties");
            prop.load(file);
            API_KEY = prop.getProperty("api.key.tmdb");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language=pt-br" + "&page=2";


        //String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; // NASA
        //ExtratorConteudoNasa extrator = new ExtratorConteudoNasa();

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();

        var http = new ClientHTTP();
        String json = http.getData(url);

        extrator.imprimirAtributos(json);

        var gerador = new GeradorDeFigutinhas();

        List<Conteudo> conteudos = extrator.extrairConteudos(json);;
        for (Conteudo conteudo : conteudos.subList(0,3)) {
            String titulo = conteudo.getTitle();
            String imageUrl = conteudo.getImageUrl();
            String fileName = titulo + ".png";

            try (InputStream inputStream = new URI(imageUrl).toURL().openStream()) {
                gerador.cria(inputStream, fileName);
            }catch (Exception e){
                System.err.println( "\n" + titulo + " Movie Poster not found " + e.getMessage());
            }
        }

    }
}







