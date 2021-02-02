package twitter.model;


/**
 * @author Vinícius & Adroan
 * @version 1.0
 * Classe resposável pela tela inicial do sistema
 */
public final class Tweet {

	private String id;
	private String text;
	
	public Tweet() {
		
	}
	
	public Tweet(String id, String nome) {
		super();
		this.id = id;
		this.text = nome;
	}
          

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String nome) {
		this.text = nome;
	}
	
	@Override
	public String toString() {
		return "Cliente " + id + " " + text;
	}
	
}
