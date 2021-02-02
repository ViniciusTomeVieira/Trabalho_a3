package twitter.controller;

import twitter.apiAccess.TweetsGET;
import twitter.apiAccess.UsuarioGET;
import twitter.model.Tweets;
import twitter.model.Usuario;
import twitter.model.Usuarios;
import twitter.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import twitter.model.Tweet;

public class Gerenciador {
    private static Gerenciador instance;
    private List<Observer> observadores = new ArrayList<>();
    private Usuarios usuarios;
    private Tweets tweets;
    private UsuarioGET usuarioGET;
    private TweetsGET tweetsGET;

    private Gerenciador() {
        usuarioGET = new UsuarioGET();
        tweetsGET = new TweetsGET();
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

    public void buscarTweetByUsername(String username, int qntTweets) {
        if (qntTweets >= 5 && qntTweets <= 100) {
            try {

                usuarios = usuarioGET.getUsuarioByUsername(username);
                for (Observer obs : observadores) {
                    obs.AchouUsuario(true);
                }
            } catch (Exception e) {
                for (Observer obs : observadores) {
                    obs.AchouUsuario(false);
                }
            }
                if (usuarios != null) {                
                    for (Usuario u : usuarios.getData()) {
                        try {
                            tweets = tweetsGET.getTweetByUsuarioID(u.getId(), qntTweets);
                            for (Observer obs : observadores) {
                                obs.AchouTweets(true);
                            }
                        } catch (Exception exception) {
                            for (Observer obs : observadores) {
                                obs.AchouTweets(false);
                            }
                        }
                    }
                }           
        } else {
            for (Observer obs : observadores) {
                obs.qntTweetsInvalido();
            }
        }
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public Tweets getTweets() {
        return tweets;
    }

}
