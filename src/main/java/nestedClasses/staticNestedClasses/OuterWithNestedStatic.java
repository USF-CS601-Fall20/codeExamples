package nestedClasses.staticNestedClasses;
/** 
 * A example of a static nested class
 * Modified from http://www.javatpoint.com/static-nested-class
 */
public class OuterWithNestedStatic {
	private static int data = 30;   // static variable
	private int nonStaticData = 6;  // non-static variable
	
	public static class NestedStaticClass {
		public void message() {
			System.out.println("data is " + data); // can access data since it's static
			// Can not access nonStaticData from here
		}
	}

}
