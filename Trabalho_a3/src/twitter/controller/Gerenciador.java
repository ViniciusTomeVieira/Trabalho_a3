package twitter.controller;

import twitter.apiAccess.TweetsGET;
import twitter.apiAccess.UsuarioGET;
import twitter.model.Tweets;
import twitter.model.Usuario;
import twitter.model.Usuarios;
import twitter.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private static Gerenciador instance;
    private List<Observer> observadores = new ArrayList<>();
    private Usuarios usuarios;
    private Tweets tweets;
    private UsuarioGET usuarioGET;
    private TweetsGET tweetsGET;

    private Gerenciador() {
    }
    //Singleton
    public static synchronized Gerenciador Gerenciador() {
        if (instance == null) {
            instance = new Gerenciador();
        }
        return instance;
    }

    public void addObservador(Observer obs) {
        observadores.add(obs);
    }

    public void buscarTweetByUsername(String username, int qntTweets) throws Exception {
        if(qntTweets>=5&&qntTweets<=100){
            usuarios = usuarioGET.getUsuarioByUsername(username);
            if(usuarios!=null) {
                for (Usuario u : usuarios.getData()) {
                    tweets = tweetsGET.getTweetByUsuarioID(u.getId(), qntTweets);
                }
            }
        }else{
            throw new Exception("Valor inválido");
        }
    }
}
