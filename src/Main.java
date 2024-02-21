import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import javax.lang.model.element.NestingKind;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;


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

        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
         String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; // NASA
       // String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language=pt-br" + "&page=2";

        var http = new ClientHTTP();
        String json = http.getData(url);

        Gson gson = new Gson();

        try {
            ListaDeConteudos listaDeConteudos = gson.fromJson(json, ListaDeConteudos.class);
            List<Conteudo> conteudos = listaDeConteudos.getItem().subList(0,10);
            var gerador = new GeradorDeFigutinhas();

            for (Conteudo conteudo : conteudos) {

                String titulo = conteudo.getTitle();
                String imageUrl = conteudo.getImage();
                String fileName = titulo + ".png";

                String imageUrlHighResolution = imageUrl.substring(0,imageUrl.indexOf("@")+1) +
                        imageUrl.substring(imageUrl.length()-4);

                try (InputStream inputStream = new URI(imageUrlHighResolution).toURL().openStream()) {

                    gerador.cria(inputStream, fileName);
                }catch (Exception e){
                    System.err.println( titulo + " Movie Poster not found" + e.getMessage());
                }

                System.out.print("Título: " + titulo);//System.out.println("Poster: " + movie.getImage());
                System.out.print("\n\u001b[45;1m Classificação: " + conteudo.getImDbRating() + "\u001b[m ");
                System.out.print(printStar(conteudo.getImDbRating())+"\n\n");


            }


        }catch (JsonSyntaxException e) {
            System.out.println(e.getMessage());
            Conteudo[] conteudos = gson.fromJson(json, Conteudo[].class);

            var gerador = new GeradorDeFigutinhas();

            for (Conteudo conteudo : conteudos) {

                String titulo = conteudo.getTitle();
                System.out.println(titulo + "\n" + conteudo.getUrl());


            }
        }



        /*

        var gerador = new GeradorDeFigutinhas();

        for (Conteudo conteudo : conteudos) {

            String titulo = conteudo.getTitle();
            String imageUrl = conteudo.getImage();
            String fileName = titulo + ".png";

            String imageUrlHighResolution = imageUrl.substring(0,imageUrl.indexOf("@")+1) +
                    imageUrl.substring(imageUrl.length()-4);

            try (InputStream inputStream = new URI(imageUrlHighResolution).toURL().openStream()) {

                gerador.cria(inputStream, fileName);
            }catch (Exception e){
                System.err.println( titulo + " Movie Poster not found" + e.getMessage());
            }

            System.out.print("Título: " + titulo);//System.out.println("Poster: " + movie.getImage());
            System.out.print("\n\u001b[45;1m Classificação: " + conteudo.getImDbRating() + "\u001b[m ");
            System.out.print(printStar(conteudo.getImDbRating())+"\n\n");


        }
*/
    }
        static String printStar (String star){
            int starInteger = (int) Math.round(Double.parseDouble(star));

            return switch (starInteger) {
                case 1 -> "⭐";
                case 2 -> "⭐⭐";
                case 3 -> "⭐⭐⭐";
                case 4 -> "⭐⭐⭐⭐⭐";
                case 5 -> "⭐⭐⭐⭐⭐⭐";
                case 6 -> "⭐⭐⭐⭐⭐⭐⭐";
                case 7 -> "⭐⭐⭐⭐⭐⭐⭐⭐";
                case 8 -> "⭐⭐⭐⭐⭐⭐⭐⭐⭐";
                case 9 -> "⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐";
                case 10 -> "⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐";
                default -> "";
            };
    }

}





