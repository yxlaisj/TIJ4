package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise9 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		ts.addAll(CollectionData.list(new RandomGenerator.String(), 10));
		System.out.println(ts);
	}
}