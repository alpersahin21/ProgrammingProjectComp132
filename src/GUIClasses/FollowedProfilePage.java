package GUIClasses;


import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import ObjectClasses.Content;
import ObjectClasses.Group;
import ObjectClasses.User;

// class followedprofilepage extends jframe implements actionlistener

public class FollowedProfilePage extends JFrame implements ActionListener {
	
	// instance variables
	
	private HashMap<String,JFrame> OtherFrames = new HashMap<>(); // map other frames to return homepage
	private User ActiveUser; // user logged in
	private User ProfileOwner; // user whose profile is looked at
	
	// frame components
	
	private JLabel profileTitle; 
	private JLabel ppLabel; 
	private JLabel nicknameLabel;
	private JLabel realnameLabel;
	private JLabel surnameLabel;
	private JLabel accTypeLabel;
	private JLabel friendsLabel;
	private JScrollPane friendscrollPane;
	private JPanel friendListPanel;
	private JLabel groupsLabel;
	private JScrollPane groupscrollPane;
	private JPanel groupListPanel;
	private JLabel postsLabel;
	private JScrollPane postscrollPane;
	private JPanel postListPanel;
	private JButton unfollowButton;
	private JButton goBackButton;
	
	// getters and setters
	
	public User getActiveUser() {
		return ActiveUser;
	}



	public void setActiveUser(User activeUser) {
		ActiveUser = activeUser;
	}



	public User getProfileOwner() {
		return ProfileOwner;
	}



	public void setProfileOwner(User profileOwner) {
		ProfileOwner = profileOwner;
	}



	public HashMap<String, JFrame> getOtherFrames() {
		return OtherFrames;
	}



	public void setOtherFrames(HashMap<String, JFrame> otherFrames) {
		OtherFrames = otherFrames;
	}
	
	public void addOtherFrames(String name,JFrame j) {
		this.getOtherFrames().put(name, j);
	}
	// construcor
	
	public FollowedProfilePage(User active, User owner) {
		this.ActiveUser = active;
		this.ProfileOwner = owner;
		initialize();
	}
	
	// Method to resize image to its panel size.
	
	private ImageIcon imageScale(ImageIcon i) {
		Image scaler = i.getImage();
		Image scaling = scaler.getScaledInstance(177, 141, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaled = new ImageIcon(scaling);
		return scaled;
		
	}
	// Method display content iterating contents profile user has and instantiating frame components.
	
	public void displayContents() {
		if (this.getProfileOwner().getUserContents().isEmpty()==false) {
			for (Content c : this.getProfileOwner().getUserContents()) {
				if (c.getType().equals("0")) {
					JLabel contentTitle = new JLabel(c.getTitle());
					JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
					JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
					JLabel contentText = new JLabel(c.getText());
					JLabel Lgap = new JLabel("=====================");
					postListPanel.add(contentTitle);
					postListPanel.add(contentAuthor);
					postListPanel.add(contentDate);
					postListPanel.add(contentText);
					postListPanel.add(Lgap);
					
				}
				else if (c.getType().equals("1")) {
					JLabel contentTitle = new JLabel(c.getTitle());
					JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
					JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
					JLabel contentImage = new JLabel();
					JLabel Lgap = new JLabel("=====================");
					contentImage.setIcon(imageScale(c.getImage()));
					postListPanel.add(contentTitle);
					postListPanel.add(contentAuthor);
					postListPanel.add(contentDate);
					postListPanel.add(contentImage);
					postListPanel.add(Lgap);
					
				}
				else {
					JLabel contentTitle = new JLabel(c.getTitle());
					JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
					JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
					JLabel contentText = new JLabel(c.getText());
					JLabel contentImage = new JLabel();
					JLabel Lgap = new JLabel("=====================");
					contentImage.setIcon(imageScale(c.getImage()));
					postListPanel.add(contentTitle);
					postListPanel.add(contentAuthor);
					postListPanel.add(contentDate);
					postListPanel.add(contentText);
					postListPanel.add(contentImage);
					postListPanel.add(Lgap);
					
					// calling Content constructor from type.
				}
			}
		}
		
	}
	
	// method to add a friend to jpanel friend panel.
	
	public void addFriends (JPanel p) {
		for (User u : this.getProfileOwner().getFollowedUsers()) {
			JLabel friendLabel = new JLabel(u.getNickname());
			friendLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(friendLabel);
		}
		
	}
	// method to add a group name to jpanel group panel
	
	public void addGroups (JPanel p) {
		for (Group g : this.getProfileOwner().getUserGroups()) {
			JLabel groupLabel = new JLabel(g.getName());
			groupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(groupLabel);
			
		}
	}
	
	// method to instantiate JFrame Components.
	private void initialize() {

		this.setResizable(false);
		this.setBounds(100, 100, 697, 521);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		profileTitle = new JLabel("Profile Of " + ProfileOwner.getNickname());
		profileTitle.setHorizontalAlignment(SwingConstants.CENTER);
		profileTitle.setBounds(187, 18, 334, 16);
		this.getContentPane().add(profileTitle);
		
		ppLabel = new JLabel();
		ppLabel.setBounds(65, 64, 190, 193);
		ppLabel.setIcon(imageScale(this.getProfileOwner().getProfilePhoto()));
		this.getContentPane().add(ppLabel);
		
		nicknameLabel = new JLabel("Nickname:   " + ProfileOwner.getNickname());
		nicknameLabel.setBounds(65, 291, 190, 16);
		this.getContentPane().add(nicknameLabel);
		
		realnameLabel = new JLabel("Name:   " + ProfileOwner.getName());
		realnameLabel.setBounds(65, 319, 190, 16);
		this.getContentPane().add(realnameLabel);
		
		surnameLabel = new JLabel("Surname:   " + ProfileOwner.getSurname());
		surnameLabel.setBounds(65, 347, 190, 16);
		this.getContentPane().add(surnameLabel);
		
		String accType = "";
		if (ProfileOwner.isPremium()) {
			accType = "Premium";
		}
		else {
			accType = "Basic";
		}
		
		accTypeLabel = new JLabel("Account Type:   " + accType);
		accTypeLabel.setBounds(65, 375, 190, 16);
		this.getContentPane().add(accTypeLabel);
		
		friendsLabel = new JLabel("Friends");
		friendsLabel.setBounds(355, 64, 61, 16);
		this.getContentPane().add(friendsLabel);
		
		friendscrollPane = new JScrollPane();
		friendscrollPane.setBounds(293, 92, 177, 141);
		this.getContentPane().add(friendscrollPane);
		
		friendListPanel = new JPanel();
		friendscrollPane.setViewportView(friendListPanel);
		friendListPanel.setLayout(new BoxLayout(friendListPanel, BoxLayout.Y_AXIS));
		addFriends(friendListPanel);
		
		
		groupsLabel = new JLabel("Groups");
		groupsLabel.setBounds(559, 64, 61, 16);
		this.getContentPane().add(groupsLabel);
		
		groupscrollPane= new JScrollPane();
		groupscrollPane.setBounds(497, 92, 177, 141);
		this.getContentPane().add(groupscrollPane);
		
		groupListPanel = new JPanel();
		groupscrollPane.setViewportView(groupListPanel);
		groupListPanel.setLayout(new BoxLayout(groupListPanel, BoxLayout.Y_AXIS));
		addGroups(groupListPanel);
		
		
		postsLabel = new JLabel("Posts");
		postsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		postsLabel.setBounds(460, 245, 61, 16);
		this.getContentPane().add(postsLabel);
		
		postscrollPane = new JScrollPane();
		postscrollPane.setBounds(294, 266, 380, 181);
		this.getContentPane().add(postscrollPane);
		
		postListPanel = new JPanel();
		postscrollPane.setViewportView(postListPanel);
		postListPanel.setLayout(new BoxLayout(postListPanel, BoxLayout.Y_AXIS));
		displayContents();
		
		
		unfollowButton = new JButton("Unfollow");
		unfollowButton.setBounds(89, 443, 117, 29);
		unfollowButton.addActionListener(this);
		this.getContentPane().add(unfollowButton);
	
		
		goBackButton = new JButton("Go Back");
		goBackButton.setBounds(557, 13, 117, 29);
		goBackButton.addActionListener(this);
		this.getContentPane().add(goBackButton);
	}
	
	
	

	
	
	// action listener methods
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(goBackButton)) { // going back to homepage by creating a homepage class to display new content and setting it visible
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
		}
		else if (evt.getSource().equals(unfollowButton)) { // method to unfollow looked profile to unfollow it and then return to a new fresh homepage frame.
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
		}
		
	}

}
