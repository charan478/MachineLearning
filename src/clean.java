import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class clean {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		 
	
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader("C:\\Users\\RamCharanTeja\\Downloads\\charantest.arff"));
			BufferedWriter bw= new BufferedWriter(new FileWriter("C:\\Users\\RamCharanTeja\\Downloads\\charantestlab.arff"));
			boolean b=false;
			while ((sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.contains("@data"))
				{
					b=true;
				}
				if(b)
				{
					sCurrentLine=sCurrentLine+",?";
				}
				bw.write(sCurrentLine+"\n");
				
				bw.flush();
				//System.out.println(sCurrentLine);
			}
 br.close();

	}
}
