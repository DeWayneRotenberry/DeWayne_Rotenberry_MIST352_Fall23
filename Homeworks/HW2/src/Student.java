/**
 * 
 */

/**
 * 
 */
public class Student {
	 private String name;
	    private int id;
	    private String major;
	    private String dob;
	    private int hours;
	    

//Setter methods
public void setName(String theName) {
    name = theName;
}

public void setID(int theID) {
    id = theID;
}

public void setMajor(String theMajor) {
    major = theMajor;
}

public void setDOB(String theDOB) {
    dob = theDOB;
}

public void setHours(int hours, String action) {
    if (action.equals("add")) {
        this.hours += hours;
    } else if (action.equals("subtract")) {
        this.hours -= hours;
    }
}

// Getter methods
public String getName() {
    return name;
}

public int getID() {
    return id;
}

public String getMajor() {
    return major;
}

public String getDOB() {
    return dob;
}

public int getHours() {
    return hours;

	}
}