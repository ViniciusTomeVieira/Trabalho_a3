package twitter.model;

/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class Summary {
    private int created;
    private int not_created;
    private int valid;
    private int invalid;

    public Summary(int created, int not_created, int valid, int invalid) {
        this.created = created;
        this.not_created = not_created;
        this.valid = valid;
        this.invalid = invalid;
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

    public int getInvalid() {
        return invalid;
    }

    public void setInvalid(int invalid) {
        this.invalid = invalid;
    }

    
}
