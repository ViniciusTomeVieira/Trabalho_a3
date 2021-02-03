package twitter.model;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe modelo de Rule
 */
public class Rule {
    private String value;
    private String tag;

    public Rule() {
    }

    public Rule(String value, String tag) {
        this.value = value;
        this.tag = tag;
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
}
