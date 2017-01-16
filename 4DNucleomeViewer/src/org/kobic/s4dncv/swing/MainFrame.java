package org.kobic.s4dncv.swing;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6897036433376508918L;

	public MainFrame(String title) {
		super(title);
		
		
		J4DNucleomeViewerMenuBar menuBar = new J4DNucleomeViewerMenuBar();
		
		this.setJMenuBar(menuBar);
		
//		this.applyUIManager();
	}

	private void applyUIManager() {
		try {
            // Set cross-platform Java L&F (also called "Metal")
//	        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
	}
}