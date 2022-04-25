package main;
import student.Rectangle;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
public class GraderDos {
	private static String holder;
//private static String error="because there is not a method";
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

	
	public void grade()  {
		
	//CalculateAreaTest1
	r = new Rectangle(5,17);
	
	if (r.calculateArea()==85) {
		writeCorrect(holder);
		} else {
			writeIncorrect(holder);
		}
	
	}
	
	public void grade2()  {
		//CalculateAreaTest2

		r = new Rectangle(19,32);
		
		if (r.calculateArea()==608)	
		writeCorrect(holder); 
		else 
			writeIncorrect(holder);
		
	}
	
	public void grade3()  {

		//CalculatePerimeterTest1
		 r = new Rectangle(19,32);
		if (r.calculatePerimeter()==102) 
			writeCorrect(holder);
		else
			writeIncorrect(holder);
	}
	
	

	public void grade4()  {

		//CalculatePerimeterTest2
		 r = new Rectangle(12,15);
		if (r.calculatePerimeter()==54)
			 writeCorrect(holder);
		else
			writeIncorrect(holder);
	}
	
	public void grade5() {
		//EmptyArgumentConstructorTest
		 
		r = new Rectangle();
		if (r.getLength()==1 && r.getWidth()==1)
			 writeCorrect(holder);
		else
			writeIncorrect(holder);
	}
	
	public void grade6() {
		//PreferredConstructorTest1
				 r = new Rectangle(10,20);
				if (r.getLength()==10 && r.getWidth()==20)
					 writeCorrect(holder);
				else
					writeIncorrect(holder);
	}

	
	
public boolean constru() {
	try{  
	    Class <?> cls = Class.forName("student.Rectangle");
		// System.out.println(cls);
	
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

//For a new grader, change the declared method names and the parameters
//include parameters in method call, and put if statements for each method.
//Make methods for printing out methods exceptions (like the holder)
//Experiment with making grader into a jar file and then into a library
public boolean method(String methodName) {
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
	
	public void writeCorrect(String a) {
		System.out.println(a+ " Correct");
	}
	
	public void writeIncorrect(String a) {
		System.out.println(a + " Incorrect");
	}
	
	public static void error(String a) {
		System.out.print("The method " +a+ " is missing -> ");
	}
}



