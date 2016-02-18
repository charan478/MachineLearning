import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class sampleSubmission {

	public static void main(String[] args) throws IOException {
	//C:\\Users\\RamCharanTeja\\Downloads\\SubmissionFile.csv
		String [] arr= {"ecoli","salmonella","staphylococus","listeria"};
		Random rand= new Random();
		File file= new File("G:\\ml\\data\\Test_Images\\");
		String [] list=file.list();
		int i=0;
		for(String a:list)
		{i++;
			System.out.println(a.substring(0, a.indexOf("."))+","+arr[rand.nextInt(4)]);
		}
		//System.out.println(i);
		BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\RamCharanTeja\\Downloads\\SubmissionFile.csv"));
		BufferedWriter bw= new BufferedWriter(new FileWriter("C:\\Users\\RamCharanTeja\\Downloads\\testsubmission.csv"));
		String buff;
		
		

		while ((buff = br.readLine()) != null) {
			//System.out.println(buff+arr[rand.nextInt(4)]);
			/*ecoli
salmonella
staphylococus
listeria
*/
		}
	br.close();//
	bw.close();
		}
	}


