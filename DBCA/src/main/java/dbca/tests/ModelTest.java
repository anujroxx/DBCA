package dbca.tests;

import java.io.IOException;

import dbca.domain.DbcaData;
import dbca.domain.MachineLearningModel;
import dbca.utils.DbcaDataUtils;
import weka.core.Instance;

public class ModelTest {

	public static MachineLearningModel mlm;
	public static DbcaData dbcaData;
	
	public static void main(String[] args) throws IOException {
		
		makeAndLoadModel();
		makeReadingFromCar();
		
		DbcaDataUtils dbcaDataUtils = new DbcaDataUtils();
		Instance instance = dbcaDataUtils.dbcaDataToWekaInstance(dbcaData);
		
		dbcaDataUtils.getDataset().add(instance);
		
		System.out.println(dbcaDataUtils.getDataset().toString() + "\n");
		
		double value = -1;
		try {
			value = mlm.getCls().classifyInstance(dbcaDataUtils.getDataset().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//get the name of the class value
		String prediction = new String(); 
		prediction = new String(dbcaDataUtils.getDataset().classAttribute().value((int)value));
		
		dbcaDataUtils.getDataset().get(0).setClassValue(prediction);
		
		System.out.println("Prediction: " + prediction + "\n");
		
		System.out.println(dbcaDataUtils.getDataset().toString() + "\n");
		
		System.out.println(dbcaDataUtils.getDataset().get(0).toString());
	}

	public static void makeReadingFromCar() {
		dbcaData = new DbcaData("01-K-4509","10-02-2018");
		
		dbcaData.setEngineLoad(0.1543);
		dbcaData.setEngineRpm(0.1346);
		dbcaData.setMaf(0.1523);
		dbcaData.setSpeed(0.1563);
		dbcaData.setThrottlePos(0.1342);
		dbcaData.setTimingAdvance(0.1523);
	}
	
	public static void makeAndLoadModel() {
		mlm = new MachineLearningModel();
		mlm.loadModel();
	}
}
