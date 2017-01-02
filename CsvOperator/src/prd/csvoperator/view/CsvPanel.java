package prd.csvoperator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class CsvPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JTable csvTable;
	
	public CsvPanel() {
		// create file table using customized FileListTableModel
		CsvTableModel model = new CsvTableModel(new ArrayList<ArrayList<String>>());
		csvTable = new JTable(model);
		
		
		JScrollPane scrollPane = new JScrollPane(csvTable);
	    scrollPane.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		scrollPane.setBorder(null);
		this.add(scrollPane,BorderLayout.CENTER);
		
		setLayout(new BorderLayout());
		// add table body
		add(scrollPane,BorderLayout.CENTER);	
				
	}
	
	public void showData(List<ArrayList<String>> vecData) {
//		MainPanel.instance.getScrollPane().setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		// create file table using customized FileListTableModel
		CsvTableModel model = new CsvTableModel(vecData);		
		csvTable.setModel(model);
		csvTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		csvTable.setRowSorter(sorter);
		
		// set cell renderer for first column
		csvTable.getColumnModel().getColumn(0).setCellRenderer(new CsvTableRender());
		
		this.revalidate();
		this.repaint();
	}
}
