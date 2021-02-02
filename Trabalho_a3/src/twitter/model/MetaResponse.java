package twitter.model;

public class MetaResponse {
    private String sent;
    private String summary;

    public MetaResponse(String sent, String summary) {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
