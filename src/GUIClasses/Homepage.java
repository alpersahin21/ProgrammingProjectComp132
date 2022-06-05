package GUIClasses;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import ObjectClasses.Content;
import ObjectClasses.Group;
import ObjectClasses.User;

// Homepage frame

public class Homepage extends JFrame implements ActionListener{
	
	// instance variables of component list, group list, and frame map to connect to other frames.
	
	private HashMap<String,JFrame> OtherFrames = new HashMap<>();
	private User ActiveUser;
	private ArrayList<Content>AllUserContents = new ArrayList<>();
	private ArrayList<Content>AllGroupContents = new ArrayList<>();
	
	// instantiate frame components.
	
	private JPanel titlePanel;
	private JLabel homepageTitle;
	private JPanel buttonPanel;
	private JButton signOutButton;
	private JButton findGroupButton;
	private JButton findUsersButton;
	private JButton myProfileButton;
	private JScrollPane groupPostPane;
	private JScrollPane userPostPane;
	private JButton searchContentButton;
	private JButton createPostButton;
	private JLabel groupPostsLabel;
	private JLabel userPostsLabel;
	private JPanel groupPostListPanel;
	private JPanel userPostListPanel;
	
	
	
	//  constructor.
	
	public Homepage(User u) {
		this.ActiveUser = u;
		initialize();
		
		
	}
	
	
	// getter and setters.
	public HashMap<String, JFrame> getOtherFrames() {
		return OtherFrames;
	}
	
	// image scale method to scale it to JPanel width and height
	private ImageIcon imageScale(ImageIcon i) {
		Image scaler = i.getImage();
		Image scaling = scaler.getScaledInstance(458, 353, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaled = new ImageIcon(scaling);
		return scaled;
		
	}

	public void addOtherFrames(String name, JFrame j) {
		OtherFrames.put(name, j);
	}



	public User getActiveUser() {
		return ActiveUser;
	}



	public void setActiveUser(User activeUser) {
		ActiveUser = activeUser;
	}
	
	// method to display the user posts to user post scrolling pane. iterating through the followed users and app user and getting components from it, later based on component type set JFrame component values.
	
	public void displayUserContent() {
		for (User u : User.getUsers().values()) {
			if (this.getActiveUser().getFollowedUsers().contains(u) || u.equals(this.getActiveUser())) {
				for (Content c : u.getUserContents()) {
					AllUserContents.add(c);
					if (c.getType().equals("0")) {
						JLabel contentTitle = new JLabel(c.getTitle());
						JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
						JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
						JLabel contentText = new JLabel(c.getText());
						JLabel Lgap = new JLabel("=====================");
						userPostListPanel.add(contentTitle);
						userPostListPanel.add(contentAuthor);
						userPostListPanel.add(contentDate);
						userPostListPanel.add(contentText);
						userPostListPanel.add(Lgap);
						userPostListPanel.add(Lgap);
						
					}
					else if (c.getType().equals("1")) {
						JLabel contentTitle = new JLabel(c.getTitle());
						JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
						JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
						JLabel contentImage = new JLabel();
						JLabel Lgap = new JLabel("=====================");
						contentImage.setIcon(imageScale(c.getImage()));
						userPostListPanel.add(contentTitle);
						userPostListPanel.add(contentAuthor);
						userPostListPanel.add(contentDate);
						userPostListPanel.add(contentImage);
						userPostListPanel.add(Lgap);
						userPostListPanel.add(Lgap);
					}
					else {
						JLabel contentTitle = new JLabel(c.getTitle());
						JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
						JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
						JLabel contentText = new JLabel(c.getText());
						JLabel contentImage = new JLabel();
						JLabel Lgap = new JLabel("=====================");
						contentImage.setIcon(imageScale(c.getImage()));
						userPostListPanel.add(contentTitle);
						userPostListPanel.add(contentAuthor);
						userPostListPanel.add(contentDate);
						userPostListPanel.add(contentText);
						userPostListPanel.add(contentImage);
						userPostListPanel.add(Lgap);
						userPostListPanel.add(Lgap);
						
						
					}
					
				}
			}
		}
	}
	// method to display the group posts to group post scrolling pane. iterating through the joined groups and app user and getting components from it, later based on component type set JFrame component values.
	
	public void displayGroupContent() {
		for(Group g: Group.getGroups().values()) {
			if (this.getActiveUser().isMemberOf(g)) {
				for (Content c : g.getContents()) {
					AllGroupContents.add(c);
					if (c.getType().equals("0")) {
						JLabel contentTitle = new JLabel(c.getTitle());
						JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
						JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
						JLabel contentText = new JLabel(c.getText());
						JLabel Lgap = new JLabel("=====================");
						groupPostListPanel.add(contentTitle);
						groupPostListPanel.add(contentAuthor);
						groupPostListPanel.add(contentDate);
						groupPostListPanel.add(contentText);
						groupPostListPanel.add(Lgap);
						groupPostListPanel.add(Lgap);
						
					}
					else if (c.getType().equals("1")) {
						JLabel contentTitle = new JLabel(c.getTitle());
						JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
						JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
						JLabel contentImage = new JLabel();
						JLabel Lgap = new JLabel("=====================");
						contentImage.setIcon(imageScale(c.getImage()));
						groupPostListPanel.add(contentTitle);
						groupPostListPanel.add(contentAuthor);
						groupPostListPanel.add(contentDate);
						groupPostListPanel.add(contentImage);
						groupPostListPanel.add(Lgap);
						groupPostListPanel.add(Lgap);
						
					}
					else {
						JLabel contentTitle = new JLabel(c.getTitle());
						JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
						JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
						JLabel contentText = new JLabel(c.getText());
						JLabel contentImage = new JLabel();
						JLabel Lgap = new JLabel("=====================");
						contentImage.setIcon(imageScale(c.getImage()));
						groupPostListPanel.add(contentTitle);
						groupPostListPanel.add(contentAuthor);
						groupPostListPanel.add(contentDate);
						groupPostListPanel.add(contentText);
						groupPostListPanel.add(contentImage);
						groupPostListPanel.add(Lgap);
						groupPostListPanel.add(Lgap);
						
						
					}
					
				}
			}
		}
	}
	// method to find content using all user and group components which was implemented in display group and display user methods. if find a content, instantiate it on the bottom of the panel which the content belongs to.
	private void findContent(String title) {
		
		for (Content c : AllUserContents) {
					if (c.getTitle().equals(title)) {
						if (c.getType().equals("0")) {
							JLabel contentTitle = new JLabel(c.getTitle());
							JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
							JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
							JLabel contentText = new JLabel(c.getText());
							JLabel Lgap = new JLabel("=====================");
							JLabel Foundgap = new JLabel("============FOUND=========");
							groupPostListPanel.add(Foundgap);
							userPostListPanel.add(contentTitle);
							userPostListPanel.add(contentAuthor);
							userPostListPanel.add(contentDate);
							userPostListPanel.add(contentText);
							userPostListPanel.add(Lgap);
							userPostListPanel.add(Lgap);
							this.revalidate();
							this.repaint();
							
						}
						else if (c.getType().equals("1")) {
							JLabel contentTitle = new JLabel(c.getTitle());
							JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
							JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
							JLabel contentImage = new JLabel();
							JLabel Lgap = new JLabel("=====================");
							JLabel Foundgap = new JLabel("============FOUND=========");
							contentImage.setIcon(imageScale(c.getImage()));
							groupPostListPanel.add(Foundgap);
							userPostListPanel.add(contentTitle);
							userPostListPanel.add(contentAuthor);
							userPostListPanel.add(contentDate);
							userPostListPanel.add(contentImage);
							userPostListPanel.add(Lgap);
							userPostListPanel.add(Lgap);
							this.revalidate();
							this.repaint();
						}
						else {
							JLabel contentTitle = new JLabel(c.getTitle());
							JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
							JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
							JLabel contentText = new JLabel(c.getText());
							JLabel contentImage = new JLabel();
							JLabel Lgap = new JLabel("=====================");
							JLabel Foundgap = new JLabel("============FOUND=========");
							contentImage.setIcon(imageScale(c.getImage()));
							groupPostListPanel.add(Foundgap);
							userPostListPanel.add(contentTitle);
							userPostListPanel.add(contentAuthor);
							userPostListPanel.add(contentDate);
							userPostListPanel.add(contentText);
							userPostListPanel.add(contentImage);
							userPostListPanel.add(Lgap);
							userPostListPanel.add(Lgap);
							this.revalidate();
							this.repaint();
							
						}
					}
					
				
			
		}
		for (Content c : AllGroupContents) {
			
					if (c.getTitle().equals(title)) {
						if (c.getType().equals("0")) {
							JLabel contentTitle = new JLabel(c.getTitle());
							JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
							JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
							JLabel contentText = new JLabel(c.getText());
							JLabel Lgap = new JLabel("=====================");
							JLabel Foundgap = new JLabel("============FOUND=========");
							groupPostListPanel.add(Foundgap);
							groupPostListPanel.add(contentTitle);
							groupPostListPanel.add(contentAuthor);
							groupPostListPanel.add(contentDate);
							groupPostListPanel.add(contentText);
							groupPostListPanel.add(Lgap);
							groupPostListPanel.add(Lgap);
							this.revalidate();
							this.repaint();
							
						}
						else if (c.getType().equals("1")) {
							JLabel contentTitle = new JLabel(c.getTitle());
							JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
							JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
							JLabel contentImage = new JLabel();
							JLabel Lgap = new JLabel("=====================");
							JLabel Foundgap = new JLabel("============FOUND=========");
							contentImage.setIcon(imageScale(c.getImage()));
							groupPostListPanel.add(Foundgap);
							groupPostListPanel.add(contentTitle);
							groupPostListPanel.add(contentAuthor);
							groupPostListPanel.add(contentDate);
							groupPostListPanel.add(contentImage);
							groupPostListPanel.add(Lgap);
							groupPostListPanel.add(Lgap);
							this.revalidate();
							this.repaint();
							
						}
						else {
							JLabel contentTitle = new JLabel(c.getTitle());
							JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
							JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
							JLabel contentText = new JLabel(c.getText());
							JLabel contentImage = new JLabel();
							JLabel Foundgap = new JLabel("============FOUND=========");
							JLabel Lgap = new JLabel("=====================");
							contentImage.setIcon(imageScale(c.getImage()));
							groupPostListPanel.add(Foundgap);
							groupPostListPanel.add(contentTitle);
							groupPostListPanel.add(contentAuthor);
							groupPostListPanel.add(contentDate);
							groupPostListPanel.add(contentText);
							groupPostListPanel.add(contentImage);
							groupPostListPanel.add(Lgap);
							groupPostListPanel.add(Lgap);
							this.revalidate();
							this.repaint();
						}
					
					
				}
			
	}
		
}
	// instantiate JFrame components.
	public void initialize() {
		
		this.setResizable(false);
		this.setBounds(100, 100, 914, 574);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		groupPostPane = new JScrollPane();
		groupPostPane.setBounds(0, 81, 458, 353);
		this.getContentPane().add(groupPostPane);
		
		groupPostListPanel = new JPanel();
		groupPostPane.setViewportView(groupPostListPanel);
		groupPostListPanel.setLayout(new BoxLayout(groupPostListPanel, BoxLayout.Y_AXIS));
		displayGroupContent();
		
		
		userPostPane = new JScrollPane();
		userPostPane.setBounds(456, 81, 458, 353);
		this.getContentPane().add(userPostPane);
		
		searchContentButton = new JButton("Search Post");
		searchContentButton.setBounds(111, 440, 237, 29);
		searchContentButton.addActionListener(this);
		this.getContentPane().add(searchContentButton);
		
		createPostButton = new JButton("Create Post");
		createPostButton.setBounds(570, 440, 237, 29);
		createPostButton.addActionListener(this);
		this.getContentPane().add(createPostButton);
		
		groupPostsLabel = new JLabel("Group Posts");
		groupPostsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		groupPostsLabel.setBounds(122, 63, 213, 16);
		this.getContentPane().add(groupPostsLabel);
		
		userPostsLabel = new JLabel("User Posts");
		userPostsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userPostsLabel.setBounds(604, 63, 183, 16);
		this.getContentPane().add(userPostsLabel);
		
		userPostListPanel = new JPanel();
		userPostPane.setViewportView(userPostListPanel );
		userPostListPanel .setLayout(new BoxLayout(userPostListPanel , BoxLayout.Y_AXIS));
		displayUserContent();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 6, 914, 52);
		this.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		homepageTitle = new JLabel("Homepage");
		homepageTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		homepageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		homepageTitle.setBounds(346, 6, 224, 40);
		titlePanel.add(homepageTitle);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 471, 914, 75);
		this.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(null);
		
		signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(25, 27, 117, 29);
		signOutButton.addActionListener(this);
		buttonPanel.add(signOutButton);
		
		findGroupButton = new JButton("Find Groups");
		findGroupButton.setBounds(241, 27, 117, 29);
		findGroupButton.addActionListener(this);
		buttonPanel.add(findGroupButton);
		
		findUsersButton = new JButton("Find Users");
		findUsersButton.setBounds(530, 27, 117, 29);
		findUsersButton.addActionListener(this);
		buttonPanel.add(findUsersButton);
		
		myProfileButton = new JButton("My Profile");
		myProfileButton.setBounds(763, 27, 117, 29);
		myProfileButton.addActionListener(this);
		buttonPanel.add(myProfileButton);
	}
	
	
	
	
	// ActionListener Methods.
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		
		
		// going to signout page if signout button
		if (evt.getSource() == signOutButton) {
		
			JOptionPane.showMessageDialog(null, "Signed Out Successfully.","Signed Out",JOptionPane.PLAIN_MESSAGE);
			
			this.setVisible(false);
			this.dispose();
			this.getOtherFrames().get("Login").setVisible(true);
			
		}
		
		// going to useer own profie page.
		else if (evt.getSource()== myProfileButton) {
			
			SelfProfilePage selfProfile = new SelfProfilePage(this.getActiveUser());
			this.addOtherFrames("Selfprofile", selfProfile);
			selfProfile.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			selfProfile.addOtherFrames("Homepage", this);
			this.setVisible(false);
			this.dispose();
			
			this.getOtherFrames().get("Selfprofile").setVisible(true);
		}
		// open a find users option pane and go to the users profile page based of follow status if it exists.
		else if (evt.getSource()==findUsersButton) {
			
			String username = JOptionPane.showInputDialog(null, "Please Enter a Username to find:\nUsers: "+User.getUsers().keySet(),"Profile Search",JOptionPane.QUESTION_MESSAGE);
			int check = 0;
			for(String s : User.getUsers().keySet()) {
				if (s.equals(username)) {
					check = 1;
					if (this.getActiveUser().follows(User.getUsers().get(s))) {
						
						
						FollowedProfilePage followedProfile = new FollowedProfilePage(this.getActiveUser(),User.getUsers().get(s));
						followedProfile.addOtherFrames("Homepage", this);
						followedProfile.addOtherFrames("Login", this.getOtherFrames().get("Login"));
						this.addOtherFrames("Followedprofile", followedProfile);
						
						this.setVisible(false);
						this.dispose();
						this.getOtherFrames().get("Followedprofile").setVisible(true);
						
					}
					else {
						NonFollowedProfilePage nonfollowedProfile = new NonFollowedProfilePage(this.getActiveUser(),User.getUsers().get(s));
						nonfollowedProfile.addOtherFrames("Homepage", this);
						nonfollowedProfile.addOtherFrames("Login", this.getOtherFrames().get("Login"));
						this.addOtherFrames("Nonfollowedprofile", nonfollowedProfile);
						
						this.setVisible(false);
						this.dispose();
						this.getOtherFrames().get("Nonfollowedprofile").setVisible(true);
					}
				}
			}
			if (check == 0 && username!=null) {
				JOptionPane.showMessageDialog(null, "There is no profile with this username.","Not Found",JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		// open a find groups option pane and go to the groupss group page based of membership status if it exists.
		else if (evt.getSource().equals(findGroupButton)) {
			String groupname = JOptionPane.showInputDialog(null, "Please Enter a Group name to find: \nGroups: "+Group.getGroups().keySet(),"Group Search",JOptionPane.QUESTION_MESSAGE);
			int check = 0;
			for (String s: Group.getGroups().keySet()) {
				if (s.equals(groupname)) {
					check = 1;
					if (this.getActiveUser().isOwnerOf(Group.getGroups().get(groupname))) { 
						OwnerGroupPage ownerGroup = new OwnerGroupPage(this.getActiveUser(),Group.getGroups().get(groupname));
						ownerGroup.addOtherFrames("Homepage", this);
						ownerGroup.addOtherFrames("Login", this.getOtherFrames().get("Login"));
						this.addOtherFrames("Ownergroup", ownerGroup);
						
						this.setVisible(false);
						this.dispose();
						this.getOtherFrames().get("Ownergroup").setVisible(true);
						
						
					}
						
					else if (this.getActiveUser().isMemberOf(Group.getGroups().get(groupname))) {
						MemberGroupPage memberGroup = new MemberGroupPage(this.getActiveUser(),Group.getGroups().get(groupname));
						memberGroup.addOtherFrames("Homepage",this);
						memberGroup.addOtherFrames("Login", this.getOtherFrames().get("Login"));
						this.addOtherFrames("Membergroup", memberGroup);
						
						this.setVisible(false);
						this.dispose();
						this.getOtherFrames().get("Membergroup").setVisible(true);
					}
					else {
						NonMemberGroupPage nonMemberGroup = new NonMemberGroupPage(this.getActiveUser(),Group.getGroups().get(groupname));
						nonMemberGroup.addOtherFrames("Homepage",this);
						nonMemberGroup.addOtherFrames("Login", this.getOtherFrames().get("Login"));
						this.addOtherFrames("Nonmembergroup", nonMemberGroup);
						
						this.setVisible(false);
						this.dispose();
						this.getOtherFrames().get("Nonmembergroup").setVisible(true);
					}
				} 
			}
			if (check == 0 && groupname != null) {
				JOptionPane.showMessageDialog(null, "There is no group with this name.","Not Found",JOptionPane.ERROR_MESSAGE);
				
			}
		}
		// Method to create post. getting post type, title i and from type gtting text only, image only and both image and text and then instantiate the post to the homepage user posts label.
		else if (evt.getSource().equals(createPostButton)) {
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
										userPostListPanel.add(LcontentTitle);
										userPostListPanel.add(LcontentAuthor);
										userPostListPanel.add(LcontentDate);
										userPostListPanel.add(LcontentText);
										userPostListPanel.add(Lgap);
										userPostListPanel.add(Lgap);
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
									Image scaled = picture.getScaledInstance(458, 353, java.awt.Image.SCALE_SMOOTH);
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
									userPostListPanel.add(LcontentTitle);
									userPostListPanel.add(LcontentAuthor);
									userPostListPanel.add(LcontentDate);
									userPostListPanel.add(LcontentImage);
									userPostListPanel.add(Lgap);
									userPostListPanel.add(Lgap);
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
											Image scaled = picture.getScaledInstance(458, 353, java.awt.Image.SCALE_SMOOTH);
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
											userPostListPanel.add(LcontentTitle);
											userPostListPanel.add(LcontentAuthor);
											userPostListPanel.add(LcontentDate);
											userPostListPanel.add(LcontentText);
											userPostListPanel.add(LcontentImage);
											userPostListPanel.add(Lgap);
											userPostListPanel.add(Lgap);
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
		// search content event where the content is searched in allusercontents and allgroupcontents array lists. if found, run findContent method, if not, pop out a not found message.
		else if(evt.getSource().equals(searchContentButton)) {
			String contentTitle = JOptionPane.showInputDialog(null, "Please Enter the content title\nUser Posts: " + AllUserContents+"\nGroup Posts: "+AllGroupContents,"Choose Post Title",JOptionPane.QUESTION_MESSAGE);
			if (contentTitle != null) {
				if (AllUserContents.contains(Content.getContents().get(contentTitle))|| AllGroupContents.contains(Content.getContents().get(contentTitle))) {
					JOptionPane.showMessageDialog(null, "Found Post Successfully. It is displayed in the bottom of related area.","Found Post",JOptionPane.PLAIN_MESSAGE);
					findContent(contentTitle);
				}
				else {
					JOptionPane.showMessageDialog(null, "Fould not find a post with given title.","Could Not Find",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		} 
		
		
		
	}
	
}
