package containers;

import java.util.*;

public class Exercise26 {

	public static void main(String[] args) {
		Map<CountedString, Integer> map = new HashMap<>();
		for (int i = 0; i < 5; i++) {	
			CountedString cs = new CountedString("hi", (char)('a'+i));
			map.put(cs, i);
		}
		System.out.println(map);
	}
}