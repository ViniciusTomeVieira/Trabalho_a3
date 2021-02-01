package twitter;

import exemplos_adilson.Cliente;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExemploGetTwitter {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("https://api.apitore.com/api/23/twitter");
		
		Cliente c = webTarget.path("mytimeline")
							.request(MediaType.APPLICATION_JSON_TYPE)
							.get()
							.readEntity(Cliente.class);
		
		System.out.println(c.getNome());
		
		// outra forma
		
		
	}

}
