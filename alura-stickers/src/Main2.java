import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url =  "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        JasonParser parser = new JasonParser();

        List<Map<String,String >> movieList = parser.parse(body);
        for (Map<String, String> filmes : movieList) {
            System.out.println(filmes.get("title"));

        }




    }
}
