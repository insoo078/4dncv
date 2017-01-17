package org.kobic.s4dncv.com;

public class Utils {
	public static boolean isOSX() {
		String osName = System.getProperty("os.name");
		return osName.contains("OS X");
	}
}