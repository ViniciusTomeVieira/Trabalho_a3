package twitter.model;

import java.util.List;
/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public class Usuarios {
    private List<Usuario> data;

    public Usuarios() {
    }

    public Usuarios(List<Usuario> data) {
        this.data = data;
    }

    public List<Usuario> getData() {
        return data;
    }

    public void setData(List<Usuario> data) {
        this.data = data;
    }
}
