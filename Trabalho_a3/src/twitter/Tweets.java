/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import java.util.List;

/**
 *
 * @author vinny
 */
public class Tweets {
    private List<Tweet> data;

    public Tweets() {
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
