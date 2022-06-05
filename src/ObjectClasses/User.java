package ObjectClasses;

import javax.swing.ImageIcon;

import GUIClasses.LoginPage;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	
	// declaring instance variables
	private static HashMap<String,User> Users = new HashMap<>();
	private String nickname;
	private String password;
	private String name;
	private String surname;
	private String age;
	private String email;
	private ImageIcon profilePhoto;
	private ArrayList<String> hobbies;
	private ArrayList<User> followedUsers;
	private Boolean premium;
	private ArrayList<Content> userContents;
	private ArrayList<Group> userGroups;
	
	
	

	// constructor without hobbies
	public User(String nickname, String password, String name, String surname, String age, String email) {

		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.email = email;
		premium = false; // premium set to false by default.
		hobbies = new ArrayList<String>(); // Initialize hobbies ArrayList.
		followedUsers = new ArrayList<User>(); //Initialize followedUsers ArrayList.
		userContents = new ArrayList<Content>(); // Initialize userContents ArrayList.
		userGroups = new ArrayList<Group>(); // Initialize userGroups ArrayList.
		profilePhoto = new ImageIcon("default.png"); // Initializing default profile photo.
		LoginPage.getUserDB().put(this.nickname, this.password);
		User.getUsers().put(nickname, this);
		
	}

	// Getters and Setters.
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public ArrayList<User> getFollowedUsers() {
		return followedUsers;
	}

	public void setFollowedUsers(ArrayList<User> followedUsers) {
		this.followedUsers = followedUsers;
	}

	// method to check if user is premium user or not.
	public Boolean isPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
		
	}
	

	public ArrayList<Content> getUserContents() {
		return userContents;
	}

	public void setUserContents(ArrayList<Content> userContents) {
		this.userContents = userContents;
	}
	
	
	public ArrayList<Group> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(ArrayList<Group> userGroups) {
		this.userGroups = userGroups;
	}
	
	public ImageIcon getProfilePhoto() {
		return this.profilePhoto;
	}
	
	public void setProfilePhoto(ImageIcon profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	
	

	public static HashMap<String, User> getUsers() {
		return Users;
	}

	public static void setUsers(HashMap<String, User> users) {
		Users = users;
	}
	// Method to add users to static user list
	
	public static void addUsers(User u) {
		User.getUsers().put(u.getNickname(), u);
	}
	// Method to follow a user
	
	public Boolean follows(User u) {
		if (this.getFollowedUsers().contains(u)) {
			return true;
		}
			
		return false;
	}
	
	public void addHobbie(String hobbie) { // Method to add a hobie to a user.
		this.getHobbies().add(hobbie);
	}
	public void removeHobbie(String hobbie) { // Method to remove hobbie
		this.getHobbies().remove(hobbie);
	}
	public void follow(User u) {  // Method to follow a user i.e. adding them to followedUsers array list.
		
		this.getFollowedUsers().add(u); 
			
		
	}
	public void unfollow(User u) { // Method to unfollow a user i.e. removing them from followedUsers array list.
		
		this.getFollowedUsers().remove(u); 
		
	}
	
	
	public void addContent(Content c) { // Method to add a new content to users contents ArrayList.
		this.getUserContents().add(c);
		Content.getContents().put(c.getTitle(), c);
	}
	
	public void removeContent(Content c) { // Method to remove a content from users contents ArrayList.
		this.getUserContents().remove(c);
		Content.getContents().remove(c.getTitle());
	}
	
	public void joinGroup(Group g) { // Method to add a group to users groups ArrayList.
		this.getUserGroups().add(g);
		g.addUsers(this);
	}
	public void leaveGroup(Group g) { // Method to remove a group to users groups ArrayList.
		this.getUserGroups().remove(g);
		g.removeUsers(this);
	}
	public void tryRemoveGroup(Group g) { // Method if there is a group remove a group
		if (this.getUserGroups().contains(g)) {
			this.getUserGroups().remove(g);
			g.removeUsers(this);
		}
	}
	
	
	public Boolean isMemberOf(Group g) { // Method returning if user is member of a group
		for (Group group : this.getUserGroups()) {
			if (group.equals(g)) {
				return true;
			}
		}
		return false;
	}
	public Boolean isOwnerOf(Group g) { // Method returning if user is owner of the group
		return g.getOwner().equals(this);
	}
	
	
	// Method toString

	@Override
	public String toString() {
		return nickname;
	}
	
}
