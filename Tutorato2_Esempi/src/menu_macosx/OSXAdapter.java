package menu_macosx;

import menu.MenuFrame;

//Una classe per gestire facilmente le funzionalit� dei menu di MacOSX
public class OSXAdapter {
	public static void registerMacOSXApplication(final MenuFrame inApp, boolean prefs) {
		/*
		 * if (inApp!=null) { com.apple.eawt.Application theApplication=new
		 * com.apple.eawt.Application();
		 * theApplication.setEnabledPreferencesMenu(prefs);
		 * 
		 * theApplication.addApplicationListener(new com.apple.eawt.ApplicationAdapter()
		 * { //Metodo per la gestione del menu "About" public void
		 * handleAbout(com.apple.eawt.ApplicationEvent ae) { ae.setHandled(true);
		 * inApp.about(); }
		 * 
		 * //Metodo per la gestione del menu delle "Preferenze" public void
		 * handlePreferences(com.apple.eawt.ApplicationEvent ae) { ae.setHandled(true);
		 * inApp.preferences(); }
		 * 
		 * //Metodo per la gestione del menu "Quit" public void
		 * handleQuit(com.apple.eawt.ApplicationEvent ae) { ae.setHandled(false);
		 * inApp.quit(); } }); }
		 */
	}
}
