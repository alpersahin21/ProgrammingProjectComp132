package ObjectClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class Group {
	// instance variables
	
	private static HashMap<String,Group> groups = new HashMap<>();
	private String name;
	private String country;
	private final User owner;
	private ArrayList<String> hobbies;
	private ArrayList<User> users;
	private ArrayList<Content> contents;
	
	// Constructor
	
	public Group(String name, String country, User owner) {

		this.name = name;
		this.country = country;
		this.owner = owner;
		hobbies = new ArrayList<String>();
		users = new ArrayList<User>();
		contents = new ArrayList<Content>();
		Group.addGroups(this); // add group to static group map
		this.getUsers().add(owner); // add owner to groups user list
		owner.getUserGroups().add(this); // ad group to groups user list
		
	}

   // getters and setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public User getOwner() {
		return owner;
	}


	public ArrayList<String> getHobbies() {
		return hobbies;
	}


	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}


	public ArrayList<User> getUsers() {
		return users;
	}


	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}


	public ArrayList<Content> getContents() {
		return contents;
	}


	public void setContents(ArrayList<Content> contents) {
		this.contents = contents;
	}
	
	
	public static HashMap<String,Group> getGroups() {
		return groups;
	}


	public static void setGroups(HashMap<String,Group> groups) {
		Group.groups = groups;
	}

  // Method to add hobbie
	public void addHobbies(String hobbie) {
		this.getHobbies().add(hobbie);
	}
	// Method to remove hobbie
	public void removeHobbies(String hobbie) {
		this.getHobbies().remove(hobbie);
	}
	
	// Method to add user
	public void addUsers(User user) {
		this.getUsers().add(user);
	}
	// Method to remove user
	public void removeUsers(User user) {
		this.getUsers().remove(user);
	}
	
	// Method to add content
	
	public void addContents(Content c) {
		this.getContents().add(c);
	}
	// Method to remvoe content
	
	public void removeContents(Content c) {
		this.getContents().remove(c);
	}
	
	// Method to add group
	public static void addGroups(Group g) {
		Group.groups.put(g.getName(),g);
	}
	
	// Method to remove group
	
	public static void removeGroups(Group g) {
		Group.groups.remove(g.getName(),g);
		
	}

	// Method toString
	@Override
	public String toString() {
		return name;
	}	
	
	
	
}
