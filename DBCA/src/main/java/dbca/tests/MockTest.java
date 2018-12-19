package dbca.tests;

import java.util.ArrayList;

import dbca.domain.DbcaData;
import dbca.mockdata.MockReadings;

public class MockTest {

	public static void main(String[] args) {
		ArrayList<DbcaData> readings = MockReadings.createReadings();

		for (DbcaData d: readings) {
			System.out.println(d.toString());
			System.out.println();
		}
	}

}
