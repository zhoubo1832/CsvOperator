package prd.csvoperator.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import prd.csvoperator.controller.DisplayButtonController;
import prd.csvoperator.controller.ItemListController;

public class FileSelectPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel fileLabel = new JLabel(ViewConstants.FILE_LABEL_SELECT);
	private JTextField fileTf = new JTextField(30); 
	private JButton fileBtn = new JButton(ViewConstants.FILE_BUTTON_OPEN);
	private JButton displayBtn = new JButton(ViewConstants.FILE_BUTTON_DISPLAY);
	private JFileChooser fileChooser = new JFileChooser();
	private JLabel separatorLabel = new JLabel(ViewConstants.FILE_LABEL_SEPERATOR);
	private JTextField seperatorTf = new JTextField(5); 
	private JLabel pageRecord = new JLabel(ViewConstants.PAGE_RECORD);
	private JComboBox<Integer> itemsComBox = new JComboBox<Integer>(new Integer[]{20,50,100});
	private ActionListener controller;
	public static FileSelectPanel instance;
	
	public FileSelectPanel() {
		FileSelectPanel.instance = this;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		seperatorTf.setText("|");
		this.add(fileLabel);
		this.add(fileTf);
		this.add(fileBtn);
		this.add(displayBtn);
		this.add(separatorLabel);
		this.add(seperatorTf);
		this.add(pageRecord);
		this.add(itemsComBox);
		
		fileBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int retValue = fileChooser.showOpenDialog(instance);
				if(retValue == JFileChooser.APPROVE_OPTION) {
					instance.fileTf.setText(fileChooser.getSelectedFile().getPath());
				}
				
			}
			
		});
		
		controller = new DisplayButtonController();
		
		displayBtn.addActionListener(controller);
		itemsComBox.addItemListener(new ItemListController());
	}

	public JTextField getFileTf() {
		return fileTf;
	}

	public JTextField getSeperatorTf() {
		return seperatorTf;
	}

	public JComboBox<Integer> getItemsComBox() {
		return itemsComBox;
	}
}
