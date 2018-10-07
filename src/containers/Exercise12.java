package containers;

import java.util.*;
import static net.mindview.util.Print.*;

public class Exercise12 {
	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("sky", "blue");
		hashMap.put("grass", "green");
		hashMap.put("ocean", "dancing");
		hashMap.put("tree", "tall");
		hashMap.put("earth","brown");
		hashMap.put("sun","warm");
		print(hashMap);

		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("sky", "blue");
		treeMap.put("grass", "green");
		treeMap.put("ocean", "dancing");
		treeMap.put("tree", "tall");
		treeMap.put("earth","brown");
		treeMap.put("sun","warm");
		print(treeMap);

		Map<String, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("sky", "blue");
		linkedHashMap.put("grass", "green");
		linkedHashMap.put("ocean", "dancing");
		linkedHashMap.put("tree", "tall");
		linkedHashMap.put("earth","brown");
		linkedHashMap.put("sun","warm");
		print(linkedHashMap);
	}
}