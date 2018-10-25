package containers;

import java.util.*;

class Tuple {
	public static class T2<A, B> implements Comparable<T2<A, B>> {
		private final A first;
		private final B second;

		public T2(A a, B b) {
			first = a;
			second = b;
		}
		public String toString() {
			return "(" + first + ", " + second + ")";
		}
		public int hashCode() {
			int result = 17;
			if(first != null) {
				result = 31 * result + first.hashCode();
			}
			if(second != null) {
				result = 31 * result + second.hashCode();
			}
			return result;
		}
		@SuppressWarnings("uncheched")
		public boolean equals(Object o) {
			if(o instanceof T2){
				T2<A, B> t = (T2<A, B>)o;
				return (first == null ? t.first == null : first.equals(t.first)) &&
					(second == null ? t.second == null : second.equals(t.second));
			}
			return false;
		}
		@SuppressWarnings("uncheched")
		public int compareTo(T2<A, B> p) {
			int res = ((Comparable<A>)first).compareTo(p.first);
			if(res != 0){
				return res;
			}
			return ((Comparable<B>)second).compareTo(p.second);
		}


	}
}

public class Exercise27 {
	public static void main(String[] args) {
		
	}
}

