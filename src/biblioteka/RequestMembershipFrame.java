package biblioteka;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class RequestMembershipFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public RequestMembershipFrame(Member user, App app) {
		setTitle("Uplata clanarine");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(4, 1));
		
		if (user.getClanarina().getStatus() == Clanarina.Status.ACTIVE) {
			JOptionPane.showMessageDialog(this, "Vasa clanarina je vec aktivna.", "Greska", JOptionPane.ERROR_MESSAGE);
			dispose();
			return;
		}
		
		JLabel questionLabel = new JLabel("Koji tip clanarine zelite da uplatite?");
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		JRadioButton monthlyButton = new JRadioButton("Mesecna clanarina");
		monthlyButton.setHorizontalAlignment(SwingConstants.CENTER);
		monthlyButton.setFocusable(false);
		
		JRadioButton yearlyButton = new JRadioButton("Godisnja clanarina");
		yearlyButton.setHorizontalAlignment(SwingConstants.CENTER);
		yearlyButton.setFocusable(false);
		
		ButtonGroup membershipGroup = new ButtonGroup();
		membershipGroup.add(monthlyButton);
		membershipGroup.add(yearlyButton);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JButton confirmButton = new JButton("Potvrdi");
		JButton cancelButton = new JButton("Otkazi");
		confirmButton.setFocusable(false);
		cancelButton.setFocusable(false);
		
		confirmButton.addActionListener(e -> {
			if (monthlyButton.isSelected()) {
				user.requestForMembership(Clanarina.Type.MESECNA, app.getMembershipRequests());
			} else if (yearlyButton.isSelected()) {
				user.requestForMembership(Clanarina.Type.GODISNJA, app.getMembershipRequests());
			} else {
				JOptionPane.showMessageDialog(this,  "Prvo morate izaberati tip clanarine.", "Greska", JOptionPane.ERROR_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(this, "Zahtev za obnovu clanarine je poslat", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		});
		cancelButton.addActionListener(e -> {
			dispose();
		});
		
		buttonPanel.add(cancelButton);
		buttonPanel.add(confirmButton);

		add(questionLabel);
		add(monthlyButton);
		add(yearlyButton);
		add(buttonPanel);
		
		setVisible(true);
	}

	

}
