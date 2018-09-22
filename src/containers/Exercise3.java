package containers;

import java.util.*;
import static net.mindview.util.Countries.*;

public class Exercise3 {
	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<>();
		for (int i = 0; i< 5; i++){
			hashSet.addAll(names(6));
		}
		System.out.println("HashSet: " + hashSet);

		Set<String> linkedHashSet = new LinkedHashSet<>();
		for (int i = 0; i< 5; i++){
			linkedHashSet.addAll(names(6));
		}
		System.out.println("linkedHashSet: " + linkedHashSet);

		Set<String> treeSet = new TreeSet<>();
		for (int i = 0; i< 5; i++){
			treeSet.addAll(names(6));
		}
		System.out.println("treeSet: " + treeSet);
	}
}