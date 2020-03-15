package com.bada.java9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * FActory unmodfiable example in case of serializaion and deserialization
 * 
 * @author bada
 *
 */
class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private int eno;
	private String ename;

	Employee(int eno, String ename) {
		this.eno = eno;
		this.ename = ename;
	}

	public String toString() {
		return String.format("%d=%s", eno, ename);
	}
}

public class UnmodifiableExample2 {
	public static void main(String[] args) throws Exception {
		System.out.println(String.class.getModule());
		Employee e1 = new Employee(100, "Sunny");
		Employee e2 = new Employee(200, "Bunny");
		Employee e3 = new Employee(300, "Chinny");
		List<Employee> l1 = List.of(e1, e2, e3);
		System.out.println(l1);

		System.out.println("Serialization of List Object...");
		FileOutputStream fos = new FileOutputStream("emp.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(l1);

		System.out.println("Deserialization of List Object...");
		FileInputStream fis = new FileInputStream("emp.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Employee> l2 = (List<Employee>) ois.readObject();
		System.out.println(l2);
		// l2.add(new Employee(400,"Vinnny"));//UnsupportedOperationException
	}
}
