package GUIClasses;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ObjectClasses.User;

// NonFollowedProfilePage class which is a JFrame
public class NonFollowedProfilePage extends JFrame implements ActionListener{
	
	// instance variables and jframe components.
	private HashMap<String,JFrame> OtherFrames = new HashMap<>();
	private User ActiveUser;
	private User ProfileOwner;
	private JLabel profileInfoLabel;
	private JLabel ppLabel;
	private JLabel nicknameLabel;
	private JLabel accountTypeLabel;
	private JLabel realnameLabel;
	private JLabel surnameLabel;
	private JButton followButton;
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

	public void addOtherFrames(String name, JFrame j) {
		this.getOtherFrames().put(name, j);
	}

	//constructor
	public NonFollowedProfilePage(User active,User owner) {
		
		this.ActiveUser = active;
		this.ProfileOwner = owner;
		initialize();
		
	}

	// image resize methos
	private ImageIcon imageScale(ImageIcon i) {
		Image scaler = i.getImage();
		Image scaling = scaler.getScaledInstance(227, 219, java.awt.Image.SCALE_SMOOTH);
		ImageIcon scaled = new ImageIcon(scaling);
		return scaled;
		
	}

	// JFrame component initializor.
	private void initialize() {
		
		
		this.setResizable(false);
		this.setBounds(100, 100, 664, 523);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		
		
		profileInfoLabel = new JLabel("Profile Of " + ProfileOwner.getNickname());
		profileInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		profileInfoLabel.setBounds(152, 24, 347, 16);
		this.getContentPane().add(profileInfoLabel);
		
		ppLabel = new JLabel();
		ppLabel.setBounds(339, 125, 227, 219);
		ppLabel.setIcon(imageScale(this.getProfileOwner().getProfilePhoto()));
		this.getContentPane().add(ppLabel);
		
		nicknameLabel = new JLabel("Nickname:   "+ ProfileOwner.getNickname());
		nicknameLabel.setBounds(85, 125, 227, 16);
		this.getContentPane().add(nicknameLabel);
		
		String typeofAcc = "";
		if (ProfileOwner.isPremium()) {
			typeofAcc = "Premium";
		}
		else {
			typeofAcc = "Basic";
		}
		
		accountTypeLabel = new JLabel("Account Type:   " + typeofAcc );
		accountTypeLabel.setBounds(85, 328, 227, 16);
		this.getContentPane().add(accountTypeLabel);
		
		
		realnameLabel = new JLabel("Real Name:   " + ProfileOwner.getName());
		realnameLabel.setBounds(85, 195, 227, 16);
		this.getContentPane().add(realnameLabel);
		
		surnameLabel = new JLabel("Surname:   " + ProfileOwner.getSurname());
		surnameLabel.setBounds(85, 258, 227, 16);
		this.getContentPane().add(surnameLabel);
		
		followButton = new JButton("Follow");
		followButton.setBounds(267, 386, 117, 29);
		followButton.addActionListener(this);
		this.getContentPane().add(followButton);
		
		goBackButton = new JButton("Go Back");
		goBackButton.setBounds(42, 446, 117, 29);
		goBackButton.addActionListener(this);
		this.getContentPane().add(goBackButton);
	}
	
	
	
	
	 // action listener attributes
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource().equals(goBackButton)) { // go back buttton redirects the user to homepage.
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
		}
		else { // follow method to follow a profile page to acces its posts and joint groups. it adds the profile owner to followed arraylist and then returnin to homepage.
			this.getActiveUser().follow(this.getProfileOwner());
			JOptionPane.showMessageDialog(null, "The user is followed. You can research user's nickname to see their full profile.","Followed",JOptionPane.PLAIN_MESSAGE);
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
		}
	}
	
	

}
