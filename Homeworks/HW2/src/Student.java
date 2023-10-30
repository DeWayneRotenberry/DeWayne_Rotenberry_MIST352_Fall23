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
	    private double gpa;
	    

	  public Student(String name) {
	        this.name = name;
	        this.gpa = 0.0;
	    }
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
	    	} 	else if (action.equals("subtract")) {
	    		this.hours -= hours;
	    	}
	    }
	    	// Method to set the GPA
	       public void setGPA(double gpa) {
	            this.gpa = gpa;
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
	    


		public double getGPA() {
			return gpa;
		}

		public void calculateGPA(double grade1, double grade2, double grade3) {
	        // Calculate GPA based on the grades and update the gpa field
	        gpa = (grade1 + grade2 + grade3) / 3.0;
	    }

		
	}