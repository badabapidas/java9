package com.bada.java9;

/**
 * Sample Resource class which implements AutoClosable interface
 * 
 * @author bada
 *
 */
class MyResource implements AutoCloseable {

	public MyResource() {
		System.out.println("Resource Creation");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Resource Closing");
	}

	public void doProcess() throws Exception {
		System.out.println("Resource Processing");
	}
}

/**
 * Class which shows examples of try with resources for all the java versions
 * 
 * @author bada
 *
 */
public class tryWithReourcesEnhancement {

	public static void main(String[] args) {
		preJDK7();
		JDK7();
		JDK9();
		multipleJDK9();
	}

	/**
	 * Program Execution With PreJDK7
	 * 
	 * Until 1.6 version it is highly recommended to write finally block to close
	 * all resources which are open as part of try block.
	 */
	public static void preJDK7() {
		System.out.println("Program Execution With PreJDK7");
		MyResource r = null;
		try {
			r = new MyResource();
			r.doProcess();
		} catch (Exception e) {
			System.out.println("Handling:" + e);
		} finally {
			try {
				if (r != null) {
					r.close();
				}
			} catch (Exception e2) {
				System.out.println("Handling:" + e2);
			}
		}
	}

	/**
	 * Program Execution With JDK7. The main advantage of "try with resources" is
	 * the resources which are opened as part of try block will be closed
	 * automatically Once the control reaches end of the try block either normally
	 * or abnormally and hence we are not required to close explicitly so that the
	 * complexity of programming will be reduced. It is not required to write
	 * finally block explicitly and hence length of the code will be reduced and
	 * readability will be improved.
	 */
	public static void JDK7() {
		System.out.println("Program Execution With JDK7");
		try (MyResource r1 = new MyResource()) {
			r1.doProcess();
		} catch (Exception e) {
			System.out.println("Handling:" + e);
		}
	}

	/**
	 * Program Execution With JDK9
	 * 
	 * From JDK 9 onwards we can use the resource reference variables which are
	 * created outside of try block directly in try block resources list.i.e The
	 * resource reference variables need not be local to try block.
	 */
	public static void JDK9() {
		System.out.println("Program Execution With JDK9");
		MyResource r = new MyResource();
		try (r) {
			r.doProcess();
		} catch (Exception e) {
			System.out.println("Handling:" + e);
		}
	}

	/**
	 * Program Execution Multiple Resources With JDK9
	 * 
	 */
	public static void multipleJDK9() {
		System.out.println("Program Execution Multiple Resources With JDK9");
		MyResource r1 = new MyResource();
		MyResource r2 = new MyResource();
		MyResource r3 = new MyResource();
		MyResource r4 = new MyResource();

		try (r1; r2; r3; r4) {
			r1.doProcess();
			r2.doProcess();
			r3.doProcess();
			r4.doProcess();
		} catch (Exception e) {
			System.out.println("Handling:" + e);
		}
	}

}
