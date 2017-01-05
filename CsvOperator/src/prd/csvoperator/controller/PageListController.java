package prd.csvoperator.controller;

import prd.csvoperator.view.PagePanel;

public class PageListController extends BaseController{

	@Override
	protected int getPageNo() {
		return (int) PagePanel.instance.getPageList().getSelectedItem();
	}

	
}
