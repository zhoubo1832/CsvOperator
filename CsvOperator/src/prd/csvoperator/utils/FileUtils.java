package prd.csvoperator.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileUtils {

	public static List<String> getLineItems(String lineStr, String sDelim) {
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(lineStr,sDelim,true);
		String befStr = null;
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			if( !sDelim.equals(str) ) {
				list.add(str);
			} else {
				if(sDelim.equals(befStr)) {
					list.add("");
				}
			}
			befStr = str;
		}
		if(sDelim.equals(befStr)) {
			list.add("");
		}
		return list;
	}
}
