import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Properties;


public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        String API_KEY = null;
        try {
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream("./properties/config.properties");
            prop.load(file);
            API_KEY = prop.getProperty("api.key");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        String url2 = "https://api.themoviedb.org/3/movie/157336/videos?api_key=" + API_KEY;

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();

        // Usando O Jackson

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            MovieList movieList = objectMapper.readValue(body, MovieList.class);

            // Agora você pode acessar os dados da lista de filmes
            List<Movie> movies = movieList.getItems();
            for (Movie movie : movies) {
                System.out.println("Título: " + movie.getTitle());
                System.out.println("ID: " + movie.getId());
                // Adicione mais campos conforme necessário
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        /* usando Regex
        JasonParser parser = new JasonParser();

        List <Map<String, String>>  moviesList =  parser.parse(body);
        for (Map<String, String> movie : moviesList) {
            System.out.println("Título: " + movie.get("title"));
            System.out.println("Poster: " + movie.get("image"));
            System.out.println("\u001b[45;1m Classificação: " + movie.get("imDbRating") + "\u001b[m");
            System.out.println(printStar(movie.get("imDbRating")));
        }
        */

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Type type = new TypeToken<List<Movie>>(){}.getType();
        List<Movie>  movies = gson.fromJson(body, type);

        for (Movie movie : movies) {
            System.out.println(movie);

        }

       // System.out.println(type);
       // List <Movie> movie = gson.fromJson(body,type);


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





