package org.kobic.s4dncv;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.kobic.s4dncv.swing.MainFrame;

public class J4DNucleomeViewer {
	public J4DNucleomeViewer() {
		this.initLookAndFeel();
	}

	private void initLookAndFeel() {
		try {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
			System.setProperty("com.apple.mrj.application.apple.menu.about.name", "4DNucleomeViewer");
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(ClassNotFoundException e) {
		    System.out.println("ClassNotFoundException: " + e.getMessage());
		}
		catch(InstantiationException e) {
		    System.out.println("InstantiationException: " + e.getMessage());
		}
		catch(IllegalAccessException e) {
		    System.out.println("IllegalAccessException: " + e.getMessage());
		}
		catch(UnsupportedLookAndFeelException e) {
		    System.out.println("UnsupportedLookAndFeelException: " + e.getMessage());
		}		
	}

	public void launchJ4DNucleomViewer() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
				// TODO Auto-generated method stub
				MainFrame frame = new MainFrame("4D Nucleome Viewer Ver. 0.1a");
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double width = screenSize.getWidth();
				double height = screenSize.getHeight();
				
				frame.setSize( (int)(width * 0.7), (int)(height * 0.7) );

				int aa = (int)((width - frame.getWidth())/2);
				int bb = (int)((height - frame.getHeight()) / 2 );
				
				frame.setLocation( aa, bb );
				
				frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

				frame.setVisible(true);
		    }
		});

	}

	public static void main(String[] args) throws MalformedURLException {
		J4DNucleomeViewer viewer = new J4DNucleomeViewer();
		
		viewer.launchJ4DNucleomViewer();
//		final SplashScreen splash = SplashScreen.getSplashScreen();
//        if (splash == null) {
//            System.out.println("SplashScreen.getSplashScreen() returned null");
//            return;
//        }
//
//        Graphics2D g = splash.createGraphics();
//        if (g == null) {
//            System.out.println("g is null");
//            return;
//        }
	}
}