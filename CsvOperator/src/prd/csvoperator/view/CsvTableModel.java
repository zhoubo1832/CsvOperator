package prd.csvoperator.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * <p>File list table model.</p>
 * 
 * @author zhoubo
 * 
 */
public class CsvTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;

	private List<ArrayList<String>> vecData;
	
	private final List<String> columNames = new ArrayList<String>();


	public CsvTableModel() {
		
	}
	
	public CsvTableModel(List<ArrayList<String>> vecData) {
		this.vecData = vecData;
		int colNum = 0;
		if(vecData.size() > 0) {
			if(vecData.size() > 1) {
				colNum = vecData.get(1).size();
			} else {
				colNum = vecData.get(0).size();
			}
			columNames.add("#");
			for(int i=0; i<colNum; i++) {
				columNames.add("#" + String.valueOf(i + 1));
			}
		}
	}

	@Override
	public int getRowCount() {
		return vecData.size();
	}

	@Override
	public int getColumnCount() {
		return columNames.size();
	}

	@Override
	public String getColumnName(int column) {
		return columNames.get(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return (rowIndex + 1);
		} else {
			try{
				return vecData.get(rowIndex).get(columnIndex-1);
			} catch(IndexOutOfBoundsException e) {
				return "";
			}
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if(columnIndex == 0) {
			return Integer.class;
		}
		return Object.class;
	}

	public void clear() {
		vecData.clear();
		this.fireTableDataChanged();
	}
}
