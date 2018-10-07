package containers;

import java.util.*;

public class Exercise11 {
	private static int count = 10;
	public static void fill(Queue<MyQueueElement> queue, int count) {
		for(int i = 0 ; i < count ; i++){
			queue.add(new MyQueueElement());
		}
	}

	public static void main(String[] args) {
		Queue<MyQueueElement> queue = new PriorityQueue<>();
		fill(queue, count);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}

class MyQueueElement implements Comparable<MyQueueElement> {
	private int num;
	private static Random random = new Random(47);
	public MyQueueElement() {
		num = random.nextInt(100);
	}

	public int compareTo(MyQueueElement arg) {
		return num > arg.num ? 1 : (num == arg.num ? 0 : -1);
	}

	public String toString() {
		return num + "";
	}
}
