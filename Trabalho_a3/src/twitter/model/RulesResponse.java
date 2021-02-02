package twitter.model;

import java.util.List;

public class RulesResponse {
    private List<RuleResponse> data;
    private MetaResponse meta;

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
