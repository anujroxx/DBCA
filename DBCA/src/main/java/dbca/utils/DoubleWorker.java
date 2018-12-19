package dbca.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class DoubleWorker {

	private static double min = 0;
	private static double max = 1;
	private static int floatingpoints = 4;
	
	public static double randomDouble() {
		double random = ThreadLocalRandom.current().nextDouble(min, max);
		return round(random, floatingpoints);
	}
	
	private static double round(double value, int places) {
	    if (places < 0) {
	    	throw new IllegalArgumentException();
	    }
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	
	
}
