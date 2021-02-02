package twitter.controller;

import twitter.apiAccess.RulesPOST;
import twitter.apiAccess.TweetsGET;
import twitter.apiAccess.UsuarioGET;
import twitter.model.*;
import twitter.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class Gerenciador {
    private static Gerenciador instance;
    private List<Observer> observadores = new ArrayList<>();
    private Usuarios usuarios;
    private Tweets tweets;
    private RulesResponse rulesResponse;
    private UsuarioGET usuarioGET;
    private TweetsGET tweetsGET;
    private RulesPOST rulesPOST;

    private Gerenciador() {
        usuarioGET = new UsuarioGET();
        tweetsGET = new TweetsGET();
        rulesPOST = new RulesPOST();
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
    
    public void removeObservador(Observer obs){
        observadores.remove(obs);
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

    public void criarRule(String value, String tag){
        Rules rules = new Rules();
        rules.getAdd().add(new Rule(value, tag));
        try {
            rulesResponse = rulesPOST.setRules(rules);
            for (Observer obs : observadores) {
                obs.regraAdicionada(true);
            }
        } catch (Exception e) {
            for (Observer obs : observadores) {
                obs.regraAdicionada(false);
            }
        }
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public Tweets getTweets() {
        return tweets;
    }

    public RulesResponse getRulesResponse() {
        return rulesResponse;
    }

    public void setRulesResponse(RulesResponse rulesResponse) {
        this.rulesResponse = rulesResponse;
    }
    

}
