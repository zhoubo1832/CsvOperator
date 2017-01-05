package prd.csvoperator.view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import prd.csvoperator.controller.NextButtonController;
import prd.csvoperator.controller.PageListController;
import prd.csvoperator.controller.PrevButtonController;

public class PagePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton prevBtn = new JButton(ViewConstants.PREV);
	private JButton nextBtn = new JButton(ViewConstants.NEXT);
	private JComboBox<Integer> pageList = new JComboBox<Integer>();
	private JLabel totalPageLbl = new JLabel();
	
	private int pageNo = 1;
	private int totalCount;
	private int items;
	
	private ActionListener prevController;
	private ActionListener nextController;
	private ItemListener pageListController;
	
	public static PagePanel instance;
	
	public PagePanel() {
		PagePanel.instance = this;
		this.add(prevBtn);
		this.add(pageList);
		this.add(totalPageLbl);
		this.add(nextBtn);
		this.setVisible(false);
		
		prevController = new PrevButtonController();
		nextController = new NextButtonController();
		pageListController = new PageListController();
		
		this.prevBtn.addActionListener(prevController);
		this.nextBtn.addActionListener(nextController);
		this.pageList.addItemListener(pageListController);
		
	}

	
	private void initPageList(){
		int totalPage = totalCount/items;
		int j = totalCount%items;
		if(j > 0) {
			totalPage++;
		}
		
		pageList.removeAllItems();
		for(int k=1; k<=totalPage; k++) {
			pageList.addItem(k);
		}

		pageList.setSelectedItem(this.pageNo);
		totalPageLbl.setText(" / " + totalPage + " pages");
		
		this.prevBtn.setEnabled(true);
		this.nextBtn.setEnabled(true);
		
		if(this.pageNo == 1) {
			this.prevBtn.setEnabled(false);
		}
		
		if(totalPage == this.pageNo) {
			this.nextBtn.setEnabled(false);
		}
	}


	public void setPage(int pageNo, int totalCount, int items) {
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.items = items;
		
		this.initPageList();

		this.setVisible(true);
	}


	public int getPageNo() {
		return pageNo;
	}


	public JComboBox<Integer> getPageList() {
		return pageList;
	}
}
