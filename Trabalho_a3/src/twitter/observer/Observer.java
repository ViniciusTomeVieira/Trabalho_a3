package twitter.observer;
/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public interface Observer {

    void qntTweetsInvalido();

    void AchouUsuario(boolean b);

    void AchouTweets(boolean b);

    void regraAdicionada(boolean b);
}
