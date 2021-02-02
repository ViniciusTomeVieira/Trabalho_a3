package twitter.model;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class MetaResponse {
    private String sent;
    private Summary summary;

    public MetaResponse(String sent, Summary summary) {
        this.sent = sent;
        this.summary = summary;
    }

    public MetaResponse() {
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }
}
