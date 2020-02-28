package com.bada.java9;

public class diamondOperatorEnhancement {

	public static void main(String[] args) {
		MyGenClass<String> c1 = new MyGenClass<String>("Bapi") {
			public void process() {
				System.out.println("Processing... " + getObj());
			}
		};
		c1.process();

		MyGenClass<String> c2 = new MyGenClass<>("Das") {
			public void process() {
				System.out.println("Processing... " + getObj());
			}
		};
		c2.process();
	}
}

/**
 * Sample Generic Class
 * 
 * @author bada
 *
 * @param <T>
 */
class MyGenClass<T> {
	T obj;

	public MyGenClass(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void process() {
		System.out.println("Processing obj...");
	}
}
