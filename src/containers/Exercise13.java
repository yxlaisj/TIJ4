package containers;

import java.util.*;
import net.mindview.util.TextFile;

public class Exercise13 {
	public static void main(String[] args) {
		TextFile file = new TextFile("Exercise13.java", "\\W+");
		AssociativeArray<String, Integer> wordCounter = new AssociativeArray<String, Integer>(file.size());
		for (String word : file) {
			if(wordCounter.get(word) != null) {
				wordCounter.put(word, wordCounter.get(word) + 1);
			}else {
				wordCounter.put(word, 1);
			}
		}
		System.out.println(wordCounter);
	}
}