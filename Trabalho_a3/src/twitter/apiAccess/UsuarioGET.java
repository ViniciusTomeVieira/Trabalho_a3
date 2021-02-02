package twitter.apiAccess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import twitter.model.Usuarios;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class UsuarioGET {
    private Client client;
    private WebTarget webTarget;
    private Invocation.Builder invocationBuilder;
    private final String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAEFSMQEAAAAAaULnquLDV7WSCul%2B4yhXWZz6e2Q%3DpJaVDUFTyvxH3f0BFddvdRDGRhTKKlnWqQzGVcCReDlzsREYf4";
    private final ObjectMapper mapper;

    public UsuarioGET() {
        client = ClientBuilder.newClient();
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    public Usuarios getUsuarioByUsername(String username) throws Exception {
        String accessLInk = "https://api.twitter.com/2/users/by/username/"+username+"?user.fields=created_at&profile_image_url";
        webTarget = client.target(accessLInk);

        invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON_TYPE).header(HttpHeaders.AUTHORIZATION, "Bearer " + BEARER_TOKEN);
        if (invocationBuilder.get().getStatus() == 200) {
            String usuarioResponse = invocationBuilder.get().readEntity(String.class);
            Usuarios usuarios = mapper.readValue(usuarioResponse, Usuarios.class);
            return usuarios;
        } else {
            throw  new Exception("usuário iválido");
        }
    }
}
