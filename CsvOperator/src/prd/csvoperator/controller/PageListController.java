package prd.csvoperator.controller;

import java.awt.event.ItemEvent;

import javax.swing.JComboBox;

import prd.csvoperator.view.PagePanel;

public class PageListController extends BaseController{

	@Override
	protected int getPageNo() {
		return (int) PagePanel.instance.getPageList().getSelectedItem();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			return;
		}
		
		JComboBox<?> comBox = (JComboBox<?>)e.getSource();
		if(comBox.isFocusOwner()) {
			Integer selectedItem = (Integer)comBox.getSelectedItem();
		
			if( selectedItem != null && selectedItem.intValue() != PagePanel.instance.getPageNo()) {
				doAction();
			}
		}
	}
}
