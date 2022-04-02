
public class CourseDBElement implements Comparable<CourseDBElement>{

	private String CourseID;
	private int CRN;
	private int cred;
	private String rNum;
	private String name;

	public CourseDBElement(String I, int c, int cr, String nu, String n) {

		CourseID = I;
		CRN = c;
		cred = cr;
		rNum = nu;
		name = n;
	}

	public CourseDBElement() {

		CourseID = "";
		CRN = 0;
		cred = 0;
		rNum = "";
		name = "";
	}

	public String getID() {
		return CourseID;
	}

	public void setID(String c) {
		CourseID = c;
	}

	public int getCRN() {
		return CRN;
	}

	public void setCRN(int c) {
		CRN = c;
	}

	public int getCred() {
		return cred;
	}

	public void setCred(int c) {
		cred = c;
	}

	public String getRNum() {
		return rNum;
	}

	public void setRNum(String n) {
		rNum = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}

	public int compareTo(CourseDBElement o) {

		if(CRN == o.CRN) {
			return 0;
		} else if(CRN  < o.CRN) {
			return -1;
		}else {
			return 1;
		}

	}

	public int hashCode() {
		String c = Integer.toString(CRN);
		return c.hashCode();
	}
	
	public String toString() {
		return "Your Course " +CourseID+ "has a CRN of " +CRN+" a room number of "+ rNum+" gives " + cred+" credits" + " and you teacher is" + name;
	
	}
}
