package twitter.model;

import java.util.List;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe modelo de RulesResponse (Rules)
 */
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

    public MetaResponse getMeta() {
        return meta;
    }

    public void setMeta(MetaResponse meta) {
        this.meta = meta;
    }
    
    
}
