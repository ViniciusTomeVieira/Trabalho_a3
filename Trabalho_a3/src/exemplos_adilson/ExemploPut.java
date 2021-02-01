package exemplos_adilson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class ExemploPut {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("c", "c");
		client.register(feature);

		WebTarget webTarget = client.target("http://localhost:8080/ws");
		Cliente c = webTarget.path("cliente")
								.path("3")
								.request(MediaType.APPLICATION_JSON_TYPE)
								.get()
								.readEntity(Cliente.class);
		c.setNome("Alterado");
		
		Response response = webTarget.path("cliente").request().put(Entity.entity(c, MediaType.APPLICATION_JSON_TYPE));
		System.out.println(response.getStatus()); // 201 - ok 401 - nao autorizado 500 - outros erros, por exemplo, nome repetido
		System.out.println(response.getStatusInfo());
	}

}
