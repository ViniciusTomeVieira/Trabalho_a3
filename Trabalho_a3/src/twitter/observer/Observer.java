package twitter.observer;
/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Interface do padrão de projeto Observer
 */
public interface Observer {

    void qntTweetsInvalido();

    void AchouUsuario(boolean b);

    void AchouTweets(boolean b);

    void regraAdicionada(boolean b);
}
