package twitter.model;

import java.util.ArrayList;
import java.util.List;

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
