package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise39 {
	public static void main(String[] args) {
		SimpleHashMap7<String, String> m = new SimpleHashMap7<>();
		m.putAll(Countries.capitals(50));
		System.out.println(m);
	}
}