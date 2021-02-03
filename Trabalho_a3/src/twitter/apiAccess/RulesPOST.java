package twitter.apiAccess;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import twitter.model.Rules;
import twitter.model.RulesResponse;

import javax.ws.rs.client.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela comunicação com a API do twitter (Rules POST)
 */
public class RulesPOST {
    private Client client;
    private WebTarget webTarget;
    private final ObjectMapper mapper;
    private final String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAEFSMQEAAAAAaULnquLDV7WSCul%2B4yhXWZz6e2Q%3DpJaVDUFTyvxH3f0BFddvdRDGRhTKKlnWqQzGVcCReDlzsREYf4";
    public RulesPOST() {
        client = ClientBuilder.newClient();
        mapper =new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    public RulesResponse setRules(Rules rule) throws Exception {
        String accessLInk = "https://api.twitter.com/2/tweets/search/stream/rules";
        webTarget = client.target(accessLInk);

        Response response = webTarget.request().header(HttpHeaders.AUTHORIZATION, "Bearer " + BEARER_TOKEN).post(Entity.entity(rule, MediaType.APPLICATION_JSON_TYPE));
        String res = response.readEntity(String.class);
        if(response.getStatus() == 201) {
            RulesResponse rulesResponse = mapper.readValue(res, RulesResponse.class);         
            return rulesResponse;
        }else throw new Exception("Erro ao adicionar a regra");
    }

}
