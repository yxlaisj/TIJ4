package net.mindview.util;

import java.util.*;

public class CountingIntegerList extends AbstractList<Integer> {
	private int size;
	public CountingIntegerList(int size) {
		this.size = size < 0 ? 0 : size;
	}
	public Integer get(int index){
		return Integer.valueOf(index);
	}
	public int size() {return size;}

	public static void main(String[] args) {
		//之所以能打印出值，因为toString时，调用了	iterator的next()
		//next()中调用了get()方法
		System.out.println(new CountingIntegerList(30));
	}
}