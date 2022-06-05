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

import ObjectClasses.Content;
import ObjectClasses.Group;
import ObjectClasses.User;

// class MemberGroupPage which is the group page of active user follows
public class MemberGroupPage extends JFrame implements ActionListener {
	
	// instance variables
	private User ActiveUser;
	private Group ThisGroup;
	private HashMap<String,JFrame> OtherFrames = new HashMap<>();
	
	// JFrame components.
	private JLabel titleLabel ;
	private JLabel nameLabel;
	private JLabel countryLabel;
	private JLabel hobbiesLabel;
	private JLabel creatorLabel;
	private JScrollPane hobbiesScrollPane;
	private JPanel hobbiesListPanel;
	private JLabel membersLabel;
	private JScrollPane membersScrollPane;
	private JPanel membersListPanel;
	private JLabel groupPostLabel;
	private JScrollPane groupScrollPane;
	private JPanel groupListPanel;
	private JButton goBackButton;
	private JButton leaveGroupButton;
	private JButton editPostButton;
	private JButton newPostButton;
	private JButton deletePostButton;
	
	//rescale image method
	private ImageIcon imageScale(ImageIcon i) {
		Image scaler = i.getImage();
		Image scaling = scaler.getScaledInstance(258, 252, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaled = new ImageIcon(scaling);
		return scaled;
		
	}
	// display post content used in homepage.
	private void displayGroupContent() {
		for (Content c : this.getThisGroup().getContents()) {
			if (c.getType().equals("0")) {
				JLabel contentTitle = new JLabel(c.getTitle());
				JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
				JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
				JLabel contentText = new JLabel(c.getText());
				JLabel Lgap = new JLabel("=====================");
				groupListPanel.add(contentTitle);
				groupListPanel.add(contentAuthor);
				groupListPanel.add(contentDate);
				groupListPanel.add(contentText);
				groupListPanel.add(Lgap);
			}
			else if (c.getType().equals("1")) {
				JLabel contentTitle = new JLabel(c.getTitle());
				JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
				JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
				JLabel contentImage = new JLabel();
				JLabel Lgap = new JLabel("=====================");
				contentImage.setIcon(imageScale(c.getImage()));
				groupListPanel.add(contentTitle);
				groupListPanel.add(contentAuthor);
				groupListPanel.add(contentDate);
				groupListPanel.add(contentImage);
				groupListPanel.add(Lgap);
			}
			else {
				JLabel contentTitle = new JLabel(c.getTitle());
				JLabel contentAuthor = new JLabel("Author: "+c.getAuthorNickname());
				JLabel contentDate = new JLabel("Date: "+c.getCreationTime());
				JLabel contentText = new JLabel(c.getText());
				JLabel contentImage = new JLabel();
				JLabel Lgap = new JLabel("=====================");
				contentImage.setIcon(imageScale(c.getImage()));
				groupListPanel.add(contentTitle);
				groupListPanel.add(contentAuthor);
				groupListPanel.add(contentDate);
				groupListPanel.add(contentText);
				groupListPanel.add(contentImage);
				groupListPanel.add(Lgap);
				
				
			}
			
		}
	}
	// constructor
	public MemberGroupPage(User activeUser, Group thisGroup) {
		ActiveUser = activeUser;
		ThisGroup = thisGroup;
		initialize();
	}

	// getters and setters
	public User getActiveUser() {
		return ActiveUser;
	}




	public void setActiveUser(User activeUser) {
		ActiveUser = activeUser;
	}




	public Group getThisGroup() {
		return ThisGroup;
	}




	public void setThisGroup(Group thisGroup) {
		ThisGroup = thisGroup;
	}




	public HashMap<String, JFrame> getOtherFrames() {
		return OtherFrames;
	}


	public void setOtherFrames(HashMap<String, JFrame> otherFrames) {
		OtherFrames = otherFrames;
	}
	public void addOtherFrames(String name, JFrame j) {
		this.getOtherFrames().put(name, j);
	}
	
// add members to user label and display them
	public void addMembers (JPanel p) {
		for (User u : this.getThisGroup().getUsers()) {
			JLabel userLabel = new JLabel(u.getNickname());
			userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			p.add(userLabel);
		}
		
	}
	// add hobbies to hobbies label and display it.
	public void addHobbies(JPanel p) {
		for (String hobbie : this.getThisGroup().getHobbies()) {
				JLabel hobbieLabel = new JLabel(hobbie);
				hobbieLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				p.add(hobbieLabel);
		}
	}
	
	
	
	// JFrame initializor.
	private void initialize() {
		
		this.setResizable(false);
		this.setBounds(100, 100, 682, 539);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		titleLabel = new JLabel("Group Page");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(249, 6, 166, 37);
		this.getContentPane().add(titleLabel);
		
		nameLabel = new JLabel("Name:   " + this.getThisGroup().getName());
		nameLabel.setBounds(63, 90, 188, 16);
		this.getContentPane().add(nameLabel);
		
		countryLabel = new JLabel("Country:   " + this.getThisGroup().getCountry());
		countryLabel.setBounds(63, 118, 188, 16);
		this.getContentPane().add(countryLabel);
		
		hobbiesLabel = new JLabel("Hobbies: ");
		hobbiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hobbiesLabel.setBounds(63, 146, 188, 16);
		this.getContentPane().add(hobbiesLabel);
		
		creatorLabel = new JLabel("Creator:   " + this.getThisGroup().getOwner().getNickname());
		creatorLabel.setBounds(63, 62, 176, 16);
		this.getContentPane().add(creatorLabel);
		
		hobbiesScrollPane = new JScrollPane();
		hobbiesScrollPane.setBounds(73, 174, 166, 139);
		this.getContentPane().add(hobbiesScrollPane);
		
		hobbiesListPanel = new JPanel();
		hobbiesScrollPane.setViewportView(hobbiesListPanel);
		hobbiesListPanel.setLayout(new BoxLayout(hobbiesListPanel, BoxLayout.Y_AXIS));
		addHobbies(hobbiesListPanel);
		
		membersLabel = new JLabel("Members:");
		membersLabel.setBounds(124, 325, 61, 16);
		this.getContentPane().add(membersLabel);
		
		membersScrollPane = new JScrollPane();
		membersScrollPane.setBounds(73, 353, 166, 135);
		this.getContentPane().add(membersScrollPane);
		
		membersListPanel = new JPanel();
		membersScrollPane.setViewportView(membersListPanel);
		membersListPanel.setLayout(new BoxLayout(membersListPanel, BoxLayout.Y_AXIS));
		addMembers(membersListPanel);
		
		
		groupPostLabel = new JLabel("Posts");
		groupPostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		groupPostLabel.setBounds(423, 62, 199, 16);
		this.getContentPane().add(groupPostLabel);
		
		groupScrollPane = new JScrollPane();
		groupScrollPane.setBounds(392, 98, 258, 252);
		this.getContentPane().add(groupScrollPane);
		
		groupListPanel = new JPanel();
		groupScrollPane.setViewportView(groupListPanel);
		groupListPanel.setLayout(new BoxLayout(groupListPanel, BoxLayout.Y_AXIS));
		displayGroupContent();
		
		goBackButton = new JButton("Go Back");
		goBackButton.setBounds(533, 13, 117, 29);
		goBackButton.addActionListener(this);
		this.getContentPane().add(goBackButton);
		
		leaveGroupButton = new JButton("Leave Group");
		leaveGroupButton.setBounds(283, 459, 117, 29);
		leaveGroupButton.addActionListener(this);
		this.getContentPane().add(leaveGroupButton);
		
		editPostButton = new JButton("Edit Post");
		editPostButton.setBounds(423, 414, 117, 29);
		editPostButton.addActionListener(this);
		this.getContentPane().add(editPostButton);
		
		newPostButton = new JButton("New Post");
		newPostButton.setBounds(490, 459, 117, 29);
		newPostButton.addActionListener(this);
		this.getContentPane().add(newPostButton);
		
		
		deletePostButton = new JButton("Delete Post");
		deletePostButton.setBounds(543, 414, 117, 29);
		deletePostButton.addActionListener(this);
		if (this.getThisGroup().getContents().isEmpty()) {
			deletePostButton.setEnabled(false);
		}
		
		this.getContentPane().add(deletePostButton);
	
	}
	@Override
	public void actionPerformed(ActionEvent evt) { // action listeners.
		
		if (evt.getSource().equals(goBackButton)) { // go back to homepage method
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
		}
		else if (evt.getSource().equals(leaveGroupButton)) { // leave tehe group by making user of app leave it and removing it from groups userlist and app users group list and then returning to homepage.
			
			this.getActiveUser().leaveGroup(ThisGroup);
			this.getThisGroup().removeUsers(ActiveUser);
			JOptionPane.showMessageDialog(null, "You have successfully left the group.","Left Group",JOptionPane.PLAIN_MESSAGE);
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
			
			
			
		}
		// new post creator used in HomePage.
		else if (evt.getSource().equals(newPostButton)) {
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
										this.getThisGroup().addContents(newContent);
										JOptionPane.showMessageDialog(null, "Created Post Successfully.","Created Post",JOptionPane.PLAIN_MESSAGE);
										JLabel LcontentTitle = new JLabel(newContent.getTitle());
										JLabel LcontentAuthor = new JLabel("Author: "+newContent.getAuthorNickname());
										JLabel LcontentDate = new JLabel("Date: "+newContent.getCreationTime());
										JLabel LcontentText = new JLabel(newContent.getText());
										JLabel Lgap = new JLabel("=====================");
										groupListPanel.add(LcontentTitle);
										groupListPanel.add(LcontentAuthor);
										groupListPanel.add(LcontentDate);
										groupListPanel.add(LcontentText);
										groupListPanel.add(Lgap);
										groupListPanel.add(Lgap);
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
									Image scaled = picture.getScaledInstance(258, 252, java.awt.Image.SCALE_SMOOTH);
									ImageIcon contentImage = new ImageIcon(scaled);
									
									Content newContent = new Content(contentTitle,this.getActiveUser().getNickname(),contentImage);
									this.getThisGroup().addContents(newContent);
									JOptionPane.showMessageDialog(null, "Created Post Successfully.","Created Post",JOptionPane.PLAIN_MESSAGE);
									JLabel LcontentTitle = new JLabel(newContent.getTitle());
									JLabel LcontentAuthor = new JLabel("Author: "+newContent.getAuthorNickname());
									JLabel LcontentDate = new JLabel("Date: "+newContent.getCreationTime());
									JLabel LcontentImage = new JLabel();
									JLabel Lgap = new JLabel("=====================");
									LcontentImage.setIcon(newContent.getImage());
									groupListPanel.add(LcontentTitle);
									groupListPanel.add(LcontentAuthor);
									groupListPanel.add(LcontentDate);
									groupListPanel.add(LcontentImage);
									groupListPanel.add(Lgap);
									groupListPanel.add(Lgap);
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
											Image scaled = picture.getScaledInstance(258, 252, java.awt.Image.SCALE_SMOOTH);
											ImageIcon contentImage = new ImageIcon(scaled);
											
											Content newContent = new Content(contentTitle,this.getActiveUser().getNickname(),contentText,contentImage);
											this.getThisGroup().addContents(newContent);
											JOptionPane.showMessageDialog(null, "Created Post Successfully.","Created Post",JOptionPane.PLAIN_MESSAGE);
											JLabel LcontentTitle = new JLabel(newContent.getTitle());
											JLabel LcontentAuthor = new JLabel("Author: "+newContent.getAuthorNickname());
											JLabel LcontentDate = new JLabel("Date: "+newContent.getCreationTime());
											JLabel LcontentText = new JLabel(newContent.getText());
											JLabel LcontentImage = new JLabel();
											JLabel Lgap = new JLabel("=====================");
											LcontentImage.setIcon(newContent.getImage());
											groupListPanel.add(LcontentTitle);
											groupListPanel.add(LcontentAuthor);
											groupListPanel.add(LcontentDate);
											groupListPanel.add(LcontentText);
											groupListPanel.add(LcontentImage);
											groupListPanel.add(Lgap);
											groupListPanel.add(Lgap);
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
		// Delete a post by getting a title from the user and if the content exist remove it from class static content list and group content list.
		else if (evt.getSource().equals(deletePostButton)) {
			String contentTitle = JOptionPane.showInputDialog(null, "Please enter title of the post that will be deleted.\nPosts: "+this.ThisGroup.getContents(),"Post Deletion",JOptionPane.QUESTION_MESSAGE);
			if (contentTitle != null) {
				if(this.getThisGroup().getContents().contains(Content.getContents().get(contentTitle))) {
					this.getThisGroup().getContents().remove(Content.getContents().get(contentTitle));
					Content.getContents().remove(contentTitle);
					
					JOptionPane.showMessageDialog(null, "Deleted Post Successfully. Refresh the page to see updates.","Deleted Post",JOptionPane.PLAIN_MESSAGE);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Enter Correct Post Title.","Wrong Input",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
		// edit post by rearreging its vairables based on the type of content. it also checks for right input.
		else if(evt.getSource().equals(editPostButton)) {
			String contentTitle = JOptionPane.showInputDialog(null, "Please enter title of the post that will be edited.\nPosts: "+this.ThisGroup.getContents(),"Post Deletion",JOptionPane.QUESTION_MESSAGE);
			if (contentTitle != null) {
				if(this.getThisGroup().getContents().contains(Content.getContents().get(contentTitle))) {
					
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
							Image scaled = picture.getScaledInstance(258, 252, java.awt.Image.SCALE_SMOOTH);
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
									Image scaled = picture.getScaledInstance(258, 252, java.awt.Image.SCALE_SMOOTH);
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
