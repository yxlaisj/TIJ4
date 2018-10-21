package containers;

import java.util.*;
import static net.mindview.util.Print.*;

public class CountedString {
	private static List<String> created = new ArrayList<>();
	private String s;
	private char c;
	private int id = 0;
	public CountedString(String str, char ch) {
		s = str;
		c = ch;
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
		result = 37 * result + c;
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
				CountedString cs = (CountedString)o;
				return s.equals(cs.s) && id == cs.id && c == cs.c;
			}else {
			
				return false;
			}
		}
	}
}