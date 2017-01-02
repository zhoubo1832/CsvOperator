package prd.csvoperator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;


/**
 * <p>File list panel to display icon,file name,updated date and size.</p>
 * 
 * @author zhoubo
 * 
 */
public class MainPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private FileSelectPanel fileSelectPanel;
	private CsvPanel csvPanel;

	public static MainPanel instance;
	
	public MainPanel() {
		fileSelectPanel = new FileSelectPanel();
		
		// create file table using customized FileListTableModel
		csvPanel = new CsvPanel();
		
		scrollPane = new JScrollPane(csvPanel);
	    scrollPane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		scrollPane.setBorder(null);
		
		
		setLayout(new BorderLayout());
		
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
	
		this.add(fileSelectPanel,BorderLayout.NORTH);
		
		// add table body
		add(scrollPane,BorderLayout.CENTER);	
		
		instance = this;
	}

	public CsvPanel getCsvPanel() {
		return csvPanel;
	}
}
