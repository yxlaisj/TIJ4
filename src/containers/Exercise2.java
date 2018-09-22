package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise2 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for(String[] country : Countries.DATA) {
			if (country[0].startsWith("A")) {
				map.put(country[0], country[1]);
				set.add(country[0]);
			}
		} 
		System.out.println(map);

		System.out.println(set);

	}
}