/*Grader class that the student should not
 * be able to see. Uses reflection, 
 * but still needs to see the Rectangle
 * class.
 */

package main;
import student.Rectangle;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
public class GraderDos {
	private static String holder;
private Rectangle r;
	
	public void run () {
	    GraderDos a = new GraderDos();
    	if (a.constru()==false)
    		System.exit(0);

    	//CalculateAreaTest1
    	holder="CalculateAreaTest1";
    	
    	if (a.method("calculateArea"))
		a.grade();
    	else {
    		a.writeIncorrect(holder);
    	}
    	
    	//CalculateAreaTest2
    	holder="CalculateAreaTest2";
    	
    	if (a.method("calculateArea"))
		a.grade2();
    	else {
    		a.writeIncorrect(holder);
    	}
    	
     	//CalculatePerimeterTest1
    	holder="CalculatePerimeterTest1";
    	
    	if (a.method("calculatePerimeter"))
		a.grade3();
    	else {
    		a.writeIncorrect(holder);
    	}
    	
    	//CalculatePerimeterTest2
    	holder="CalculatePerimeterTest2";
    	
    	if (a.method("calculatePerimeter"))
		a.grade4();
    	else {
    		a.writeIncorrect(holder);
    	}
    	
    	
    	//EmptyArgumentConstructorTest
    	holder="EmptyArgumentConstructorTest";
    	
    	if (a.method("getLength") && a.method("getWidth"))
		a.grade5();
    	else {
    		a.writeIncorrect(holder);
    	}
    	
    	//PreferredConstructorTest1
    	holder="PreferredConstructorTest1";
    	
    	if (a.method("getLength") && a.method("getWidth"))
		a.grade5();
    	else {
    		a.writeIncorrect(holder);
    	}
    	
	}

	/*Separate classes for  
	 * each test, so that each one
	 * can throw method not found errors
	 */
	private void grade()  {
		
	//CalculateAreaTest1
	r = new Rectangle(5,17);
	
	if (r.calculateArea()==85) {
		writeCorrect(holder);
		} else {
			writeIncorrect(holder);
		}
	
	}
	
	private void grade2()  {
		//CalculateAreaTest2

		r = new Rectangle(19,32);
		
		if (r.calculateArea()==608)	
		writeCorrect(holder); 
		else 
			writeIncorrect(holder);
		
	}
	
	private void grade3()  {

		//CalculatePerimeterTest1
		 r = new Rectangle(19,32);
		if (r.calculatePerimeter()==102) 
			writeCorrect(holder);
		else
			writeIncorrect(holder);
	}
	
	

	private void grade4()  {

		//CalculatePerimeterTest2
		 r = new Rectangle(12,15);
		if (r.calculatePerimeter()==54)
			 writeCorrect(holder);
		else
			writeIncorrect(holder);
	}
	
	private void grade5() {
		//EmptyArgumentConstructorTest
		 
		r = new Rectangle();
		if (r.getLength()==1 && r.getWidth()==1)
			 writeCorrect(holder);
		else
			writeIncorrect(holder);
	}
	
	private void grade6() {
		//PreferredConstructorTest1
				 r = new Rectangle(10,20);
				if (r.getLength()==10 && r.getWidth()==20)
					 writeCorrect(holder);
				else
					writeIncorrect(holder);
	}

	
	
	/*
	 * Checks the Rectangle class to see if the
	 * constructors exist and if they have the correct
	 * parameters
	 */
private boolean constru() {
	try{  
	    Class <?> cls = Class.forName("student.Rectangle");
	
	  Constructor<?> cons1 = cls.getConstructor();
	  Constructor<?> cons2 = cls.getConstructor(int.class,int.class);
	    System.out.println("The constructors exist");
	    return true;
	}
	catch (NoSuchMethodException e) {
		System.out.println(e+" constructor does not exist" );
		return false;
	}
	catch (ClassNotFoundException e) {
		System.out.println("Rectangle class not found");
		return false;
	}
}

/*
 * Checks the Rectangle class to see if the
 * named methods exist
 */
private boolean method(String methodName) {
	try{ 
		 Rectangle rec = new Rectangle();
	
		 if (methodName.equals("calculateArea")) {
			 Method met1 = rec.getClass().getDeclaredMethod("calculateArea");
			 return true;
		 }
		if (methodName.equals("calculatePerimeter")) {
		Method met2 = rec.getClass().getDeclaredMethod("calculatePerimeter");
		return true;
		}
		
		if (methodName.equals("getWidth")) {
		  Method met3 = rec.getClass().getDeclaredMethod("getWidth");
		 return true;
		}
		if (methodName.equals("getLength")) {
	  Method met4 = rec.getClass().getDeclaredMethod("getLength");
	  return true;
		}
		  //  System.out.println("Methods correct");
		    return false;
}
	catch(NoSuchMethodException e) {
		//System.out.println("A method does not exist");
		error(methodName);
		return false;
	}
	catch (SecurityException e) {
		System.out.println("Security Error");
		return false;
	}
}
	/*
	 * Simple methods for printing text
	 * for the student to see
	 */
	private void writeCorrect(String a) {
		System.out.println(a+ " Correct");
	}
	
	private void writeIncorrect(String a) {
		System.out.println(a + " Incorrect");
	}
	
	private static void error(String a) {
		System.out.print("The method " +a+ " is missing -> ");
	}
}



