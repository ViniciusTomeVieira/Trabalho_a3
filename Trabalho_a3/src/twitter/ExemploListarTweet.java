package twitter;
import twitter.apiAccess.TweetsGET;
import twitter.apiAccess.UsuarioGET;
import twitter.model.Tweet;
import twitter.model.Tweets;
import twitter.model.Usuario;
import twitter.model.Usuarios;


public class ExemploListarTweet {

    public static void main(String[] args) throws Exception {
        TweetsGET tweetsGET = new TweetsGET();
        UsuarioGET usuarioGET = new UsuarioGET();

        Usuarios usu = usuarioGET.getUsuarioByUsername("DolarBipolar");

        for(Usuario u: usu.getData()) {
            Tweets tws = tweetsGET.getTweetByUsuarioID(u.getId(), 100);

            System.out.println(u.getName());
            for (Tweet t : tws.getData()) {
                System.out.println(t.getText());
            }
        }
    }
}