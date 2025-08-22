package biblioteka;

import java.util.ArrayList;

import javax.swing.*;

public class CancelReservationFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CancelReservationFrame(Member user, App app) {
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cancel Reservation");
		setLocationRelativeTo(null);
		ArrayList<Reservation> reservations = app.getMemberReservations(user);
		JPanel showReservations = UtilityFrames.showMemberReservationsFrame(reservations);
		int result = JOptionPane.showConfirmDialog(this, "Ukoliko ponistite rezervaciju necete moci da rezervisite jos jednu knjigu narednih 24h", "Confirm", JOptionPane.OK_CANCEL_OPTION);
		if (result != JOptionPane.OK_OPTION) {
			dispose();
			return;
		} else {
		if (reservations.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Nemate rezervacija.", "Info", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			return;
		}
		

		
		add(showReservations);
		setVisible(true);
		String input = JOptionPane.showInputDialog(null, "Unesite broj rezervacije koji zelite da ponistite:", "Input", JOptionPane.QUESTION_MESSAGE);

		if (input != null) {
		    try {
		        int choice = Integer.parseInt(input);
		        if (choice < 1 || choice > reservations.size()) {
		            JOptionPane.showMessageDialog(null, "Broj rezervacije je van opsega!", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        user.cancelReservation(reservations.get(choice - 1));
		    } catch (NumberFormatException e) {
		        JOptionPane.showMessageDialog(null, "Morate uneti broj", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		}
		}
	}
}