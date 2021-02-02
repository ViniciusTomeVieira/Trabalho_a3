package twitter.model;

public class Summary {
    private int created;
    private int not_created;
    private int valid;
    private int not_valid;

    public Summary(int created, int not_created, int valid, int not_valid) {
        this.created = created;
        this.not_created = not_created;
        this.valid = valid;
        this.not_valid = not_valid;
    }

    public Summary() {
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getNot_created() {
        return not_created;
    }

    public void setNot_created(int not_created) {
        this.not_created = not_created;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public int getNot_valid() {
        return not_valid;
    }

    public void setNot_valid(int not_valid) {
        this.not_valid = not_valid;
    }
}
