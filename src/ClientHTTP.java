import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Properties;

public class ClientHTTP {

    public String getData (String url){
        return getData(url, null);
    }

    public  String getData (String url, String authorizationToken ) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .GET()
                    .timeout(Duration.ofSeconds(10))
                    .uri(URI.create(url));

            if (authorizationToken != null) {
                requestBuilder.header("Authorization",  authorizationToken);
            }

            HttpRequest request = requestBuilder.build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return  response.body();


        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException();
        }

    }

}
