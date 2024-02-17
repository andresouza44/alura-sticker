

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
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String API_KEY = null;
        try {
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream("./properties/config.properties");
            prop.load(file);
            API_KEY = prop.getProperty("api.key.tmdb");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        String url2 = "https://api.themoviedb.org/3/discover/tv?api_key=" + API_KEY;

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        System.out.println(body);

        Gson gson = new Gson();
        MovieList movieList = gson.fromJson(body, MovieList.class);

        List<Movie> movies = movieList.getItem();
        for (Movie movie : movies) {
            System.out.println("Título: " + movie.getTitle());
            System.out.println("Poster: " + movie.getImage());
            System.out.println("\u001b[45;1m Classificação: " + movie.getImDbRating() + "\u001b[m");
            System.out.println(printStar(movie.getImDbRating()));

        }
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





