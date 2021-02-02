package twitter.model;

public class Usuario {
    private String id;
    private String name;
    private String username;
    private String created_at;

    public Usuario() {
    }

    public Usuario(String id, String name, String username, String created_at) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.created_at = created_at;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
