package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise30 {
	static List<Test<List<Integer>>> tests = new ArrayList<>();
	static {
		tests.add(new Test<List<Integer>>("sort"){
			int test(List<Integer> list, TestParam tp) {
				for (int i = 0; i < tp.loops; i++) {
					list.clear();
					list.addAll(CollectionData.list(new RandomGenerator.Integer(), tp.size));
					Collections.sort(list);
				}
				return tp.loops;
			}
		});
	}

	static class ListTester extends Tester<List<Integer>> {
		public ListTester(List<Integer> container, List<Test<List<Integer>>> tests) {
			super(container, tests);
		}

		@Override
		protected List<Integer> initialize(int size){
			container.clear();
			container.addAll(CollectionData.list(new RandomGenerator.Integer(), size));
			return container;
		}
		// Convenience method:
		public static void run(List<Integer> list, List<Test<List<Integer>>> tests) {
			new ListTester(list, tests).timedTest();
		}
	}

	public static void main(String[] args) {
		ListTester.run(new ArrayList<Integer>(), tests);
		ListTester.run(new LinkedList<Integer>(), tests);
	}
}