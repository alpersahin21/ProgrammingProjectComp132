package GUIClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

import ObjectClasses.User;



// Class LoginPage is a JFrame and it can do method actionPerformed by ActionListener interface.
public class LoginPage extends JFrame implements ActionListener {

	private static HashMap<String,String>UserDB = new HashMap<>();
	private HashMap<String,JFrame> OtherFrames = new HashMap<>();
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPanel mainPanel;
	private JLabel greetLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton loginButton;
	private JButton signupButton;
	
	/**
	 * Create the application.
	 */
	public LoginPage() {

		initializeLogin();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initializeLogin() {
		
		this.setTitle("Social Media Project");
		this.setResizable(false);
		this.setBounds(100, 100, 604, 436);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 604, 408);
		this.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		greetLabel = new JLabel("Welcome to the app!");
		greetLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		greetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greetLabel.setBounds(104, 23, 377, 16);
		mainPanel.add(greetLabel);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(102, 100, 74, 16);
		mainPanel.add(usernameLabel);
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(104, 160, 72, 16);
		mainPanel.add(passwordLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(216, 95, 181, 26);
		mainPanel.add(usernameField);
		usernameField.setColumns(10);
		
		loginButton = new JButton("Login");
		loginButton.setBackground(Color.GRAY);
		loginButton.setBounds(251, 215, 117, 29);
		loginButton.addActionListener(this);
		mainPanel.add(loginButton);
		
		signupButton = new JButton("Sign Up");
		signupButton.setBounds(251, 323, 117, 29);
		signupButton.addActionListener(this);
		mainPanel.add(signupButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(216, 155, 181, 26);
		mainPanel.add(passwordField);
		
		
		
	}
	
	//Getters and Setters.
	
	public static HashMap<String, String> getUserDB() {
		return UserDB;
	}

	public static void setUserDB(HashMap<String, String> userDB) {
		UserDB = userDB;
	}

	

	public HashMap<String, JFrame> getOtherFrames() {
		return OtherFrames;
	}

	public void addOtherFrames(String name ,JFrame j) {
		OtherFrames.put(name, j);
	}
	
	// line clean method to clean username and password fields.
	private void lineClean() {
		usernameField.setText("");
		passwordField.setText("");
	}
	// actionlsitener method.
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource()==loginButton) { // login method if given username and password is suitable and it is signed to a account sign in to a account else pop out an error message.
			try {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				
				Boolean s = LoginPage.getUserDB().get(username).equals(password);

				if (s) {
					JOptionPane.showMessageDialog(null, "Login Successful!","Logged In",JOptionPane.PLAIN_MESSAGE);
					
					Homepage homepage = new Homepage(User.getUsers().get(username));
					homepage.addOtherFrames("Login", this);
					this.addOtherFrames("Homepage", homepage);

					lineClean();
					this.setVisible(false);
					this.dispose();
					
					this.getOtherFrames().get("Homepage").setVisible(true);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and Password does not match. Please Try Again.","No Account",JOptionPane.WARNING_MESSAGE);
					
				}
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "There is no account with this username. Please Sign Up first.","Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		// signup button event redirect the user to sign up panel.
		else if (evt.getSource()==signupButton) {
			lineClean();
			this.setVisible(false);
			this.dispose();
			this.getOtherFrames().get("Signup").setVisible(true);
		}
		
	}

}
