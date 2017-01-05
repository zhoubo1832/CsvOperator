package prd.csvoperator.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class CsvPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	
	private JTable csvTable;
	
	private PagePanel pagePanel = new PagePanel();
	
	public CsvPanel() {
		CsvTableModel model = new CsvTableModel(new ArrayList<ArrayList<String>>());
		csvTable = new JTable(model);
		
		scrollPane = new JScrollPane(csvTable);
		scrollPane.setBorder(null);
	
		setLayout(new BorderLayout());
		this.add(scrollPane,BorderLayout.CENTER);
		this.add(pagePanel,BorderLayout.SOUTH);
	}
	
	public void showData(List<ArrayList<String>> vecData, int pageNo, int totalCount, int items) {
		CsvTableModel model = new CsvTableModel(vecData);		
		csvTable.setModel(model);
		csvTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		csvTable.setRowSorter(sorter);
		
		csvTable.getColumnModel().getColumn(0).setCellRenderer(new CsvTableRender());
		
		pagePanel.setPage(pageNo, totalCount, items);

		this.add(pagePanel,BorderLayout.SOUTH);
		this.revalidate();
		this.repaint();
	}
}
