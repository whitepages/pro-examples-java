import java.util.Map;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.utils.URIBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class IdentityCheckGet {
    public static void main(String[] args) throws URISyntaxException, IOException {
        // Build the URI.
        URI uri = new URIBuilder()
                .setScheme("https")
                .setHost("proapi.whitepages.com")
                .setPath("/3.1/identity_check.json")
                .setParameter("api_key", System.getenv("ID_CHECK_API_KEY"))
                .setParameter("billing.name", "Drama Number")
                .setParameter("billing.phone", "6464806649")
                .setParameter("billing.address.street_line_1", "302 Gorham Ave")
                .setParameter("billing.address.city", "Ashland")
                .setParameter("billing.address.state_code", "MT")
                .setParameter("billing.address.postal_code", "59004")
                .setParameter("billing.address.country_code", "US")
                .setParameter("shipping.name", "Drama Number")
                .setParameter("shipping.phone", "6464806649")
                .setParameter("shipping.address.street_line_1", "302 Gorham Ave")
                .setParameter("shipping.address.city", "Ashland")
                .setParameter("shipping.address.state_code", "MT")
                .setParameter("shipping.address.postal_code", "59004")
                .setParameter("shipping.address.country_code", "US")
                .setParameter("email_address", "medjalloh1@yahoo.com")
                .setParameter("ip_address", "108.194.128.165")
                .build();

        // Init GET request and client.
        HttpGet getRequest = new HttpGet(uri);
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Get the response.
        HttpResponse response = httpClient.execute(getRequest);

        // Read response content to a Map.
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {};
        Map<String, Object> jsonMap = mapper.readValue(response.getEntity().getContent(), typeRef);

        String[] availableChecks = new String[]{"billing_name_checks", "billing_phone_checks", "billing_address_checks",
                                                "shipping_name_checks", "shipping_phone_checks", "shipping_address_checks",
                                                "email_address_checks", "ip_address_checks"};

        // Display check results.
        for(String check : availableChecks){
            System.out.println(jsonMap.get(check).toString());
        }
    }
}
