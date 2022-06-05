package GUIClasses;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import ObjectClasses.User;
import ObjectClasses.Content;
import ObjectClasses.Group;

// Self profile page accessed when users press myProfile button in their profile page.
public class SelfProfilePage extends JFrame implements ActionListener{
	
	// instance variables
	private HashMap<String,JFrame> OtherFrames = new HashMap<>();
	private User ActiveUser;

	// Jframe components.
	private JLabel titleLabel;
	private JLabel ppLabel; 
	private JLabel usernameLabel;
	private JLabel nameLabel;
	private JLabel surnameLabel;
	private JLabel ageLabel; 
	private JLabel emailLabel;
	private JLabel accTypeLabel;
	private JButton nameEditButton; 
	private JButton surnameEditButton; 
	private JButton ageEditButton;
	private JButton emailEditButton; 
	private JButton signOutButton; 
	private JButton delAccButton;
	private JLabel myFriendsLabel; 
	private JScrollPane friendScrollPane; 
	private JLabel myGroupsLabel; 
	private JScrollPane groupScrollPane; 
	private JLabel myPostsLabel; 
	private JScrollPane postScrollPane;
	private JButton ppEditButton; 
	private JButton postCreateButton; 
	private JButton groupCreateButton; 
	private JButton suggestUserButton; 
	private JButton suggestGroupButton; 
	private JButton goHomepageButton;
	private JPanel friendListPanel;
	private JPanel groupListPanel;
	private JPanel postListPanel;
	private JButton editPostButton;
	private JButton postDeleteButton;
	
	// Image resizor
	
	private ImageIcon imageScale(ImageIcon i) {
		Image scaler = i.getImage();
		Image scaling = scaler.getScaledInstance(242, 198, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaled = new ImageIcon(scaling);
		return scaled;
		
	}
	// displaying user contents to the posts JLabel same in Homepage user posts label display contents method.
	private void displayUserContents() {
		for(Content c : this.getActiveUser().getUserContents()) {
			
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
					postListPanel.add(Lgap);
					
					
				}
		}
	}
		
	// Constructor
	public SelfProfilePage(User u) {
		this.ActiveUser = u;
		initialize();
	}

	// getters and setters
	public HashMap<String, JFrame> getOtherFrames() {
		return OtherFrames;
	}




	public void addOtherFrames(String name, JFrame frame) {
		OtherFrames.put(name, frame);
	}




	public User getActiveUser() {
		return ActiveUser;
	}




	public void setActiveUser(User activeUser) {
		this.ActiveUser = activeUser;
	}



	// JFrame component initializor.
	private void initialize() {

		this.setResizable(false);
		this.setBounds(100, 100, 857, 582);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		titleLabel = new JLabel("My Profile");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(339, 6, 142, 35);
		this.getContentPane().add(titleLabel);
		
		ppLabel = new JLabel();
		ppLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ppLabel.setBounds(86, 35, 144, 143);
		ppLabel.setIcon(imageScale(this.getActiveUser().getProfilePhoto()));
		this.getContentPane().add(ppLabel);
		
		usernameLabel = new JLabel("Nickname: " + this.getActiveUser().getNickname());
		usernameLabel.setBounds(86, 204, 173, 16);
		this.getContentPane().add(usernameLabel);
		
		nameLabel = new JLabel("Name: "+ this.getActiveUser().getName());
		nameLabel.setBounds(86, 232, 173, 16);
		this.getContentPane().add(nameLabel);
		
		surnameLabel = new JLabel("Surname: " + this.getActiveUser().getSurname());
		surnameLabel.setBounds(86, 260, 173, 16);
		this.getContentPane().add(surnameLabel);
		
		ageLabel = new JLabel("Age:   " + this.getActiveUser().getAge());
		ageLabel.setBounds(86, 288, 173, 16);
		this.getContentPane().add(ageLabel);
		
		emailLabel = new JLabel("E-mail: " + this.getActiveUser().getEmail());
		emailLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		emailLabel.setBounds(86, 316, 173, 16);
		this.getContentPane().add(emailLabel);
		
		String accType = "";
		if (this.getActiveUser().isPremium()) {
			accType = "Premium";
		}
		else {
			accType = "Basic";
		}
		
		accTypeLabel = new JLabel("Account Type: "+ accType);
		accTypeLabel.setBounds(86, 344, 173, 16);
		this.getContentPane().add(accTypeLabel);
		
		
		nameEditButton = new JButton("Edit");
		nameEditButton.setBounds(5, 227, 69, 29);
		nameEditButton.addActionListener(this);
		this.getContentPane().add(nameEditButton);
		
		surnameEditButton = new JButton("Edit");
		surnameEditButton.setBounds(5, 255, 69, 29);
		surnameEditButton.addActionListener(this);
		this.getContentPane().add(surnameEditButton);
		
		ageEditButton = new JButton("Edit");
		ageEditButton.setBounds(5, 283, 69, 29);
		ageEditButton.addActionListener(this);
		this.getContentPane().add(ageEditButton);
		
		emailEditButton = new JButton("Edit");
		emailEditButton.setBounds(5, 311, 69, 29);
		emailEditButton.addActionListener(this);
		this.getContentPane().add(emailEditButton);
		
		signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(86, 493, 117, 29);
		signOutButton.addActionListener(this);
		this.getContentPane().add(signOutButton);
		
		delAccButton = new JButton("Delete Account");
		delAccButton.setBounds(631, 493, 182, 29);
		delAccButton.addActionListener(this);
		this.getContentPane().add(delAccButton);
		
		myFriendsLabel = new JLabel("My Friends");
		myFriendsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myFriendsLabel.setBounds(242, 98, 142, 16);
		this.getContentPane().add(myFriendsLabel);
		
		friendScrollPane = new JScrollPane();
		friendScrollPane.setBounds(242, 162, 142, 198);
		this.getContentPane().add(friendScrollPane);
		
		friendListPanel = new JPanel();
		friendScrollPane.setViewportView(friendListPanel);
		friendListPanel.setLayout(new BoxLayout(friendListPanel, BoxLayout.Y_AXIS));
		addFriends(friendListPanel);
		
		
		myGroupsLabel = new JLabel("My Groups");
		myGroupsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		myGroupsLabel.setBounds(437, 98, 87, 16);
		this.getContentPane().add(myGroupsLabel);
		
		groupScrollPane = new JScrollPane();
		groupScrollPane.setBounds(423, 162, 130, 198);
		this.getContentPane().add(groupScrollPane);
		
		groupListPanel = new JPanel();
		groupScrollPane.setViewportView(groupListPanel);
		groupListPanel.setLayout(new BoxLayout(groupListPanel, BoxLayout.Y_AXIS));
		addGroups(groupListPanel);
		
		
		myPostsLabel = new JLabel("My Posts");
		myPostsLabel.setBounds(677, 98, 61, 16);
		this.getContentPane().add(myPostsLabel);
		
		postScrollPane = new JScrollPane();
		postScrollPane.setBounds(594, 162, 242, 198);
		this.getContentPane().add(postScrollPane);
		
		postListPanel = new JPanel();
		postScrollPane.setViewportView(postListPanel);
		postListPanel.setLayout(new BoxLayout(postListPanel, BoxLayout.Y_AXIS));
		displayUserContents();
		
		ppEditButton = new JButton("Edit");
		ppEditButton.setBounds(5, 93, 69, 29);
		ppEditButton.addActionListener(this);
		this.getContentPane().add(ppEditButton);
		
		postCreateButton = new JButton("Create a Post");
		postCreateButton.setBounds(660, 372, 117, 29);
		postCreateButton.addActionListener(this);
		this.getContentPane().add(postCreateButton);
		
		groupCreateButton = new JButton("Create Group");
		groupCreateButton.setBounds(433, 372, 117, 29);
		groupCreateButton.addActionListener(this);
		groupCreateButton.setEnabled(this.getActiveUser().isPremium());
		this.getContentPane().add(groupCreateButton);
		
	    suggestUserButton = new JButton("Suggest Users");
		suggestUserButton.setBounds(252, 372, 117, 29);
		suggestUserButton.addActionListener(this);
		this.getContentPane().add(suggestUserButton);
		
		suggestGroupButton = new JButton("Suggest Groups");
		suggestGroupButton.setBounds(423, 425, 130, 29);
		suggestGroupButton.addActionListener(this);
		this.getContentPane().add(suggestGroupButton);
		
		goHomepageButton = new JButton("Go Back ");
		goHomepageButton.setBounds(364, 493, 117, 29);
		goHomepageButton.addActionListener(this);
		this.getContentPane().add(goHomepageButton);
		
		editPostButton = new JButton("Edit Post");
		editPostButton.setBounds(660, 411, 117, 29);
		editPostButton.addActionListener(this);
		if (this.getActiveUser().getUserContents().isEmpty()) {
			editPostButton.setEnabled(false);
		}
		this.getContentPane().add(editPostButton);
		
		postDeleteButton = new JButton("Delete Post");
		postDeleteButton.setBounds(660, 452, 117, 29);
		postDeleteButton.addActionListener(this);
		if (this.getActiveUser().getUserContents().isEmpty()) {
			postDeleteButton.setEnabled(false);
		}
		this.getContentPane().add(postDeleteButton);
		
		
		
	}
	
	// add friends nicknames to frineds label.
	public void addFriends (JPanel p) {
		for (User u : this.getActiveUser().getFollowedUsers()) {
			JLabel friendLabel = new JLabel(u.getNickname());
			friendLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(friendLabel);
		}
		
	}
	// add group names to group label
	public void addGroups (JPanel p) {
		for (Group g : this.getActiveUser().getUserGroups()) {
			JLabel groupLabel = new JLabel(g.getName());
			groupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(groupLabel);
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) { // ActionListener methods
		if (evt.getSource().equals(signOutButton)) { //sigjn out of account and returning to login page.
			
			JOptionPane.showMessageDialog(null, "Signed Out Successfully.","Signed Out",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
			this.dispose();
			this.getOtherFrames().get("Login").setVisible(true);
		}
		else if (evt.getSource().equals(goHomepageButton)) { // go back to the homepage
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
		}
		else if (evt.getSource().equals(nameEditButton)) { // edit the real name
			String newname = JOptionPane.showInputDialog(null, "Enter Name","Name Edit",JOptionPane.QUESTION_MESSAGE);
			if (newname != null) {
				this.ActiveUser.setName(newname);
				this.nameLabel.setText("Name:   " + newname);
				
			}
		}
		else if (evt.getSource().equals(surnameEditButton)) { // edit the real surname
			String newSurname = JOptionPane.showInputDialog(null, "Enter Surame","Surame Edit",JOptionPane.QUESTION_MESSAGE);
			if (newSurname != null) {
				this.ActiveUser.setSurname(newSurname);
				this.surnameLabel.setText("Surname:   " + newSurname);
			}
		}
		else if (evt.getSource().equals(ageEditButton)) {// edit the real age
			String newAge = JOptionPane.showInputDialog(null, "Enter Age","Age Edit",JOptionPane.QUESTION_MESSAGE);
			if (newAge != null) {
				try {
					int test = Integer.parseInt(newAge);
					this.ActiveUser.setAge(newAge);
					this.ageLabel.setText("Age:   " + newAge);
				}
				catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Age must be a number. Please try again.","Error", JOptionPane.ERROR_MESSAGE);
					
				}
			
			}
		}
		else if (evt.getSource().equals(emailEditButton)) { // edit the email
			String newEmail = JOptionPane.showInputDialog(null, "Enter E-mail","E-mail Edit",JOptionPane.QUESTION_MESSAGE);
			if (newEmail != null) {
				this.ActiveUser.setEmail(newEmail);
				this.emailLabel.setText("Email: " + newEmail);
			}
		}
		else if (evt.getSource().equals(ppEditButton)) { // edit profile picture opening a file chooser and make user choose a new profile picture than scaling it and setting i.
			JFileChooser fileChooser = new JFileChooser();
			
			int response = fileChooser.showOpenDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				try {
				File file = fileChooser.getSelectedFile();
                Image picture = ImageIO.read(file);
				Image scaled = picture.getScaledInstance(144, 143, java.awt.Image.SCALE_SMOOTH);
				ImageIcon newPp = new ImageIcon(scaled);
				this.getActiveUser().setProfilePhoto(newPp);
				this.ppLabel.setIcon(newPp);
				
				}
				catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Please select a image of type .png and .jpeg","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if (evt.getSource().equals(delAccButton)) { // Deletting account by removing it from users static list and removing its followers, followed accounts, join groups and made Contents.
			User.getUsers().remove(this.getActiveUser().getNickname());
			for (User u: User.getUsers().values()) {
				if (u.equals(this.getActiveUser())==false) {
					if (u.follows(this.getActiveUser())) {
						u.unfollow(this.getActiveUser());
					}
					
					
				}
			}
			for (Group g: Group.getGroups().values()) {
				this.getActiveUser().tryRemoveGroup(g);
			}
			for (Content c : Content.getContents().values()) {
				if (this.getActiveUser().getUserContents().contains(c)) {
					Content.getContents().remove(c.getTitle());
					this.getActiveUser().getUserContents().remove(c);
					c = null;
				}
			}
			LoginPage.getUserDB().remove(this.getActiveUser().getNickname());
			JOptionPane.showMessageDialog(null, "Deleted Account Succesfully.","Account Deleted",JOptionPane.PLAIN_MESSAGE);
			this.setVisible(false);
			this.dispose();
			this.getOtherFrames().get("Login").setVisible(true);
			
		}
		else if (evt.getSource().equals(groupCreateButton) ) { // Creating a group special to Premium users my getting group info and creating new class group and setting the active user as its owner.
			String name = JOptionPane.showInputDialog(null, "Enter Group Name: ","Group Name",JOptionPane.QUESTION_MESSAGE);
			if (name.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter a name.","Error", JOptionPane.ERROR_MESSAGE);
				
			}
			else if (Group.getGroups().keySet().contains(name)) {
				JOptionPane.showMessageDialog(null, "This group name is taken. Please enter another name.","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				if (name != null) {
					String country = JOptionPane.showInputDialog(null, "Enter Country Name","Country Name",JOptionPane.QUESTION_MESSAGE);
					if (country.equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter a country name.","Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						if (country != null) {
							Group newGroup = new Group(name,country,this.getActiveUser());
							JOptionPane.showMessageDialog(null, "Created Group Succesfully.","Group Created",JOptionPane.PLAIN_MESSAGE);
						}
					}
					
					
				}
				
			}
			
			
			
		}
		else if (evt.getSource().equals(postCreateButton)) { // Creating post same as MemberGroupPage create post event.
			String contentType = JOptionPane.showInputDialog(null, "Please Select Post Type.\n0 for only text\n 1 for only image\n 2 for both text and image","Choose Post Type",JOptionPane.QUESTION_MESSAGE);
			if (contentType != null) {
				if (contentType.equals("0") || contentType.equals("1")|| contentType.equals("2")) {
					String contentTitle = JOptionPane.showInputDialog(null, "Please enter post title.","Choose Post Title",JOptionPane.QUESTION_MESSAGE);
					if (contentTitle != null) {
						if (Content.getContents().keySet().contains(contentTitle)) {
							JOptionPane.showMessageDialog(null, "This title is taken. Please select another title.","Post Title Taken",JOptionPane.ERROR_MESSAGE);
							
						}
						else {
							if (contentType.equals("0")) {
								String contentText = JOptionPane.showInputDialog(null, "Please Enter Post Text.\nNote: empty text is not accepted.","Choose Post Text",JOptionPane.QUESTION_MESSAGE);
								if (contentText != null) {
									if (contentText.equals("")) {
										JOptionPane.showMessageDialog(null, "Post text can not be empty! Please Try Again.","Empty Space",JOptionPane.ERROR_MESSAGE);
										
										
									}
									else {
										Content newContent = new Content(contentTitle,this.getActiveUser().getNickname(),contentText);
										this.getActiveUser().addContent(newContent);
										JOptionPane.showMessageDialog(null, "Created Post Successfully.","Created Post",JOptionPane.PLAIN_MESSAGE);
										JLabel LcontentTitle = new JLabel(newContent.getTitle());
										JLabel LcontentAuthor = new JLabel("Author: "+newContent.getAuthorNickname());
										JLabel LcontentDate = new JLabel("Date: "+newContent.getCreationTime());
										JLabel LcontentText = new JLabel(newContent.getText());
										JLabel Lgap = new JLabel("=====================");
										postListPanel.add(LcontentTitle);
										postListPanel.add(LcontentAuthor);
										postListPanel.add(LcontentDate);
										postListPanel.add(LcontentText);
										postListPanel.add(Lgap);
										postListPanel.add(Lgap);
										this.revalidate();
										this.repaint();
										
									}
								}
							}
							else if(contentType.equals("1")) {
								
								JOptionPane.showMessageDialog(null, "Please Choose a Image.","Post Image",JOptionPane.PLAIN_MESSAGE);
								
								JFileChooser fileChooser = new JFileChooser();
								
								int response = fileChooser.showOpenDialog(null);
								if (response == JFileChooser.APPROVE_OPTION) {
									try {
									File file = fileChooser.getSelectedFile();
					                Image picture = ImageIO.read(file);
									Image scaled = picture.getScaledInstance(242, 198, java.awt.Image.SCALE_SMOOTH);
									ImageIcon contentImage = new ImageIcon(scaled);
									
									Content newContent = new Content(contentTitle,this.getActiveUser().getNickname(),contentImage);
									this.getActiveUser().addContent(newContent);
									JOptionPane.showMessageDialog(null, "Created Post Successfully.","Created Post",JOptionPane.PLAIN_MESSAGE);
									JLabel LcontentTitle = new JLabel(newContent.getTitle());
									JLabel LcontentAuthor = new JLabel("Author: "+newContent.getAuthorNickname());
									JLabel LcontentDate = new JLabel("Date: "+newContent.getCreationTime());
									JLabel LcontentImage = new JLabel();
									JLabel Lgap = new JLabel("=====================");
									LcontentImage.setIcon(newContent.getImage());
									postListPanel.add(LcontentTitle);
									postListPanel.add(LcontentAuthor);
									postListPanel.add(LcontentDate);
									postListPanel.add(LcontentImage);
									postListPanel.add(Lgap);
									postListPanel.add(Lgap);
									this.revalidate();
									this.repaint();
									
									}
									catch (IOException ex) {
										JOptionPane.showMessageDialog(null, "Please select a image of type .png and .jpeg","Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								
							}
							else {
								String contentText = JOptionPane.showInputDialog(null, "Please Enter Post Text.\nNote: empty text is not accepted.","Choose Post Text",JOptionPane.QUESTION_MESSAGE);
								if (contentText != null) {
									if (contentText.equals("")) {
										JOptionPane.showMessageDialog(null, "Post text can not be empty! Please Try Again.","Empty Space",JOptionPane.ERROR_MESSAGE);
										
										
									}
									else {
										JOptionPane.showMessageDialog(null, "Please Choose a Image.","Post Image",JOptionPane.PLAIN_MESSAGE);
										
										JFileChooser fileChooser = new JFileChooser();
										
										int response = fileChooser.showOpenDialog(null);
										if (response == JFileChooser.APPROVE_OPTION) {
											try {
											File file = fileChooser.getSelectedFile();
							                Image picture = ImageIO.read(file);
											Image scaled = picture.getScaledInstance(242, 198, java.awt.Image.SCALE_SMOOTH);
											ImageIcon contentImage = new ImageIcon(scaled);
											
											Content newContent = new Content(contentTitle,this.getActiveUser().getNickname(),contentText,contentImage);
											this.getActiveUser().addContent(newContent);
											JOptionPane.showMessageDialog(null, "Created Post Successfully.","Created Post",JOptionPane.PLAIN_MESSAGE);
											JLabel LcontentTitle = new JLabel(newContent.getTitle());
											JLabel LcontentAuthor = new JLabel("Author: "+newContent.getAuthorNickname());
											JLabel LcontentDate = new JLabel("Date: "+newContent.getCreationTime());
											JLabel LcontentText = new JLabel(newContent.getText());
											JLabel LcontentImage = new JLabel();
											JLabel Lgap = new JLabel("=====================");
											LcontentImage.setIcon(newContent.getImage());
											postListPanel.add(LcontentTitle);
											postListPanel.add(LcontentAuthor);
											postListPanel.add(LcontentDate);
											postListPanel.add(LcontentText);
											postListPanel.add(LcontentImage);
											postListPanel.add(Lgap);
											postListPanel.add(Lgap);
											this.revalidate();
											this.repaint();
											
											}
											catch (IOException ex) {
												JOptionPane.showMessageDialog(null, "Please select a image of type .png and .jpeg","Error", JOptionPane.ERROR_MESSAGE);
											}
										}
										
										
										
									}
								}
								
								
							}
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter only 0 or 1 or 2.","Wrong Input",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
		else if (evt.getSource().equals(postDeleteButton)) { // Deleting a post same as the MemberGroupPage delete post method
			String contentTitle = JOptionPane.showInputDialog(null, "Please enter title of the post that will be deleted.\nPosts: "+this.getActiveUser().getUserContents(),"Post Deletion",JOptionPane.QUESTION_MESSAGE);
			if (contentTitle != null) {
				if(this.getActiveUser().getUserContents().contains(Content.getContents().get(contentTitle))) {
					this.getActiveUser().getUserContents().remove(Content.getContents().get(contentTitle));
					Content.getContents().remove(contentTitle);
					
					JOptionPane.showMessageDialog(null, "Deleted Post Successfully. Refresh the page to see updates.","Deleted Post",JOptionPane.PLAIN_MESSAGE);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Enter Correct Post Title.","Wrong Input",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
		else if(evt.getSource().equals(editPostButton)) { // Editing a post same as the MemberGroupPage edit post method.
			String contentTitle = JOptionPane.showInputDialog(null, "Please enter title of the post that will be edited.\nPosts: "+this.getActiveUser().getUserContents(),"Post Deletion",JOptionPane.QUESTION_MESSAGE);
			if (contentTitle != null) {
				if(this.getActiveUser().getUserContents().contains(Content.getContents().get(contentTitle))) {
					
					if (Content.getContents().get(contentTitle).getType().equals("0")) {
						String contentText = JOptionPane.showInputDialog(null, "Please Enter Post Text.\nNote: empty text is not accepted.","Choose Post Text",JOptionPane.QUESTION_MESSAGE);
						if (contentText != null) {
							if (contentText.equals("")) {
								JOptionPane.showMessageDialog(null, "Post text can not be empty! Please Try Again.","Empty Space",JOptionPane.ERROR_MESSAGE);
							}
							else {
								Content.getContents().get(contentTitle).setText(contentText);
								JOptionPane.showMessageDialog(null, "Edited Post Successfully.","Edited Post",JOptionPane.PLAIN_MESSAGE);
								
								
							}
						}
					}
					else if(Content.getContents().get(contentTitle).getType().equals("1")) {
						JOptionPane.showMessageDialog(null, "Please Choose a new Image.","Post Image",JOptionPane.PLAIN_MESSAGE);
						
						JFileChooser fileChooser = new JFileChooser();
						
						int response = fileChooser.showOpenDialog(null);
						if (response == JFileChooser.APPROVE_OPTION) {
							try {
							File file = fileChooser.getSelectedFile();
			                Image picture = ImageIO.read(file);
							Image scaled = picture.getScaledInstance(242, 198, java.awt.Image.SCALE_SMOOTH);
							ImageIcon contentImage = new ImageIcon(scaled);
							
							Content.getContents().get(contentTitle).setImage(contentImage);
							JOptionPane.showMessageDialog(null, "Edited Post Successfully.","Edited Post",JOptionPane.PLAIN_MESSAGE);
							
							}
							catch (IOException ex) {
								JOptionPane.showMessageDialog(null, "Please select a image of type .png and .jpeg","Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					else {
						
						String contentText = JOptionPane.showInputDialog(null, "Please Enter Post Text.\nNote: empty text is not accepted.","Choose Post Text",JOptionPane.QUESTION_MESSAGE);
						if (contentText != null) {
							if (contentText.equals("")) {
								JOptionPane.showMessageDialog(null, "Post text can not be empty! Please Try Again.","Empty Space",JOptionPane.ERROR_MESSAGE);
							}
							else {
								Content.getContents().get(contentTitle).setText(contentText);
								JOptionPane.showMessageDialog(null, "Please Choose a new Image.","Post Image",JOptionPane.PLAIN_MESSAGE);
								
								JFileChooser fileChooser = new JFileChooser();
								
								int response = fileChooser.showOpenDialog(null);
								if (response == JFileChooser.APPROVE_OPTION) {
									try {
									File file = fileChooser.getSelectedFile();
					                Image picture = ImageIO.read(file);
									Image scaled = picture.getScaledInstance(242, 198, java.awt.Image.SCALE_SMOOTH);
									ImageIcon contentImage = new ImageIcon(scaled);
									
									Content.getContents().get(contentTitle).setImage(contentImage);
									Content.getContents().get(contentTitle).setText(contentText);
									JOptionPane.showMessageDialog(null, "Edited Post Successfully.","Edited Post",JOptionPane.PLAIN_MESSAGE);
									
									}
									catch (IOException ex) {
										JOptionPane.showMessageDialog(null, "Please select a image of type .png and .jpeg","Error", JOptionPane.ERROR_MESSAGE);
									}
								}
								
							}
						}
						
					}
				
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Please Enter Correct Post Title.","Wrong Input",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		
		
		
	}
}
