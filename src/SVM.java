//weka.classifiers.AdaBoostM1
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.HashSet;

import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.PolyKernel;
import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;


public class SVM {

	public static void main(String[] args) throws Exception {
		ArffLoader trainLoader = new ArffLoader();
		trainLoader.setSource(new File("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\train.csv (1)\\trainreducedidremoved.arff"));
		Instances trainDataSet = trainLoader.getDataSet();
		//trainDataSet.deleteAttributeAt(0);
		Attribute trainAttribute = trainDataSet.attribute(trainDataSet.numAttributes()-1);
		trainDataSet.setClass(trainAttribute);
		SMO classifier= new SMO();
		classifier.setC(500);
		classifier.setEpsilon(0.0001);
		classifier.setKernel(new PolyKernel());
		classifier.buildClassifier(trainDataSet);
//		classifier.buildClassifier(trainDataSet);
		ArffLoader test1Loader = new ArffLoader();
		test1Loader.setSource(new File("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\testreducedidremoved.arff"));
		Instances test1DataSet = test1Loader.getDataSet();
		Attribute test1Attribute = test1DataSet.attribute(test1DataSet.numAttributes()-1);
		test1DataSet.setClass(test1Attribute);
		//Enumeration test1Instances = test1DataSet.enumerateInstances();
		BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\RamCharanTeja\\Desktop\\dm project\\svm.csv"));
		System.out.println("model built");
		bw.write("Id,Cover_Type\n");
		HashSet<Integer> se= new HashSet<Integer>();
		int id=15121;
		for(int i=0;i<test1DataSet.numInstances();i++)
		{
			Instance instance1 = test1DataSet.instance(i);
			int classification = (int) (classifier.classifyInstance(instance1)+1);
			bw.write(id+","+classification+"\n");
			
			bw.flush();
			se.add(classification);
		//	System.out.println(classification+"---"+id);
			id++;
		}
		/*while (test1Instances.hasMoreElements()) {
			Instance instance1 = (Instance) test1Instances.nextElement();
			int identifier=(int)instance1.value(0);
			instance1.deleteAttributeAt(0);
			int classification = (int) (classifier.classifyInstance(instance1)+1);
			bw.write(identifier+","+classification+"\n");
			bw.flush();
			se.add(classification);
			System.out.println(classification+"---"+identifier);
			
		}*/
				System.out.println(se);
		

	}
}




