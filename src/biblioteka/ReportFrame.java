package biblioteka;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReportFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReportFrame(Member user, App app) {
		setSize(800, 600); 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Pregled stanja");
		setLocationRelativeTo(null);
		
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		ArrayList<Reservation> reservations = app.getMemberReservations(user);
		JPanel reservacijePanel = UtilityFrames.showMemberReservationsFrame(reservations);
		
		
		JPanel kaznePanel = new JPanel();
		kaznePanel.setLayout(new BoxLayout(kaznePanel, BoxLayout.Y_AXIS));
		JLabel kazneTitle = new JLabel("Pregled kazni");
		kazneTitle.setFont(new Font("Arial", Font.BOLD, 16));
		kaznePanel.add(kazneTitle);
		
		ArrayList<Kazna> kazne = app.getMemberKazne(user);
		
		if (kazne.isEmpty()) {
			kaznePanel.add(new JLabel("Nemate kazne."));
		} else {
			String[] kazneColumns = {"Iznos", "Razlog", "Datum", "Status"};
			DefaultTableModel kazneModel = new DefaultTableModel(kazneColumns, 0) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			for (Kazna kazna : kazne) {
				

				kazneModel.addRow(new Object[]{
					String.format("%.2f", kazna.getIznos()),
					kazna.getOpis(),
					kazna.getDatum(),
					kazna.getStatus()
				});
//			}
			JTable kazneTable = new JTable(kazneModel);
			kazneTable.setPreferredScrollableViewportSize(new Dimension(750, 150));
			JScrollPane kazneScrollPane = new JScrollPane(kazneTable);
			kaznePanel.add(kazneScrollPane);
			
			}
		}
		add(reservacijePanel);
		add(kaznePanel);
		setVisible(true);
	}}
