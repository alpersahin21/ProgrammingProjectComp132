package GUIClasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ObjectClasses.User;

// SignUp frame class
public class SignUpPage extends JFrame implements ActionListener{
	
	// instance variable
	private HashMap<String,JFrame> OtherFrames = new HashMap<>();
	
	//JFrame components
	private JLabel title;
	private JLabel NameLabel;
	private JLabel SurnameLabel;
	private JLabel AgeLabel;
	private JLabel EmailLabel;
	private JLabel UsernameLabel;
	private JLabel PasswordLabel;
	private JButton SignUpButton;
	private JTextField nameText;
	private JTextField SurnameText;
	private JTextField AgeText;
	private JTextField EmailText;
	private JTextField UsernameText;
	private JPasswordField PasswordText;
	private JPasswordField ConfirmPasswordText;
	private JLabel ConfirmPasswordLabel;
	
	// Constructor
	public SignUpPage() {
		
		initializeSignUp();
	}
	
	// initialize JFRame components.
	private void initializeSignUp() {
		
		this.setTitle("Sign Up");
		this.setResizable(false);
		this.setBounds(100, 100, 604, 436);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		title = new JLabel("Sign Up Page");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(213, 6, 158, 16);
		this.getContentPane().add(title);
		
		NameLabel = new JLabel("Name:");
		NameLabel.setBounds(114, 35, 61, 16);
		this.getContentPane().add(NameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(241, 30, 130, 26);
		this.getContentPane().add(nameText);
		nameText.setColumns(10);
		
		SurnameLabel = new JLabel("Surname:");
		SurnameLabel.setBounds(114, 85, 61, 16);
		this.getContentPane().add(SurnameLabel);
		
		AgeLabel = new JLabel("Age:");
		AgeLabel.setBounds(114, 135, 61, 16);
		this.getContentPane().add(AgeLabel);
		
		EmailLabel = new JLabel("E-mail:");
		EmailLabel.setBounds(114, 185, 61, 16);
		this.getContentPane().add(EmailLabel);
		
		UsernameLabel = new JLabel("Username:");
		UsernameLabel.setBounds(114, 235, 88, 16);
		this.getContentPane().add(UsernameLabel);
		
		PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(114, 285, 88, 16);
		this.getContentPane().add(PasswordLabel);
		
		ConfirmPasswordLabel = new JLabel("Confirm Password:");
		ConfirmPasswordLabel.setBounds(114, 335, 88, 16);
		this.getContentPane().add(ConfirmPasswordLabel);
		
		SignUpButton = new JButton("Sign Up");
		SignUpButton.setBounds(241, 373, 117, 29);
		SignUpButton.addActionListener(this);
		this.getContentPane().add(SignUpButton);
		
		SurnameText = new JTextField();
		SurnameText.setBounds(241, 80, 130, 26);
		this.getContentPane().add(SurnameText);
		SurnameText.setColumns(10);
		
		AgeText = new JTextField();
		AgeText.setBounds(241, 130, 130, 26);
		this.getContentPane().add(AgeText);
		AgeText.setColumns(10);
		
		EmailText = new JTextField();
		EmailText.setBounds(241, 180, 130, 26);
		this.getContentPane().add(EmailText);
		EmailText.setColumns(10);
		
		UsernameText = new JTextField();
		UsernameText.setBounds(241, 230, 130, 26);
		this.getContentPane().add(UsernameText);
		UsernameText.setColumns(10);
		
		PasswordText = new JPasswordField();
		PasswordText.setBounds(241, 280, 130, 26);
		this.getContentPane().add(PasswordText);
		PasswordText.setColumns(10);
		
		ConfirmPasswordText = new JPasswordField();
		ConfirmPasswordText.setBounds(241, 330, 130, 26);
		this.getContentPane().add(ConfirmPasswordText);
		ConfirmPasswordText.setColumns(10);
	}

	// getters and setters.
	public HashMap<String, JFrame> getOtherFrames() {
		return OtherFrames;
	}

	public void addOtherFrames(String name ,JFrame j) {
		OtherFrames.put(name, j);
	}
	 // cleaning textfields.
	private void lineClean() {
		UsernameText.setText("");
		PasswordText.setText("");
		nameText.setText("");
		SurnameText.setText("");
		AgeText.setText("");
		EmailText.setText("");
		UsernameText.setText("");
		ConfirmPasswordText.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent evt) { // Action Event Signum Button check for the correct output and then register the user to the user data base map of LoginPage and then returning back to the login page.
		try {
			if (UsernameText.getText().equals("")|| String.valueOf(PasswordText.getPassword()).equals("")|| nameText.getText().equals("")|| SurnameText.getText().equals("")|| AgeText.getText().equals("")|| EmailText.getText().equals("")|| String.valueOf(ConfirmPasswordText.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(null, "Please Fill all spaces.","Empty Space",JOptionPane.WARNING_MESSAGE);
			}
			else if (String.valueOf(PasswordText.getPassword()).equals(String.valueOf(ConfirmPasswordText.getPassword())) != true) {
				
				JOptionPane.showMessageDialog(null, "Passwords Don't match. Please Try Again.","Passport Mismatch",JOptionPane.WARNING_MESSAGE);
			}
			else if (User.getUsers().keySet().contains(UsernameText.getText())) {
				JOptionPane.showMessageDialog(null, "This username is taken. Please select another username.","Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				int test = Integer.parseInt(AgeText.getText());
				User user = new User(UsernameText.getText(),String.valueOf(PasswordText.getPassword()),nameText.getText(),SurnameText.getText(),AgeText.getText(),EmailText.getText());
				User.addUsers(user);
				LoginPage.getUserDB().put(UsernameText.getText(),String.valueOf(PasswordText.getPassword()));
				JOptionPane.showMessageDialog(null, "Signed up successfully! you may login with your username and password now.","Success",JOptionPane.PLAIN_MESSAGE);
				lineClean();
				this.setVisible(false);
				this.dispose();
				OtherFrames.get("Login").setVisible(true);
			}
			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Age must be a number. Please try again.","Error", JOptionPane.ERROR_MESSAGE);			
		}
		
	}

}
