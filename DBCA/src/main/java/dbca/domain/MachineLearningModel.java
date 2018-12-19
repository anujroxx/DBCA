package dbca.domain;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import weka.classifiers.Classifier;
import weka.core.SerializationHelper;

@Component
public class MachineLearningModel {

	private Classifier cls;
	private String modelName;
	
	@PostConstruct
	public void loadModel() {
		//choose and load model
		this.modelName = new String("C:\\Users\\anujk\\Desktop\\ANUJ\\models\\anuj_norm_6_kmeans_k2_s11_mlp_cross.model");
		try {
			this.cls = (Classifier) SerializationHelper.read(modelName);
			
		} catch (Exception e) {
			System.out.println("it wasn't possible to load the model: \n");
			e.printStackTrace();
		}		
	}

	public Classifier getCls() {
		return cls;
	}

	public void setCls(Classifier cls) {
		this.cls = cls;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
