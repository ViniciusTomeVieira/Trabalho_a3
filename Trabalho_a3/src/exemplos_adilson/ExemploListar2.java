package exemplos_adilson;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class ExemploListar2 {

	public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/ws");
		WebTarget resourceWebTarget = webTarget.path("cliente");
		WebTarget pathdWebTargetQuery = resourceWebTarget.path("listar2");
		Invocation.Builder invocationBuilder = pathdWebTargetQuery.request(MediaType.APPLICATION_XML_TYPE);
		List<Cliente> cs = invocationBuilder.get(new GenericType<List<Cliente>>() {});
		
	    for (Cliente c:cs) {
	    	System.out.println(c);
	    }
	}
}
