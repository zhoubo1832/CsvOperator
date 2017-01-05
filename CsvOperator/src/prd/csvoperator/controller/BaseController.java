package prd.csvoperator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import prd.csvoperator.model.FileModel;
import prd.csvoperator.view.CsvPanel;
import prd.csvoperator.view.FileSelectPanel;
import prd.csvoperator.view.MainPanel;
import prd.csvoperator.view.PagePanel;

public abstract class BaseController implements ActionListener, ItemListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		doAction();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			return;
		}
		
		JComboBox comBox = (JComboBox)e.getSource();
		if(comBox.isFocusOwner()) {
			Integer selectedItem = (Integer)comBox.getSelectedItem();
		
			if( selectedItem != null && selectedItem.intValue() != PagePanel.instance.getPageNo()) {
				doAction();
			}
		}
	}
	
	private void doAction() {
		String path = FileSelectPanel.instance.getFileTf().getText();
		File f = new File(path);
		if(f != null && f.exists()) {
			int pageNo = getPageNo();
			if(pageNo == -1) {
				return;
			}
			int items = (int)FileSelectPanel.instance.getItemsComBox().getSelectedItem();
			int totalCount = FileModel.getCsvRecordCount(path);
			
			List<ArrayList<String>> vecData = FileModel.getCsvRecords(path,FileSelectPanel.instance.getSeperatorTf().getText(), (pageNo - 1)*items, items);
			CsvPanel panel = MainPanel.instance.getCsvPanel();
			panel.showData(vecData, pageNo, totalCount, items);
		}
	}

	
	
	protected abstract int getPageNo();
	
}
