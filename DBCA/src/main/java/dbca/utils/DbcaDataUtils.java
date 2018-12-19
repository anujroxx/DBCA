package dbca.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dbca.domain.DbcaData;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

/**
 * 
 * @author Anuj Kumar
 *
 *	engineLoad; 
 *	engineRpm;
 *	maf;
 *	speed;
 *	throttlePos; 
 *	timingAdvance;
 */

public class DbcaDataUtils {
	
	private Instances dataset;
	private ArrayList<Attribute> attributes;
	
	public DbcaDataUtils() {
		createInstances();
	}
	
	private void createInstances() {
		this.dataset = new Instances("dataset", createAttributesToDbcaData(), 0);
		this.dataset.setClassIndex(this.dataset.numAttributes() - 1);;
	}
	
	private ArrayList<Attribute> createAttributesToDbcaData() {
		
		this.attributes = new ArrayList<Attribute>();
	
		attributes.add(new Attribute("engineLoad"));
		attributes.add(new Attribute("engineRpm"));
		attributes.add(new Attribute("maf"));
		attributes.add(new Attribute("speed"));
		attributes.add(new Attribute("throttlePos"));
		attributes.add(new Attribute("timingAdvance"));
	
		//Create Class Attribute
		attributes.add(new Attribute("cluster", createValuesForClass()));
		
		return attributes;
	}
	
	private List<String> createValuesForClass() {

		List<String> classValues = new ArrayList<String>();

		classValues.add(new String("cluster1"));
		classValues.add(new String("cluster2"));

		return classValues;
	}
		
	public Instance dbcaDataToWekaInstance(DbcaData dbcaData) {
		
		double[] values = new double[dataset.numAttributes()];

		values[0] = dbcaData.getEngineLoad();
		values[1] = dbcaData.getEngineRpm();
		values[2] = dbcaData.getMaf();
		values[3] = dbcaData.getSpeed();
		values[4] = dbcaData.getThrottlePos();
		values[5] = dbcaData.getTimingAdvance();
		values[6] = dataset.attribute(6).indexOfValue(dbcaData.getDriverBehavior());
		
		Instance instance = new DenseInstance(1, values);
		
		return instance;
		
	}
	
 	public Instances getDataset() {
		return dataset;
	}

	public void setDataset(Instances dataset) {
		this.dataset = dataset;
	}
	
}
