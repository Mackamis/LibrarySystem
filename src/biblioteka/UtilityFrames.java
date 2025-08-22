package biblioteka;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class UtilityFrames {
	public static JPanel showMemberReservationsFrame(ArrayList<Reservation> reservations) {
		JPanel rezervacijePanel = new JPanel();
		rezervacijePanel.setLayout(new BoxLayout(rezervacijePanel, BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel("Pregled rezervacija");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		rezervacijePanel.add(titleLabel);
		
		int count = 0;
		if (reservations.isEmpty()) {
			rezervacijePanel.add(new JLabel("Nemate rezervacija."));
		} else {
			String[] columns = {"Br.", "Naslov knjige", "Datum", "Cena usluga", "Status"};
			DefaultTableModel model = new DefaultTableModel(columns, 0) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			for (Reservation reservation : reservations) {
				count++;
			
		        model.addRow(new Object[]{
		        	count,
		        	reservation.getBook().getTitle(), 
		        	reservation.getStartDate(), 
		        	reservation.getPrice(), 
		        	reservation.getStatus()
		        });
			}
			JTable table = new JTable(model);
			TableColumn counterColumn = table.getColumnModel().getColumn(0);
	        counterColumn.setPreferredWidth(40); 
	        counterColumn.setMaxWidth(50); 
			table.setPreferredScrollableViewportSize(new Dimension(750, 150));
			JScrollPane scrollPane = new JScrollPane(table);
	        rezervacijePanel.add(scrollPane);
	        
		}
		return rezervacijePanel;
	}
}
