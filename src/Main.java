import conteudo.Conteudo;
import nasa.ExtratorConteudoNasa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
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

        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // String url = "https://api.themoviedb.org/3/discover/movie?api_key=" + API_KEY + "&language=pt-br" + "&page=2";

        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD"; // NASA
        ExtratorConteudoNasa extrator = new ExtratorConteudoNasa();


        var http = new ClientHTTP();
        String json = http.getData(url);

        var gerador = new GeradorDeFigutinhas();

        List<Conteudo> conteudos = extrator.extrairConteudos(json);;
        for (Conteudo conteudo : conteudos) {
            System.out.println(conteudo.getTitle() + "\n" + conteudo.getImageUrl());
        }

    }
}

/*

        try {
            ListaDeConteudosImdb listaDeConteudosImdb = gson.fromJson(json, ListaDeConteudosImdb.class);
            List<conteudo.Conteudo> conteudos = listaDeConteudosImdb.getItem().subList(0,10);


            for (conteudo.Conteudo conteudo : conteudos) {

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





            }
        }


*/

        /*

        var gerador = new GeradorDeFigutinhas();

        for (conteudo.Conteudo conteudo : conteudos) {

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

    }

*/





