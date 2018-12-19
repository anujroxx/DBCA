package dbca.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dbca.domain.DbcaData;
import dbca.domain.MachineLearningModel;
import dbca.utils.DbcaDataUtils;
import weka.core.Instance;

@RestController
@RequestMapping("/dbca")
public class DbcaController {

	@Autowired
	private MachineLearningModel mlm;

	//New DbcaData classification
	@RequestMapping(method = RequestMethod.POST,headers = "Content-Type=application/json")
	public DbcaData classifyIrisFlowe(@RequestBody DbcaData d) {
		DbcaData dbca = d;
		dbca.setDriverBehavior("cluster1");
		
		String classValue = new String(classifyDbcaData(dbca));
		
		dbca.setDriverBehavior(changeLabel(classValue));
		
		return dbca;
	}
	
	private String classifyDbcaData(DbcaData dbcaData) {
		DbcaDataUtils dbcaDataUtils = new DbcaDataUtils();
		
		Instance instance = dbcaDataUtils.dbcaDataToWekaInstance(dbcaData);
		
		dbcaDataUtils.getDataset().add(instance);
		
		double value = -1;
		try {
			value = mlm.getCls().classifyInstance(dbcaDataUtils.getDataset().get(0));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//get the irisClass value
		String prediction = null; 
		prediction = new String(dbcaDataUtils.getDataset().classAttribute().value((int)value));
		
		return prediction;
	}
	
	public String changeLabel(String actual) {
		String newLabel = new String();
		if(actual.equals("cluster1")) {
			newLabel = "unsafe";
		}
		else if(actual.equals("cluster2")) {
			newLabel = "safe";
		}
		return newLabel;
	}
	
}
