package org.kobic.s4dncv;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import javax.swing.JFrame;

import org.kobic.s4dncv.swing.MainFrame;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
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
}