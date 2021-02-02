package twitter;

import exemplos_adilson.*;

public final class Tweet {

	private int id;
	private String text;
	
	public Tweet() {
		
	}
	
	public Tweet(int id, String nome) {
		super();
		this.id = id;
		this.text = nome;
	}
          

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
