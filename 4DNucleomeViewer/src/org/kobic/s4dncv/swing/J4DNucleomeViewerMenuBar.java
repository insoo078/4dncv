package org.kobic.s4dncv.swing;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class J4DNucleomeViewerMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2617745684112734881L;

	public J4DNucleomeViewerMenuBar() {
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");

		this.add( fileMenu );
		this.add( helpMenu );
	}
}
