package dbca.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	private static SimpleDateFormat sdf;
	
	public static String formatDate(Date date) {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static Date parseString(String string) throws ParseException {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(string);
	}
}
