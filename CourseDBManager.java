
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure stuct = new CourseDBStructure(30);
	
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement ele = new CourseDBElement(id,crn,credits,roomNum,instructor);
		stuct.add(ele);
	}
	
	public CourseDBElement get(int c) {
		CourseDBElement val = null;
		try {
			return stuct.get(c);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return val;
	}
	
	public ArrayList<String> showAll() {
		return stuct.showAll();
		}
		
	public void readFile(File input) throws FileNotFoundException {
		

		  String courses;
		        String[] course;
		        CourseDBElement CDE;
		        Scanner keyboard = new Scanner(input);
		        while(keyboard.hasNextLine()){
		            courses=keyboard.nextLine();
		            course = courses.split(" ",5);
		            CDE = new CourseDBElement(course[0],Integer.parseInt(course[1]),Integer.parseInt(course[2]),course[3],course[4]);
		            stuct.add(CDE);

			
		

	
	
		        }

	}
}
