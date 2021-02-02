package twitter.model;

import java.util.List;

public class RulesResponse {
    List<RuleResponse> data;

    public RulesResponse(List<RuleResponse> data) {
        this.data = data;
    }

    public RulesResponse() {
    }

    public List<RuleResponse> getData() {
        return data;
    }

    public void setData(List<RuleResponse> data) {
        this.data = data;
    }
}
