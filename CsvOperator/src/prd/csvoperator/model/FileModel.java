package prd.csvoperator.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import prd.csvoperator.utils.FileUtils;
import prd.csvoperator.view.ViewConstants;

public class FileModel {

	public static int getCsvRecordCount(String path) {
		int count = 0;
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			String lineStr = null;
			while((lineStr = reader.readLine()) != null) {
				count++;
			}
		} catch(Exception e) {
			
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	
	public static List<ArrayList<String>> getCsvRecords(String path, String seperator, int pos, int items) {
		List<ArrayList<String>> vecData = new ArrayList<ArrayList<String>>();
		
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			
			String lineStr = null;
			ArrayList<String> listStr;
			
			String s = ViewConstants.PIPE;
			if( seperator != null && !"".equals(seperator)) {
				s = seperator;
			}
			int currentLine = 0;
			int readNum = 0;
			while(true) {
				if((lineStr = reader.readLine()) != null) {
					if(currentLine >= pos && readNum < items) {
						listStr = (ArrayList<String>) FileUtils.getLineItems(lineStr, s);
						vecData.add(listStr);
						readNum++;
						if(readNum == items) {
							break;
						}
					}
					currentLine++;
				} else {
					break;
				}
			}
		} catch(Exception e) {
			
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return vecData;
	}
}
