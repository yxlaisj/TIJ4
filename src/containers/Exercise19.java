package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise19 {
	public static void main(String[] args) {
		TextFile file = new TextFile("Exercise13.java", "\\W+");
		SimpleHashMap<String, Integer> wordCounter = new SimpleHashMap<String, Integer>();
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