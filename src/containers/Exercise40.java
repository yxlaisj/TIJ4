package containers;

import java.util.*;
import net.mindview.util.*;

class ToBeSort implements Comparable<ToBeSort>{
	protected String s1;
	protected String s2;

	public ToBeSort(String st1, String st2) {
		s1 = st1;
		s2 = st2;
	}

	@Override
	public int compareTo(ToBeSort other) {
		return s1.compareTo(other.s1);
	}

	public String toString() {
		return "( s1 = " + s1 + ", s2 = " + s2 + ")";
	}

	public boolean equals(Object o) {
		if (o == this) {return true;}
		if (o == null) {return false;}
		if (o.getClass() == getClass()) {
			ToBeSort other = (ToBeSort)o;
			return other.s1.equals(s1) && other.s2.equals(s2);
		}
		return false;
	}

	public int hashCode() {
		int result = 17;
		result = 31 * result + s1.hashCode();
		return (result = 31 * result + s2.hashCode());
	}

}

public class Exercise40 {
	public static void main(String[] args) {
		List<ToBeSort> l1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l1.add(new ToBeSort(new RandomGenerator.String().next(),
				new RandomGenerator.String().next()));
		}
		System.out.println(l1);
		Collections.sort(l1);
		System.out.println("after sorted");
		System.out.println(l1);
		int index = Collections.binarySearch(l1, new ToBeSort("PzDyCyR", "FJQAHxx"));
		System.out.println("index : " + index );
	}
}