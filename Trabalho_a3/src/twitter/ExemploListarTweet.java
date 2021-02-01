package twitter;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class ExemploListarTweet {

	public static void main(String[] args) throws Exception {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("https://api.apitore.com/api/23/twitter");
		WebTarget resourceWebTarget = webTarget.path("mytimeline");
		Invocation.Builder invocationBuilder = resourceWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
		//List<Cliente> clientes = invocationBuilder.get(new GenericType<List<Cliente>>() {});
                System.out.println(invocationBuilder);
	    //for (Cliente c:clientes) {
	    	//System.out.println(c);
	    //}

	}
	
}
