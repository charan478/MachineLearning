//weka.classifiers.AdaBoostM1
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.HashSet;

import weka.classifiers.lazy.IBk;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;


public class ADABoost {

	public static void main(String[] args) throws Exception {
		ArffLoader trainLoader = new ArffLoader();
		trainLoader.setSource(new File("G:\\ml\\train.arff"));
		Instances trainDataSet = trainLoader.getDataSet();
		//trainDataSet.deleteAttributeAt(0);
		Attribute trainAttribute = trainDataSet.attribute(trainDataSet.numAttributes()-1);
		trainDataSet.setClass(trainAttribute);
		AdaBoostM1 classifier= new AdaBoostM1();
		classifier.setSeed(5);
		classifier.setUseResampling(true);
		classifier.setNumIterations(100);
		J48 j=new J48();
		/*j.setBinarySplits(true);
		j.setNumFolds(10);
		*/classifier.setClassifier(j);
		///classifier.setClassifier(new IBk(1));
		classifier.buildClassifier(trainDataSet);
//		classifier.buildClassifier(trainDataSet);
		ArffLoader test1Loader = new ArffLoader();
		test1Loader.setSource(new File("G:\\ml\\test.arff"));
		Instances test1DataSet = test1Loader.getDataSet();
		Attribute test1Attribute = test1DataSet.attribute(test1DataSet.numAttributes()-1);
		test1DataSet.setClass(test1Attribute);
		//Enumeration test1Instances = test1DataSet.enumerateInstances();
		BufferedWriter bw=new BufferedWriter(new FileWriter("G:\\ml\\adabost.csv"));
		System.out.println("model built");
		bw.write("Image ID,Class\n");
		HashSet<Integer> se= new HashSet<Integer>();
		int id=15121;
		for(int i=0;i<test1DataSet.numInstances();i++)
		{
			Instance instance1 = test1DataSet.instance(i);
			int classification = (int) (classifier.classifyInstance(instance1)+1);
			bw.write(id+","+classification+"\n");
			
			bw.flush();
			se.add(classification);
			System.out.println(classification+"---"+id);
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


