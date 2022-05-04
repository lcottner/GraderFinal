/*This is code that the student writes.
 * This is a completed version of that
 * code.
 * 
 */

package student;

import main.GraderDos;
public class Rectangle{
		  
		  private int length;
		  private int width;
		  
	 public Rectangle(){
		    
		    length = 1;
		   width = 1;
		
		  }//end constructor
	
	 
	 public Rectangle(int length, int width){
		    
		   this.length = length;
		   this.width = width;
		    }
		  
	  //end constructor
	 
		  public int calculateArea(){
		   
	   return length * width;
		}  
		  
		  //end calculateArea
	  
		  public int calculatePerimeter(){
		    return (length * 2) + (width *2);
		  }//end calculatePerimeter
		  
		  public int getWidth(){
		  
		    return width;
		    
		  }
		
		  public int getLength(){
		    return length;
		  }

		  
		  /*
		   * Main method that calls the grader
		   * for grading
		   */
		 public static void main (String[]args) {
			 GraderDos grader=new GraderDos();
			grader.run();
		 }
		 
		}//end class


