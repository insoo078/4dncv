package org.kobic.s4dncv.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

public class J4DNucleomeViewerSplashScreen extends JWindow {
	private static final long serialVersionUID = -2741215108322541312L;

	private BorderLayout borderLayout1;
	private JLabel imageLabel;
	private JPanel southPanel;
	private FlowLayout southPanelFlowLayout;
	private JProgressBar progressBar;
	private ImageIcon imageIcon;
	
	public J4DNucleomeViewerSplashScreen() {
		this.borderLayout1 = new BorderLayout();
		this.imageLabel = new JLabel();
		this.southPanelFlowLayout = new FlowLayout();
		this.progressBar = new JProgressBar();
		this.southPanel = new JPanel();
	}

	public J4DNucleomeViewerSplashScreen(ImageIcon imageIcon) {
		this();

		this.imageIcon = imageIcon;
		try {	
			this.jbInit();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	// note - this class created with JBuilder
	private void jbInit() throws Exception {
		this.imageLabel.setIcon(this.imageIcon);
		this.getContentPane().setLayout(this.borderLayout1);
		this.southPanel.setLayout(this.southPanelFlowLayout);
		this.southPanel.setBackground(Color.BLACK);
		this.getContentPane().add(this.imageLabel, BorderLayout.CENTER);
		this.getContentPane().add(this.southPanel, BorderLayout.SOUTH);
		this.southPanel.add(this.progressBar, null);
		this.pack();
	}

	public void setProgressMax(int maxProgress) {
		this.progressBar.setMaximum(maxProgress);
	}

	public void setProgress(String message, int progress) {
		final int theProgress = progress;
		final String theMessage = message;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				progressBar.setValue(theProgress);
				setMessage(theMessage);
			}
		});
	}

	public void setScreenVisible(boolean b) {
		final boolean boo = b;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setVisible(boo);
			}
		});
	}

	private void setMessage(String message) {
		if (message==null) {
			message = "";
			this.progressBar.setStringPainted(false);
		}else {
			this.progressBar.setStringPainted(true);
	    }
	    this.progressBar.setString(message);
	}
}