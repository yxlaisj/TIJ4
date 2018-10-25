package containers;

import java.util.*;
import net.mindview.util.*;

class StringContainer {
	private String[] array;
	private int index;
	private static final int INCR = 255;
	public StringContainer() {
		array = new String[10];
	}
	public StringContainer(int size) {
		array = new String[size];
	}
	public void add(String s) {
		if(index >= array.length) {
			String[] temp = new String[array.length + INCR];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			index = array.length;
			array = temp;
		}
		array[index++] = s;
	}
	public String get(int i){
		return array[i];
	}
	public int size() {
		return index;
	}
}

public class Exercise31 {
	static final int LOOPS = 10000;
	static List<Test<List<String>>> alTests = new ArrayList<>();
	static List<Test<StringContainer>> scTests = new ArrayList<>();
	static {
		alTests.add(new Test<List<String>>("addGet"){

			int test(List<String> list, TestParam tp){
				for(int i = 0; i < LOOPS; i++){
					list.add(Integer.toString(i));
					list.get(i);
				}
				return LOOPS;
			}
		});

		scTests.add(new Test<StringContainer>("addGet"){

			int test(StringContainer sc, TestParam tp){
				for(int i = 0; i < LOOPS; i++){
					sc.add(Integer.toString(i));
					sc.get(i);
				}
				return LOOPS;
			}
		});
	}
	public static void main(String[] args) {
		Tester.defaultParams = TestParam.array(LOOPS, 1);
		Tester.run(new ArrayList<String>(LOOPS), alTests);
		Tester.run(new StringContainer(LOOPS), scTests);
	}
}