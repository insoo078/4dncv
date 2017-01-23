package org.kobic.s4dncv;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.kobic.s4dncv.com.Utils;
import org.kobic.s4dncv.engine.model.J4DNucleomeViewerEngine;
import org.kobic.s4dncv.swing.J4DNucleomeViewerSplashScreen;
import org.kobic.s4dncv.swing.MainFrame;

import com.apple.eawt.Application;
import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;

public class J4DNucleomeViewer{
	public J4DNucleomeViewer() {
		this.initLookAndFeel();
	}

	private void initLookAndFeel() {
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		    if( Utils.isOSX() ) {
				System.setProperty("apple.laf.useScreenMenuBar", "true");
				System.setProperty("com.apple.mrj.application.apple.menu.about.name", "4DNucleomeViewer");

				Application macApplication = Application.getApplication();
				macApplication.addApplicationListener( new ApplicationAdapter() {
					@Override
					public void handleQuit(ApplicationEvent e) {
						if (JOptionPane.showConfirmDialog(new JFrame(), 
				            "Are you sure to close this window?", "Really Closing?", 
				            JOptionPane.YES_NO_OPTION,
				            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				            System.exit(0);
				        }
					}
					@Override
					public void handleAbout(ApplicationEvent e) {
						// tell the system we're handling this, so it won't display
						// the default system "about" dialog after ours is shown.
						e.setHandled(true);
						JOptionPane.showMessageDialog(null, "Show About dialog here");
					}
					@Override
					public void handlePreferences(ApplicationEvent e) {
						JOptionPane.showMessageDialog(null, "Show Preferences dialog here");
					}
				});

			    // need to enable the preferences option manually
			    macApplication.setEnabledPreferencesMenu(true);
		    }
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

	private void backgroundWorkBySplash() {
		java.net.URL imgURL = this.getClass().getResource("resources/images/splash.gif");
		ImageIcon myImage = new ImageIcon( imgURL );

		final J4DNucleomeViewerSplashScreen screen = new J4DNucleomeViewerSplashScreen(myImage);
		screen.setLocationRelativeTo(null);
		screen.setProgressMax(100);
		screen.setScreenVisible(true);

		J4DNucleomeViewerEngine engine = new J4DNucleomeViewerEngine();
		try {
			engine.init();
			screen.setProgress("Database connection " + 10, 10);
			Thread.sleep(3000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		for (int i = 0; i <= 100; i++) {
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			// run either of these two -- not both
//			screen.setProgress("Yo " + i, i);  // progress bar with a message
//			//screen.setProgress(i);           // progress bar with no message
//		}
	    screen.setScreenVisible(false);
	}

	public void launchJ4DNucleomViewer() {
		this.backgroundWorkBySplash();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
				// TODO Auto-generated method stub
				final MainFrame frame = new MainFrame("4D Nucleome Viewer Ver. 0.1a");

				J4DNucleomeViewerEngine engine = new J4DNucleomeViewerEngine();
				try {
					engine.init();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				engine.close();

				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				double width = screenSize.getWidth();
				double height = screenSize.getHeight();
				
				frame.setSize( (int)(width * 0.7), (int)(height * 0.7) );

				int aa = (int)((width - frame.getWidth())/2);
				int bb = (int)((height - frame.getHeight()) / 2 );
				
				frame.setLocation( aa, bb );
				
				frame.addWindowListener(new java.awt.event.WindowAdapter() {
				    @Override
				    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				        if (JOptionPane.showConfirmDialog(frame, 
				            "Are you sure to close this window?", "Really Closing?", 
				            JOptionPane.YES_NO_OPTION,
				            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
				            System.exit(0);
				        }
				    }
				});

//				frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

				frame.setVisible(true);
		    }
		});
	}

	public static void main(String[] args) throws MalformedURLException {
		J4DNucleomeViewer viewer = new J4DNucleomeViewer();

		viewer.launchJ4DNucleomViewer();
	}
}