package containers;

public abstract class Test<C> {
	String name;
	public Test(String name) {this.name = name;}
	//Overrid this method for different test. Returns actual number for repetitions of test.
	abstract int test(C container, TestParam tp);
}