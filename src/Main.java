import conteudo.Conteudo;
import conteudo.ExtratorDeConteudo;
import imdb.ExtratorDeConteudoIMDB;
import metodos.ApiKey;
import nasa.ExtratorDeConteudoNasa;
import pexels.ExtratorDeConteudoPexels;
import themovie.ExtratorDeConteudoTheMovie;

import java.io.InputStream;
import java.net.URI;
import java.util.List;

    public class Main {
public static void main(String[] args) throws Exception {

        /*String API_KEY = ApiKey.getApiKey("api.key.tmdb");
        Integer page = 10;
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language=pt-br" + "&page=" + page;
        ExtratorDeConteudo extrator = new ExtratorDeConteudoTheMovie();*/

       /* String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; // NASA
         ExtratorDeConteudo extrator = new ExtratorDeConteudoNasa();*/



        /*String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoIMDB();
        String API_KEY = null;*/

    String API_KEY = ApiKey.getApiKey("api.key.pexels");
    String url = "https://api.pexels.com/v1/curated";
    ExtratorDeConteudo extrator = new ExtratorDeConteudoPexels();

        var http = new ClientHTTP();
        String json = http.getData(url, API_KEY);


        extrator.imprimirAtributos(json);

        var gerador = new GeradorDeFigutinhas();

        List<Conteudo> conteudos = extrator.extrairConteudos(json);

        // Gerar Figurinhas
        for (Conteudo conteudo : conteudos) { //.subList(0,5)
            String titulo = conteudo.title();
            String imageUrl = conteudo.imageUrl();
            String fileName = titulo + ".png";


            try (InputStream inputStream = new URI(imageUrl).toURL().openStream()) {
                gerador.cria(inputStream, fileName);
            }catch (Exception e){
                System.err.println( "\n" + titulo + " Movie Poster not found " + e.getMessage());
            }
        }

    }
}








