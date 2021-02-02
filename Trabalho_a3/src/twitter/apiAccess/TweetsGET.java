package twitter.apiAccess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import twitter.model.Tweets;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class TweetsGET {
    private Client client;
    private WebTarget webTarget;
    private Invocation.Builder invocationBuilder;
    private final String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAEFSMQEAAAAAaULnquLDV7WSCul%2B4yhXWZz6e2Q%3DpJaVDUFTyvxH3f0BFddvdRDGRhTKKlnWqQzGVcCReDlzsREYf4";
    private ObjectMapper mapper;
    public TweetsGET() {
        client = ClientBuilder.newClient();
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
    }

    public Tweets getTweetByUsuarioID(String usuarioId, int qntTweets) throws JsonProcessingException {

        String accessLInk = "https://api.twitter.com/2/users/"+usuarioId+"/tweets?max_results="+qntTweets;
        webTarget = client.target(accessLInk);
        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE).header(HttpHeaders.AUTHORIZATION, "Bearer " + BEARER_TOKEN);
        String tweets = invocationBuilder.get().readEntity(String.class);

        Tweets tweet = mapper.readValue(tweets,Tweets.class);
        return tweet;
    }




}
