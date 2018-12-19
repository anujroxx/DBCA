package dbca.mockdata;

import java.util.ArrayList;
import java.util.Calendar;

import dbca.domain.DbcaData;
import dbca.utils.DateParser;
import dbca.utils.DoubleWorker;

public class MockReadings {
	
	public static ArrayList<DbcaData> createReadings(){
		
		ArrayList<DbcaData> readings = new ArrayList<DbcaData>();
		ArrayList<String> plates = new ArrayList<String>();
		plates.add(new String("01-M-4052"));
		plates.add(new String("02-M-5682"));
		plates.add(new String("01-M-6601"));
		plates.add(new String("03-M-6638"));
		plates.add(new String("02-M-5481"));
		plates.add(new String("01-M-8698"));
		plates.add(new String("01-M-0204"));
		plates.add(new String("05-M-5852"));
		plates.add(new String("02-M-2182"));
		plates.add(new String("07-M-2246"));
		
		for(String s: plates) {
			Calendar c = Calendar.getInstance();
			DbcaData dbca = new DbcaData(s, DateParser.formatDate(c.getTime()));
			
			dbca.setEngineLoad(DoubleWorker.randomDouble());
			dbca.setEngineRpm(DoubleWorker.randomDouble());
			dbca.setMaf(DoubleWorker.randomDouble());
			dbca.setSpeed(DoubleWorker.randomDouble());
			dbca.setThrottlePos(DoubleWorker.randomDouble());
			dbca.setTimingAdvance(DoubleWorker.randomDouble());
			
			readings.add(dbca);
		}
		
		return readings;
	}
	
	
	
}
