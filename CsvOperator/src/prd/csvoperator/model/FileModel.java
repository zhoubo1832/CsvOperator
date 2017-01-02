package prd.csvoperator.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import prd.csvoperator.utils.FileUtils;

public class FileModel {

	private static final String PIPE = "|";
	
	public static List<ArrayList<String>> getCsvRecords(String path) {
		List<ArrayList<String>> vecData = new ArrayList<ArrayList<String>>();
		
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			
			String lineStr = null;
			ArrayList<String> listStr;
			
//			lineStr = reader.readLine();
			
			while((lineStr = reader.readLine()) != null) {
				listStr = (ArrayList<String>) FileUtils.getLineItems(lineStr, PIPE);
				vecData.add(listStr);
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
