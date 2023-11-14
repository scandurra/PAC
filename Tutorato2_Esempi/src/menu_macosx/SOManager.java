package menu_macosx;

import java.awt.event.*;

//Questa classe gestisce le operazioni di individuazione del SO host
public class SOManager {
	/**
	 * Costante indicante il SO Mac OS X
	 */
	public final static int MAC_OS_X = 0;

	/**
	 * Costante indicante il SO Windows
	 */
	public final static int WINDOWS = 1;

	/**
	 * Costante indicante il SO Linux
	 */
	public final static int LINUX = 2;

	/**
	 * Costante indicante un SO sconosciuto
	 */
	public final static int UNKNOWN = 3;

	private static int so;

	static {
		String osName = System.getProperty("os.name").toLowerCase();

		if (osName.startsWith("mac os x"))
			so = SOManager.MAC_OS_X;
		else if (osName.startsWith("windows"))
			so = SOManager.WINDOWS;
		else if (osName.startsWith("linux"))
			so = SOManager.LINUX;
		else
			so = SOManager.UNKNOWN;
	}

	/**
	 * Restituisce il sistema operativo host
	 * 
	 * @return Il sistema operativo host
	 */
	public static int getSO() {
		return so;
	}

	/**
	 * Restituisce il bottone del mouse premuto
	 * 
	 * @param e L'evento di mouse
	 * @return Il bottone del mouse premuto
	 */
	public static int checkMouseButton(MouseEvent e) {
		int button = e.getButton();

		switch (SOManager.getSO()) {
		case SOManager.MAC_OS_X:
			if (button == MouseEvent.BUTTON1) {
				if (e.isControlDown())
					return MouseEvent.BUTTON3;
				else
					return MouseEvent.BUTTON1;
			} else
				return button;
		default:
			return button;
		}
	}
}