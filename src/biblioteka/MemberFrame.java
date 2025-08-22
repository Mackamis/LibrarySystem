package biblioteka;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MemberFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	JLabel welcomeLabel;
	JButton browseBooksButton;
	JButton reserveBookButton;
	JButton requestMembershipButton;
	JButton cancelReservationButton;
	JButton reportButton;
	JButton logoutButton;
	JPanel buttonPanel;
	public MemberFrame(Member user, App app) {
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Biblioteka");
		setLayout(new BorderLayout());
		
		if (user.getClanarina().getStatus() == Clanarina.Status.INACTIVE) {
			JOptionPane.showMessageDialog(this, "Vasa clanarina je neaktivna. Molimo Vas da je obnovite.", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
		}
		
		welcomeLabel = new JLabel("Zdravo " + user.getUsername());
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
		add(welcomeLabel, BorderLayout.NORTH);
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,1));
		
//		browseBooksButton = new JButton("Pretraga knjiga");
//		browseBooksButton.addActionListener(e -> {
//			new BrowseBooksFrame(app);
//		});
//		buttonPanel.add(browseBooksButton);
//		
		reserveBookButton = new JButton("Rezervacija knjige");
		reserveBookButton.addActionListener(e -> {
			setVisible(false);
			BrowseBooksFrame child = new BrowseBooksFrame(user, app);
			child.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					setVisible(true);
				}
			});
		});
		buttonPanel.add(reserveBookButton);
		
		requestMembershipButton = new JButton("Request Membership");
		requestMembershipButton.addActionListener(e -> {
			new RequestMembershipFrame(user, app);
		});
		buttonPanel.add(requestMembershipButton);
		
		cancelReservationButton = new JButton("Cancel Reservation");
		cancelReservationButton.addActionListener(e -> {
			new CancelReservationFrame(user, app);
		});
		buttonPanel.add(cancelReservationButton);
		
		reportButton = new JButton("Report");
		reportButton.addActionListener(e -> {
			new ReportFrame(user, app);
		});
		buttonPanel.add(reportButton);
		
		add(buttonPanel, BorderLayout.CENTER);
		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(e -> {
			dispose();
			new LoginfFrame(app);
		});
		add(logoutButton, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
        // Create dummy App and Member objects for testing
        App app = new App();
        Clanarina testClanarina = new Clanarina(
        		Clanarina.Type.GODISNJA, // type
            Clanarina.Status.ACTIVE, // status
            java.time.LocalDate.now(), // start date
            java.time.LocalDate.now().plusYears(1)
        );
        Member testMember = new Member(
            "Test", "User", Person.Gender.MUSKO, java.time.LocalTime.now(),
            "123456", "Test Address", "testuser", "testpass",
            Member.Kategorija.STUDENT, testClanarina, null
        );
        new MemberFrame(testMember, app);
    }

}