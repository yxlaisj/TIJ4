package containers;

import java.util.*;
import net.mindview.util.TextFile;

public class Exercise15 {
	public static void main(String[] args) {
		TextFile file = new TextFile("Exercise15.java", "\\W+");
		SlowMap<String, Integer> slowMap = new SlowMap<>();
		for(String word : file) {
			if (slowMap.get(word) != null) {
				slowMap.put(word, slowMap.get(word) + 1);
			} else {
				slowMap.put(word, 1);
			}
		}
		System.out.println(slowMap);
	}
}