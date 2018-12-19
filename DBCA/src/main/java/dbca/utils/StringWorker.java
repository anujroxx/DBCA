package dbca.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class StringWorker {

	public static HashMap<String,String> hashMapFromString(String hash) {
		
		String hashNew = new String();
		hashNew = hash.replace("\"", "");
		hashNew = hashNew.replace("{", "");
		hashNew = hashNew.replace("}", "");
		hashNew = hashNew.replace("\\", "");
		
		Map<String, String> myMap = new HashMap<String, String>();
		String[] pairs = hashNew.split(",");
		
		for (int i=0;i<pairs.length;i++) {
		    String pair = pairs[i];
		    String[] keyValue = pair.split(":");
		    myMap.put(keyValue[0], String.valueOf(keyValue[1]));
		}
		
		return (HashMap<String, String>) myMap;
	}
	
	public static HashMap<String,String> getHashMapFromString(String hash) {
		Gson gson = new Gson();
		HashMap<String,String> h = new HashMap<>();
		h = gson.fromJson(hash, HashMap.class);
		return h;
	}
	
}