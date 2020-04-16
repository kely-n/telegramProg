package forwarder;

import java.awt.EventQueue;

import telegramProg.Run;

public class MainWindow extends Run{
	private Forwarder forwarder = new Forwarder();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.forwarder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}