package exemplos_adilson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ExemploPost {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("b", "b");
		client.register(feature);

		Cliente c = new Cliente();
		c.setNome("AAB");

		WebTarget webTarget = client.target("http://localhost:8080/ws");
		Response response = webTarget.path("cliente").request().post(Entity.entity(c, MediaType.APPLICATION_JSON_TYPE));
		System.out.println(response.getStatus()); // 201 - ok 401 - nao autorizado 500 - outros erros, por exemplo, nome repetido
		System.out.println(response.getStatusInfo());
	}

}
