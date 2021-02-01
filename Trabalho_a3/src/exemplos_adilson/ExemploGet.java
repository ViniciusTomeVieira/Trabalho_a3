package clientews;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExemploGet {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ws");
		
		Cliente c = webTarget.path("cliente")
							.path("1")
							.request(MediaType.APPLICATION_JSON_TYPE)
							.get()
							.readEntity(Cliente.class);
		
		System.out.println(c.getNome());
		
		// outra forma
		Response response = webTarget.path("cliente")
								.path("3")
								.request(MediaType.APPLICATION_JSON_TYPE)
								.get();
		if (response.getStatus() == 200) {
			
			Cliente cli = response.readEntity(Cliente.class);
			System.out.println(cli.getNome());
			
		} else {
			
			System.out.println("Cliente nao existe");
		}
		
	}

}
