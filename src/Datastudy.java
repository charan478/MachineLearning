import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import weka.core.Instances;


public class Datastudy {
public static void main(String [] a) throws IOException
{
	HashMap<Integer,Integer> ma= new HashMap<Integer, Integer>();
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\train.csv (1)\\trainreduced.csv"));
	String sCurrentLine;
	int cou=0;
	while ((sCurrentLine = br.readLine()) != null) {
		if(cou==0)
		{
			cou++;
			continue;
		}
	//	System.out.println("inside");
		String t[]=sCurrentLine.split(",");
		int classval=Integer.parseInt(t[t.length-1]);
		if(ma.containsKey(classval))
		{
			ma.put(classval,ma.get(classval)+1);
		}
		else
		{
			ma.put(classval, 1);
		}
		
			}
	System.out.println(ma);
br.close();
	
}
}
