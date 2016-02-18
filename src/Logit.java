//weka.classifiers.AdaBoostM1
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.HashSet;

import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.PolyKernel;
import weka.classifiers.meta.LogitBoost;
import weka.classifiers.rules.PART;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;


public class Logit {

	public static void main(String[] args) throws Exception {
		System.out.println(System.currentTimeMillis());
		ArffLoader trainLoader = new ArffLoader();
		trainLoader.setSource(new File("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\train.csv (1)\\charantrainreduced.arff"));
		Instances trainDataSet = trainLoader.getDataSet();
		Attribute trainAttribute = trainDataSet.attribute(13);
		trainDataSet.setClass(trainAttribute);
		LogitBoost classifier=new LogitBoost();
		//classifier.set
		//PART classifier= new PART();
		classifier.buildClassifier(trainDataSet);
		//classifier.set
		ArffLoader test1Loader = new ArffLoader();
		test1Loader.setSource(new File("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\charantestreduced.arff"));
		Instances test1DataSet = test1Loader.getDataSet();
		Attribute test1Attribute = test1DataSet.attribute(13);
		test1DataSet.setClass(test1Attribute);
		Enumeration test1Instances = test1DataSet.enumerateInstances();
		
		BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\logitboost.csv"));
		bw.write("Id,Cover_Type\n");
		System.out.println("model built");
		HashSet<Integer> se= new HashSet<Integer>();
		while (test1Instances.hasMoreElements()) {
			Instance instance1 = (Instance) test1Instances.nextElement();
			int classification = (int) (classifier.classifyInstance(instance1)+1);
			bw.write((int)instance1.value(0)+","+classification+"\n");
			bw.flush();
			se.add(classification);
			//System.out.println(classification+"---"+se.size());
			
		}
				System.out.println(se);
		bw.close();
		System.out.println(System.currentTimeMillis());
	}
	
}


