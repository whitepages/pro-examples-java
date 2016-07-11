import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class CallerIdentificationGet {
    public static void main(String[] args) throws URISyntaxException, IOException {
        // Build the URI.
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("proapi.whitepages.com")
                .setPath("/3.0/caller_identification")
                .setParameter("api_key", System.getenv("CALLER_ID_API_KEY"))
                .setParameter("phone", "6464806649")
                .build();

        // Init GET request and client.
        HttpGet getRequest = new HttpGet(uri);
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Get the response.
        HttpResponse response = httpClient.execute(getRequest);

        // Read response content to a Map.
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
        };
        Map<String, Object> jsonMap = mapper.readValue(response.getEntity().getContent(), typeRef);

        System.out.println(jsonMap);
    }
}
