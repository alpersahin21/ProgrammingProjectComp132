package ObjectClasses;


import java.time.LocalDateTime;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class Content {
	// declaring instance variables
	private static HashMap<String,Content> contents = new HashMap<>();
	private String title;
	private String authorNickname;
	private String text;
	private final String type;
	private ImageIcon image;
	private LocalDateTime creationTime;
	
	// Declaring overloaded constructors.
	public Content(String title, String authorNickname, String text) {
		this.type = "0";
		this.title = title;
		this.authorNickname = authorNickname;
		this.text = text;
		this.creationTime = LocalDateTime.now();
		Content.contents.put(this.getTitle(),this);
	}
	public Content(String title, String authorNickname, ImageIcon image){
		this.type = "1";
		this.title = title;
		this.authorNickname = authorNickname;

		this.image = image;
		this.creationTime = LocalDateTime.now();
		Content.contents.put(this.getTitle(),this);
	}
	public Content(String title, String authorNickname, String text, ImageIcon image) {
		this.type = "2";
		this.title = title;
		this.authorNickname = authorNickname;
		this.text = text;
		this.image = image;
		this.creationTime = LocalDateTime.now();
		Content.contents.put(this.getTitle(),this);
	}
	
	//getters and setters.
	
	
	public String getTitle() {
		return title;
	}
	public String getType() {
		return type;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthorNickname() {
		return authorNickname;
	}
	public void setAuthorNickname(String authorNickname) {
		this.authorNickname = authorNickname;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	public static HashMap<String, Content> getContents() {
		return contents;
	}
	public static void setContents(HashMap<String, Content> contents) {
		Content.contents = contents;
	}
	@Override
	public String toString() { // toString method.
		return title;
	}
	
	
	
	
	

}
