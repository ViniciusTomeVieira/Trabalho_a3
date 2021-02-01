package exemplos_adilson;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class ExemploListar {

	public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ws");
		WebTarget resourceWebTarget = webTarget.path("cliente");
		WebTarget pathdWebTargetQuery = resourceWebTarget.path("listar");
		Invocation.Builder invocationBuilder = pathdWebTargetQuery.request(MediaType.APPLICATION_JSON_TYPE);
		List<Cliente> clientes = invocationBuilder.get(new GenericType<List<Cliente>>() {});

	    for (Cliente c:clientes) {
	    	System.out.println(c);
	    }

	}
	
}
