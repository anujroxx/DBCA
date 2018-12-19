 package dbca.tests;

import java.util.HashMap;

import com.google.gson.Gson;

import dbca.utils.StringWorker;

public class StringWorkerTest {

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		HashMap<String, String> hash2 = new HashMap<>();
		String base = new String("{engineRpm:0.7538,"
				+ 	" engineLoad:0.8195,"
				+ 	" speed:0.2398,"
				+ 	" idReadingFromCar:0,"
				+ 	" intakeManifoldPressure:0.4863,"
				+ 	" vehicleId:MTC-4052,"
				+ 	" predictedValue:cluster1,"
				+ 	" date:2018-04-16,"
				+ 	" idElement:0,"
				+ 	" maf:0.8129,"
				+ 	" timingAdvance:0.8278,"
				+ 	" throttlePos:0.3833,"
				+ 	" shortTermFuelTrimBank1:0.4165,"
				+ 	" engineCoolantTemp:0.7737}"
				);
		
		HashMap<String, String> hash = StringWorker.hashMapFromString(base);
					

		
	
		
		hash2 = gson.fromJson(base, HashMap.class);
		
		System.out.println(hash.toString());
		
		System.out.println();
		System.out.println(hash2.toString());
	}

}
