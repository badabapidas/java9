package com.bada.java9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DiamondOperatorDemo2 {
	public static void main(String[] args) {
		String[] animals = { "Dog", "Cat", "Rat", "Tiger", "Elephant" };
		Iterator<String> iter = new Iterator<>() {
			int i = 0;

			public boolean hasNext() {
				return i < animals.length;
			}

			public String next() {
				if (!hasNext())
					throw new NoSuchElementException();
				return animals[i++];
			}
		};
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
