package twitter;

import com.sun.jndi.toolkit.url.Uri;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ExemploListarTweet {
        private static final String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAEFSMQEAAAAAaULnquLDV7WSCul%2B4yhXWZz6e2Q%3DpJaVDUFTyvxH3f0BFddvdRDGRhTKKlnWqQzGVcCReDlzsREYf4";

	public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();              
		WebTarget webTarget = client.target("https://api.twitter.com/2/users/1039785621852704769/tweets");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE).header(HttpHeaders.AUTHORIZATION, "Bearer " + BEARER_TOKEN);
                String tweets = invocationBuilder.get().readEntity(String.class);
                System.out.println(tweets);
//                for(Tweet t:tweets.getData()){
//                    System.out.println(t.getId());
//                    System.out.println(t.getText());
//                }
                
//                for (Tweets t:tweets) {
//                    System.out.println(t);
//                }
    }
}
	    

	
	

