package twitter.model;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class RuleResponse {
    private String value;
    private String tag;
    private String id;

    public RuleResponse() {
    }

    public RuleResponse(String value, String tag, String id) {
        this.value = value;
        this.tag = tag;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
