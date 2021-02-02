/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.model;

import java.util.List;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class Tweets {
    private List<Tweet> data;
    private Meta meta;

    public Tweets() {
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    
    public Tweets(List<Tweet> data) {
        this.data = data;
    }
    
    public List<Tweet> getData() {
        return data;
    }

    public void setData(List<Tweet> data) {
        this.data = data;
    }
    
    
}
