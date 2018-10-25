package containers;

import java.uitl.*;
import net.mindview.util.*;

public class Exercise34 {
	static List<Test<Set<String>>> tests = new ArrayList<>();
	static {
		tests.add(new Test<Set<String>>("add"){
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++){
					set.clear();
					for(int j = 0; j < size; j++){
						set.add(new CountingGenerator.String().next());
					}
				}
				return loops * size;
			}
		});

		tests.add(new Test<Set<String>>("contains"){
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops;
				int span = tp.size;
				for(int i = 0; i < loops; i++){
					set.contains("hi");
				}
				return loops * span;
			}
		});

		tests.add(new Test<Set<String>>("iterate") {
			int test(Set<String> set, TestParam tp) {
				int loops = tp.loops * 10;
				for(int i = 0; i < loops; i++) {
					Iterator<String> it = set.iterator();
					while(it.hasNext()){
						it.next();
					}
				}
				return loops * set.size();
			}
		});
	}
	public static void main(String[] args){
		Tester.fieldWidth = 10;
		Tester.run(new TreeSet<String>(), tests);
		Tester.run(new HashSet<String>(), tests);
		Tester.run(new LinkedHashSet<String>(), tests);	
	}
}