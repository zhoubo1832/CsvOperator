package prd.csvoperator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import prd.csvoperator.controller.DisplayButtonController;

public class FileSelectPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel fileLabel = new JLabel(ViewConstants.FILE_LABEL_SELECT);
	private JTextField fileTf = new JTextField(50); 
	private JButton fileBtn = new JButton(ViewConstants.FILE_BUTTON_OPEN);
	private JButton displayBtn = new JButton(ViewConstants.FILE_BUTTON_DISPLAY);
	private JFileChooser fileChooser = new JFileChooser();
	private ActionListener controller;
	private FileSelectPanel instance;
	
	public FileSelectPanel() {
		this.instance = this;
		
		this.add(fileLabel);
		this.add(fileTf);
		this.add(fileBtn);
		this.add(displayBtn);
		
		fileBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int retValue = fileChooser.showOpenDialog(instance);
				if(retValue == JFileChooser.APPROVE_OPTION) {
					instance.fileTf.setText(fileChooser.getSelectedFile().getPath());
				}
				
			}
			
		});
		
		controller = new DisplayButtonController(this);
		displayBtn.addActionListener(controller);
	}

	public JTextField getFileTf() {
		return fileTf;
	}
}
