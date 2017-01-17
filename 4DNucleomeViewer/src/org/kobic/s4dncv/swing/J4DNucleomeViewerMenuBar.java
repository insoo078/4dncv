package org.kobic.s4dncv.swing;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class J4DNucleomeViewerMenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2617745684112734881L;

	public J4DNucleomeViewerMenuBar() {
		JMenu helpMenu = new JMenu("Help");

		this.add( this.getFileMenu() );
		this.add( helpMenu );
	}
	
	public JMenu getFileMenu() {
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		JMenuItem configMenuItem = new JMenuItem("Configuration");
		JMenuItem printMenuItem = new JMenuItem("Print");
		JMenuItem closeMenuItem = new JMenuItem("Close");
		
		fileMenu.add( openMenuItem );
		fileMenu.add(saveMenuItem );
		fileMenu.addSeparator();
		fileMenu.add( printMenuItem );
		fileMenu.add( configMenuItem );
		fileMenu.addSeparator();
		fileMenu.add( closeMenuItem );

		return fileMenu;
	}
}