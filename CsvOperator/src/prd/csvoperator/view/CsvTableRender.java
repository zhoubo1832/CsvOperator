package prd.csvoperator.view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * <p>File list table renderer.</p>
 * 
 * @author zhoubo
 * 
 */
public class CsvTableRender implements TableCellRenderer{
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Integer v = (Integer)value;		
		return (Component) new JButton(v.toString());
	}

}
