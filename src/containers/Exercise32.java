package containers;

import java.util.*;
import net.mindview.util.*;

class IntegerContainer {
	private int[] array;
	private int index;
	private static final int INCR = 255;
	public IntegerContainer() {
		array = new int[10];
	}
	public IntegerContainer(int size) {
		array = new int[size];
	}
	public void add(int s) {
		if(index >= array.length) {
			int[] temp = new int[array.length + INCR];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			index = array.length;
			array = temp;
		}
		array[index++] = s;
	}
	public int get(int i){
		return array[i];
	}
	public int size() {
		return index;
	}
}

public class Exercise32 {
	static final int LOOPS = 10000;
	static List<Test<List<Integer>>> alTests = new ArrayList<>();
	static List<Test<IntegerContainer>> scTests = new ArrayList<>();
	static {
		alTests.add(new Test<List<Integer>>("addGet"){

			int test(List<Integer> list, TestParam tp){
				for(int i = 0; i < LOOPS; i++){
					list.add(i);
					list.get(i);
				}
				return LOOPS;
			}
		});

		scTests.add(new Test<IntegerContainer>("addGet"){

			int test(IntegerContainer sc, TestParam tp){
				for(int i = 0; i < LOOPS; i++){
					sc.add(i);
					sc.get(i);
				}
				return LOOPS;
			}
		});
	}
	public static void main(String[] args) {
		Tester.defaultParams = TestParam.array(LOOPS, 1);
		Tester.run(new ArrayList<Integer>(LOOPS), alTests);
		Tester.run(new IntegerContainer(LOOPS), scTests);
	}
}