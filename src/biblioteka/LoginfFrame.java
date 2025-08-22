package biblioteka;

import java.awt.GridLayout;

import javax.swing.*;

public class LoginfFrame extends JFrame{
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
	/**
	 * 
	 */
	LoginfFrame(App app) {
		setTitle("Welcome");
		setSize(400, 200);
		setLayout(new GridLayout(3, 2));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		usernameField = new JTextField();
		passwordField = new JPasswordField();
		loginButton = new JButton("Login");
		add(new JLabel("Username:"));
		add(usernameField);
		add(new JLabel("Password:"));
		add(passwordField);
		add(new JLabel());
		add(loginButton);
		getRootPane().setDefaultButton(loginButton);
		
		loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            Person user = app.login(username, password);
            if (user != null) {
                dispatch(user, app);
                dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Ne postoji korisnik sa datim imenom/sifrom");
            }
        });
		
		setVisible(true);
	}
	private void dispatch(Person user, App app) {
		if (user instanceof Member) {
            new MemberFrame((Member) user, app);
        } else if (user instanceof Bibliotekar) {
            new BibliotekarFrame((Bibliotekar) user, app);
        } else if (user instanceof Admin) {
            new AdminFrame((Admin) user, app);
        }
		
	}
	private static final long serialVersionUID = 1L;
//	
	
}
