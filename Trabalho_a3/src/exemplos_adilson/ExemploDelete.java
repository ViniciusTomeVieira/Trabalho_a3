package clientews;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ExemploDelete {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ws");

		Response response = webTarget.path("cliente")
										.path("1").request().delete();
		System.out.println(response.getStatus());
		System.out.println(response.getStatusInfo());
	}

}
