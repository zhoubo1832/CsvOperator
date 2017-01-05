package prd.csvoperator.view;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


/**
 * <p>File list panel to display icon,file name,updated date and size.</p>
 * 
 * @author zhoubo
 * 
 */
public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private FileSelectPanel fileSelectPanel;
	private CsvPanel csvPanel;
	public static MainPanel instance;
	
	public MainPanel() {
		fileSelectPanel = new FileSelectPanel();
		
		// create file table using customized FileListTableModel
		csvPanel = new CsvPanel();
				
		setLayout(new BorderLayout());
		
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	
		this.add(fileSelectPanel,BorderLayout.NORTH);
		
		// add table body
		this.add(csvPanel,BorderLayout.CENTER);	
	
		instance = this;
	}

	public CsvPanel getCsvPanel() {
		return csvPanel;
	}
}
