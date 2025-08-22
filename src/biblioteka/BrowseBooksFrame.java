package biblioteka;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import javax.swing.*;

public class BrowseBooksFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BrowseBooksFrame(Member member, App app) {
		setSize(400, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Pretraga knjiga");
		setLayout(new GridLayout(2, 2));
		JLabel label = new JLabel("Unesite naslov knjige:");
		JTextField textField = new JTextField();
		JButton searchButton = new JButton("Pretraži");
		searchButton.addActionListener(e -> {
			String title = textField.getText();
			if (title.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Molimo unesite naslov knjige.", "Greška",
						JOptionPane.ERROR_MESSAGE);
			} else {
				var books = app.getBooks();
				for (Book book : books) {
					if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
						setVisible(false);
						JDialog dialog = new JDialog();
						dialog.setTitle("Rezultat pretrage");
						dialog.setSize(300, 200);
						dialog.setLayout(new GridLayout(5, 1));

						dialog.add(new JLabel("Naslov: " + book.getTitle(), SwingConstants.CENTER));
						dialog.add(new JLabel("Autor: " + book.getAuthor(), SwingConstants.CENTER));
						dialog.add(new JLabel("Zanra: " + book.getGenre(), SwingConstants.CENTER));
						dialog.add(new JLabel("Status: " + book.getStatus(), SwingConstants.CENTER));

						JPanel buttonPanel = new JPanel();
						buttonPanel.setLayout(new FlowLayout());
						JButton cancelButton = new JButton("Cancel");
						JButton reserveButton = new JButton("Rezervisi");
						cancelButton.addActionListener(ev -> {
							dialog.dispose();
							setVisible(true);
						});
						if (book.getStatus() == Book.Status.IZDATA) {
							reserveButton.setEnabled(false);
							reserveButton.setToolTipText("Knjiga je trenutno izdata i nije dostupna za rezervaciju.");
						}
						if (member.getPenaltyUntil() != null && LocalDateTime.now().isBefore(member.getPenaltyUntil())) {
							JOptionPane.showMessageDialog(dialog, "Imate aktivnu kaznu. Ne možete rezervisati knjige dok kazna ne istekne.", "Greška",
									JOptionPane.ERROR_MESSAGE);
							reserveButton.setEnabled(false);
						}
						reserveButton.addActionListener(ev -> {
							if (member.getClanarina().getStatus() == Clanarina.Status.ACTIVE) {
								JDialog dialogDate = new JDialog();
								dialogDate.setTitle("Datum rezervacije");
								dialogDate.setSize(300, 150);
								dialogDate.setLayout(new GridLayout(3, 1));
								dialogDate.add(
										new JLabel("Unesite datum rezervacije (yyyy-MM-dd):", SwingConstants.CENTER));
								JTextField dateField = new JTextField();
								JButton confirmButton = new JButton("Potvrdi");
								confirmButton.addActionListener(dv -> {
									String date = dateField.getText();
									if (date.isEmpty()) {
										JOptionPane.showMessageDialog(dialogDate, "Molimo unesite datum.", "Greška",
												JOptionPane.ERROR_MESSAGE);
									} else {
										LocalDate dateParsed;

										try {
											dateParsed = LocalDate.parse(date);
										} catch (DateTimeParseException e1) {
											JOptionPane.showMessageDialog(dialogDate,
													"Neispravan format datuma. Molimo unesite u formatu yyyy-MM-dd.",
													"Greška", JOptionPane.ERROR_MESSAGE);
											return;
										}

										if (dateParsed.isBefore(LocalDate.now())) {
											JOptionPane.showMessageDialog(dialogDate, "Datum ne može biti u prošlosti.",
													"Greška", JOptionPane.ERROR_MESSAGE);
											return;
										}

										// extra features dialog
										JDialog extraFeaturesDialog = new JDialog();
										extraFeaturesDialog.setTitle("Izaberite dodatne usluge (opcionalno)");
										extraFeaturesDialog.setSize(300, 200);
										extraFeaturesDialog.setLayout(new GridLayout(5, 1));
										JCheckBox priorityPreuzimanje = new JCheckBox("Pririotetno preuzimanje");
										JCheckBox priorityVracanje = new JCheckBox("Pririotetno vraćanje");
										JCheckBox extendedRok = new JCheckBox("Produženo zadržavanje");

										JPanel extendDays = new JPanel();
										extendDays.setLayout(new FlowLayout());
										JTextField daysField = new JTextField(5);
										extendDays.add(new JLabel("Unesite broj dana za produženje:"));
										extendDays.add(daysField);
										extendDays.setVisible(false);

										extendedRok.addActionListener(ea -> {
											if (extendedRok.isSelected()) {
												extendDays.setVisible(true);
											} else {
												extendDays.setVisible(false);
											}
										});
										JButton confirmFeaturesButton = new JButton("Potvrdi");

										confirmFeaturesButton.addActionListener(eve -> {
											boolean isPriorityPreuzimanje = priorityPreuzimanje.isSelected();
											boolean isPriorityVracanje = priorityVracanje.isSelected();
											boolean isExtendedRok = extendedRok.isSelected();
											int days = 0;
											if (isExtendedRok) {
												if (daysField.getText().isEmpty()) {
													days = 0;
												} else {
													try {
														days = Integer.parseInt(daysField.getText());
														if (days < 0) {
															JOptionPane.showMessageDialog(extraFeaturesDialog,
																	"Broj dana ne može biti negativan.", "Greška",
																	JOptionPane.ERROR_MESSAGE);
															return;
														}
													} catch (NumberFormatException e1) {
														JOptionPane.showMessageDialog(extraFeaturesDialog,
																"Morate uneti broj.", "Greška",
																JOptionPane.ERROR_MESSAGE);
														return;
													}
												}
											}
											extraFeaturesDialog.dispose();
											
											member.reservation(book, dateParsed, isPriorityPreuzimanje,
													isPriorityVracanje, isExtendedRok, days, app.getReservations());
											JOptionPane.showMessageDialog(dialog, "Zahtev za rezervaciju je poslat.",
													"Rezervacija", JOptionPane.INFORMATION_MESSAGE);
											dialogDate.dispose();
											dialog.dispose();
											dispose();
										});

										extraFeaturesDialog.add(priorityPreuzimanje);
										extraFeaturesDialog.add(priorityVracanje);
										extraFeaturesDialog.add(extendedRok);
										extraFeaturesDialog.add(extendDays);
										extraFeaturesDialog.add(confirmFeaturesButton);
										extraFeaturesDialog.setVisible(true);

									}
								});
								dialogDate.add(dateField);
								dialogDate.add(confirmButton);
								dialogDate.setVisible(true);

							} else {
								JOptionPane.showMessageDialog(dialog, "Istekla vam je clanarina.", "Greška",
											JOptionPane.ERROR_MESSAGE);
								
								dialog.dispose();
								setVisible(true);
							}
						});
						buttonPanel.add(cancelButton);
						buttonPanel.add(reserveButton);
						dialog.add(buttonPanel);

						dialog.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(this, "Nema knjiga sa tim naslovom.", "Rezultat pretrage",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		add(label);
		add(textField);
		add(new JLabel());
		add(searchButton);

		setLocationRelativeTo(null);
        setVisible(true);
	}
}