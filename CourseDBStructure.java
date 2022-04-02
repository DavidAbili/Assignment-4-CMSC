
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class CourseDBStructure implements CourseDBStructureInterface {
	private int tSize;
	protected LinkedList<CourseDBElement>[] hTable;

	public CourseDBStructure(int s) {
		this.tSize = s;
		hTable = new LinkedList[this.tSize];
	}
	
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String test, int s) {
		this.tSize = s;
		hTable = new LinkedList[this.tSize];
	}
	
	public void add(CourseDBElement e) {
		int hash = e.hashCode() % getTableSize();
		if(hTable[hash] != null)
			hTable[hash].add(e);
		else {
			hTable[hash] = new LinkedList<CourseDBElement>();
			hTable[hash].add(e);
		}
	}
	
	public ArrayList<String> showAll() {
		ArrayList<String> val = new ArrayList<String>();
		for(int i = 0; i < getTableSize(); i++)
		{
			if(hTable[i] != null)
			{
				LinkedList<CourseDBElement> list = hTable[i];
				
				for(CourseDBElement cde : list)
				{
					String s ="\n" + cde.toString();
					val.add(s);
				}
			}
		}
		
		return val;
	}

	public CourseDBElement get(int crn) throws IOException {
		for (int i = 0 ; i < getTableSize() ; i++) {
			LinkedList<CourseDBElement> list = hTable[i];
			for (int j = 0 ; j < list.size() ; j++) {
				if (list.get(j).getCRN() == crn) {
					return list.get(j);
				}
			}
		}
		throw new IOException();
	}
	
	public int getTableSize() {
		return tSize;
	}

public LinkedList<CourseDBElement>[] getTable(){
	return  hTable;
	
}
}
