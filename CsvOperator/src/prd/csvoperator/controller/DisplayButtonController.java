package prd.csvoperator.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import prd.csvoperator.model.FileModel;
import prd.csvoperator.view.CsvPanel;
import prd.csvoperator.view.FileSelectPanel;
import prd.csvoperator.view.MainPanel;

public class DisplayButtonController implements ActionListener{

	private FileSelectPanel panel;
	
	public DisplayButtonController(FileSelectPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		List<ArrayList<String>> vecData = FileModel.getCsvRecords(panel.getFileTf().getText());
		CsvPanel panel = MainPanel.instance.getCsvPanel();
		panel.showData(vecData);
	}

}
