package containers;

import java.util.*;
import static net.mindview.util.Print.*;

public class CountedString {
	private static List<String> created = new ArrayList<>();
	private String s;
	private int id = 0;
	public CountedString(String str) {
		s = str;
		created.add(s);
		//id is hte totla number of instances of this string in use by CountedString
		for (String s2 : created) {
			if(s2.equals(s)) {
				id++;
			}
		}
	}

	public String toString() {
		return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
	}

	public int hashCode() {
		//The very simple approach, return s.hashCode() * id; Using Joshua Bloch's recipe
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}

	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}else {
			if(o.getClass() == CountedString.class) {
				CountedString c = (CountedString)o;
				return s.equals(c.s) && id == c.id;
			}else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		Map<CountedString, Integer> map = new HashMap<>();
		CountedString[] cs = new CountedString[5];
		for(int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString("hi");
			map.put(cs[i], i);
		}
		print(map);
		for(CountedString csString : cs) {
			print(map.get(csString));
		}
	}
}