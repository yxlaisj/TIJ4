package containers;

import java.util.*;
import java.lang.ref.*;

class VeryBig {
	private static final int SIZE = 10000;
	private long[] la = new long[SIZE];
	private String ident;
	public VeryBig(String id) {
		ident = id;
	}
	public String toString() {
		return ident;
	}

	protected void finalize() {
		System.out.println("Finalizing " + ident);
	}
}

public class References {
	private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

	public static void checkQueue() {
		Reference<? extends VeryBig> inq = rq.poll();
		if(inq != null) {
			System.out.println("In queue: " + inq.get());
		}
	}

	public static void main(String[] args) throws Exception{
		int size = 10;
		LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
		for(int i = 0; i < size; i++){
			sa.add(new SoftReference<VeryBig>(new VeryBig("soft" + i), rq));
			System.out.println("Just created: " + sa.getLast());
			checkQueue();
		}

		LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
		for(int i = 0; i < size; i++) {
			wa.add(new WeakReference<VeryBig>(new VeryBig("weak" + i), rq));
			System.out.println("Just created: " + wa.getLast());
			checkQueue();
		}
		SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("soft"));
		WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("weak"));
		System.gc();
		LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
		for(int i = 0; i < size; i++) {
			pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom" + 1), rq));
			System.out.println("Just created: " + pa.getLast());
			checkQueue();
		}
	}
}