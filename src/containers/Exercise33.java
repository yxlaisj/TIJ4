package containers;

import java.util.*;
import net.mindview.util.*;

class FastTraversalLinkedList<T> extends AbstractList<T> {
	private class FlaggedArrayList {
		boolean changed = false;
		FlaggedLinkedList companion;
		private ArrayList<T> list = new ArrayList<>();
		public void addCompanion(FlaggedLinkedList other) {companion = other;}
		public void synchronize() {
			if(companion.changed){
				list = new ArrayList<T>(companion.list);
				companion.changed = false;
			}
		}
		public T get(int index) {
			synchronize();
			return list.get(index);
		}
		public int size() {
			synchronize();
			return list.size();
		}
		public T remove(int index) {
			synchronize();
			changed = true;
			return list.remove(index);
		}
		public boolean remove(Object item) {
			synchronize();
			changed = true;
			return list.remove(item);
		}
		// Always broadcasted to the companion, too
		public void clear() {
			list.clear();
			changed = false;
		}

	}

	private class FlaggedLinkedList {
		boolean changed = false;
		FlaggedArrayList companion;
		private LinkedList<T> list = new LinkedList<>();
		public void addCompanion(FlaggedArrayList other) {companion = other;}
		public void synchronize() {
			if(companion.changed){
				list = new LinkedList<T>(companion.list);
				companion.changed = false;
			}
		}
		public void add(int index, T item) {
			synchronize();
			changed = true;
			list.add(index, item);
		}
		public boolean add(T item) {
			synchronize();
			changed = true;
			return list.add(item);
		}
		public Iterator<T> iterator() {
			synchronize();
			return list.iterator();
		}
		// Always broadcasted to the companion, too
		public void clear() {
			list.clear();
			changed = false;
		}
	}

	private FlaggedArrayList aList = new FlaggedArrayList();
	private FlaggedLinkedList lList = new FlaggedLinkedList();

	{
		lList.addCompanion(aList);
		aList.addCompanion(lList);
	}

	public int size() {
		return aList.size();
	}
	public T get(int index){
		return aList.get(index);
	}
	public void add(int index, T item){
		lList.add(index, item);
	}
	public boolean add(T item){
		return lList.add(item);
	}
	public T remove(int index) {
		return aList.remove(index);
	}
	public boolean remove(Object item) {
		return aList.remove(item);
	}
	public Iterator<T> iterator(){
		return lList.iterator();
	}
	public void clear(){
		aList.clear();
		lList.clear();
	}
}

public class Exercise33 {
	static Random rand = new Random();
	static int reps = 1000;
	static List<Test<List<Integer>>> tests = new ArrayList<>();
	static {
		tests.add(new Test<List<Integer>>("iter"){
			int test(List<Integer> list, TestParam tp){
				for(int i = 0; i < tp.loops; i++) {
					Iterator<Integer> it = list.iterator();
					while(it.hasNext()){
						it.next();
					}
				}
				return tp.loops;
			}
		});
		tests.add(new Test<List<Integer>>("get"){
			int test(List<Integer> list, TestParam tp){
				int loops = tp.loops * reps;
				int listSize = list.size();
				for(int i = 0; i < loops; i++){
					list.get(rand.nextInt(listSize));
				}
				return loops;
			}
		});
		tests.add(new Test<List<Integer>>("insert"){
			int test(List<Integer> list, TestParam tp){
				int loops = tp.loops;
				for(int i = 0; i < loops; i++) {
					list.add(5, 47);
				}
				return loops;
			}
		});
		tests.add(new Test<List<Integer>>("remove_I"){
			int test(List<Integer> list, TestParam tp){
				int count = 0;
				for(int i = list.size() / 2; i < list.size(); i++) {
					++count;
					list.remove(i);
				}
				return count;
			}
		});
		tests.add(new Test<List<Integer>>("remove_O"){
			int test(List<Integer> list, TestParam tp){
				int count = 0;
				for(int i = list.size() / 2; i < list.size(); i++) {
					++count;
					list.remove(list.get(i));
				}
				return count;
			}
		});
	}

	static class ListTester extends Tester<List<Integer>> {
		public ListTester(List<Integer> container, List<Test<List<Integer>>> tests){
			super(container, tests);
		}

		@Override protected List<Integer> initialize(int size){
			container.clear();
			container.addAll(new CountingIntegerList(size));
			return container;
		}

		public static void run(List<Integer> list, List<Test<List<Integer>>> tests){
			new ListTester(list, tests).timedTest();
		}
	}

	public static void main(String[] args) {
		ListTester.run(new LinkedList<Integer>(), tests);
		ListTester.run(new ArrayList<Integer>(), tests);
		ListTester.run(new FastTraversalLinkedList<Integer>(), tests);
	}
}