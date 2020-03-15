package com.bada.java9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

/**
 * Example showing in java 9 several factory methods added to easily create
 * Unmodifiable Collection
 * 
 * Note: The Factroy Methods introduced in Java 9 are not to create general
 * collections and these are meant for creating immutable collections.
 * 
 * @author bada
 *
 */
public class FactoryMethodUnmodifiableCollection {

	public static void main(String[] args) {
		// Creation of unmodifiable List object prior to Java 9,
		List<String> beers = new ArrayList<String>();
		beers.add("KF");
		beers.add("FO");
		beers.add("RC");
		beers.add("FO");
		beers = Collections.unmodifiableList(beers);
		System.out.println(beers);

		// In java 9
		List<String> beers1 = List.of("KF", "KO", "RC", "FO");
		System.out.println(beers1);
		try {
			beers1.add("HH"); // not allowed any modification as the list is unmodifiableList
		} catch (Exception e) {
			System.out.println(e);
		}
		// While using these factory methods if any element is null then we will get
		// NullPointerException.
		try {
			List<String> fruits = List.of("Apple", "Banana", null); // NullPointerException
		} catch (Exception e) {
			System.out.println(e);
		}

		Map.Entry<String, String> e1 = Map.entry("A", "Apple");
		Map.Entry<String, String> e2 = Map.entry("B", "Banana");
		Map.Entry<String, String> e3 = Map.entry("C", "Cat");
		Map<String, String> m = Map.ofEntries(e1, e2, e3);
		System.out.println(m);

		// In Short way we can also create as follows
		Map<String, String> map = Map.ofEntries(entry("A", "Apple"), entry("B", "Banana"), entry("C", "Cat"),
				entry("D", "Dog"));
		System.out.println(map);
	}

}
