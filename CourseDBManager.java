
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure stuct = new CourseDBStructure(30);
	
	
	public void readFile(File input) throws FileNotFoundException {
		
		Scanner fileData = new Scanner(input);	
		while(fileData.hasNext()) {
			String i = fileData.next();
			int c = fileData.nextInt();
			int cr = fileData.nextInt();
			String n = fileData.next();
			String t = fileData.nextLine();
			add(i, c, cr, n, t);
		}
		fileData.close();
}
	
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
		
	
}
