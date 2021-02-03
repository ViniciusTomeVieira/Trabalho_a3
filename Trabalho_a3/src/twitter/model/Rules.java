package twitter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe modelo de Rules
 */
public class Rules {
    List<Rule> add;

    public Rules() {
        add = new ArrayList<>();
    }

    public Rules(List<Rule> add) {
        this.add = add;
    }

    public List<Rule> getAdd() {
        return add;
    }

    public void setAdd(List<Rule> add) {
        this.add = add;
    }
}
