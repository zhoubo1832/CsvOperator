package prd.csvoperator.controller;

import prd.csvoperator.view.FileSelectPanel;
import prd.csvoperator.view.PagePanel;

public class NextButtonController extends BaseController{

	@Override
	protected int getPageNo() {
		return PagePanel.instance.getPageNo() + 1 ;
	}

}
