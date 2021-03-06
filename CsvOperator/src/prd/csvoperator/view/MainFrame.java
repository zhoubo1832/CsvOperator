package prd.csvoperator.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * <p>Main frame and application's entry.</p>	
 * 
 * @author zhoubo
 * 
 */
public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static MainFrame instance;
	
	public MainFrame() {
		this.setContentPane(new MainPanel());
		this.setTitle(ViewConstants.MAIN_FRAME_TITLE);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
				// create main frame
				instance = new MainFrame();
		}});
	}
}
