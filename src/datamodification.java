import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class datamodification {
public static void main(String [] args) throws IOException
{
	String sCurrentLine;
	
	 System.out.println("hai");
	 //"C:\Users\RamCharanTeja\Desktop\dm project\train.csv (1)\trainreduced.csv"
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\train.csv (1)\\trainreduced.csv"));
	BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\train.csv (1)\\trainreducedidremoved.csv"));
	while ((sCurrentLine = br.readLine()) != null) {
	//	System.out.println("inside");
		String t[]=sCurrentLine.split(",");
		StringBuilder sb= new StringBuilder(); 
		for(int i=1;i<t.length-1;i++)
		{
			sb.append(t[i]+",");
		}
		sb.append(t[t.length-1]);
		bw.write(sb.toString()+"\n");
		//System.out.println(sCurrentLine);
		//System.out.println(sb.toString());
	}
br.close();
bw.close();

/*	for(int i=1;i<=40;i++)
		{
			System.out.print(i+",");
		}
		*/
}
}