package GUIClasses;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import ObjectClasses.Group;
import ObjectClasses.User;

// Class NonMemberGroupPage is a Jframe and action listener.
public class NonMemberGroupPage extends JFrame implements ActionListener {
	
	// instance variables
	private User ActiveUser;
	private Group ThisGroup;
	private HashMap<String,JFrame> OtherFrames = new HashMap<>();
	
	// JFrame components.
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel countryLabel;
	private JLabel hobbiesLabel;
	private JScrollPane hobbiesScrollPane;
	private JPanel hobbiesListPanel;
	private JButton joinButton;
	private JButton goBackButton;
	
	// constructor
	
	public NonMemberGroupPage(User activeUser, Group thisGroup) {
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
	public void addOtherFrames(String name, JFrame j) { // add other frame method to class other frames map
		this.getOtherFrames().put(name, j);
	}


	
	public void addHobbies(JPanel p) { // addHobies method to display the hobbies to hobbie JPanel.
		for (String hobbie : this.getThisGroup().getHobbies()) {
				JLabel hobbieLabel = new JLabel(hobbie);
				hobbieLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
				p.add(hobbieLabel);
		}
	}
	// initialize JFrame components.
	private void initialize() {
		this.setResizable(false);
		this.setBounds(100, 100, 622, 531);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		titleLabel = new JLabel("Group Page");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(218, 6, 166, 37);
		this.getContentPane().add(titleLabel);
		
		nameLabel = new JLabel("Name:   "+ this.getThisGroup().getName());
		nameLabel.setBounds(93, 111, 229, 16);
		this.getContentPane().add(nameLabel);
		
		countryLabel = new JLabel("Country:   " + this.getThisGroup().getCountry());
		countryLabel.setBounds(93, 168, 166, 16);
		this.getContentPane().add(countryLabel);
		
		hobbiesLabel = new JLabel("Hobbies:");
		hobbiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hobbiesLabel.setBounds(93, 225, 166, 16);
		this.getContentPane().add(hobbiesLabel);
		
		hobbiesScrollPane = new JScrollPane();
		hobbiesScrollPane.setBounds(93, 264, 166, 193);
		this.getContentPane().add(hobbiesScrollPane);
		
		hobbiesListPanel = new JPanel();
		hobbiesScrollPane.setViewportView(hobbiesListPanel);
		hobbiesListPanel.setLayout(new BoxLayout(hobbiesListPanel, BoxLayout.Y_AXIS));
		addHobbies(hobbiesListPanel);
		
		joinButton = new JButton("Join Group");
		joinButton.setBounds(402, 220, 117, 29);
		joinButton.addActionListener(this);
		this.getContentPane().add(joinButton);
		
		goBackButton = new JButton("Go Back");
		goBackButton.setBounds(402, 342, 117, 29);
		goBackButton.addActionListener(this);
		this.getContentPane().add(goBackButton);
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) { // action listener methods
		
		if (evt.getSource().equals(goBackButton)) { // go back to homepage method.
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
		}
		else { // method to join group by adding the group to user joinedgroups list and adding the user to group joineduserss list then returning to homepage.
			this.getActiveUser().joinGroup(ThisGroup);
			this.getThisGroup().addUsers(ActiveUser);
			JOptionPane.showMessageDialog(null, "You have joined the group. Please re-enter the group page to see full contents.","Joined Group",JOptionPane.PLAIN_MESSAGE);
			Homepage homepage = new Homepage(this.getActiveUser());
			homepage.addOtherFrames("Login", this.getOtherFrames().get("Login"));
			this.setVisible(false);
			this.dispose();
			homepage.setVisible(true);
			
		}
		
		
		
	}


}
