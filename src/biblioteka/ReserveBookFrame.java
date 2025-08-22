package biblioteka;

import javax.swing.JFrame;

public class ReserveBookFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReserveBookFrame(Member user, App app) {
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Reserve Book");
		
		setVisible(true);
	}

}
