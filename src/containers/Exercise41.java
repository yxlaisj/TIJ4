package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise41 {

	static List<ToBeSort> getObjects() {
		List<ToBeSort> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new ToBeSort(new RandomGenerator.String().next(),
				new RandomGenerator.String().next()));
		}
		return list;
	}

	public static void main(String[] args) {
		Set<ToBeSort> set = new HashSet<>();
		Map<ToBeSort, Integer> map = new HashMap<>();
		set.addAll(getObjects());
		int index = 0;
		for(ToBeSort o : set) {
			map.put(o, index++);
			System.out.println(o);
		}

		System.out.println(map.get(new ToBeSort("gqiaxxE","AJJmzMs")));
	}
}