/**
 * 
 */

/**
 * 
 */
public class Course {
	
	    private String courseCode;
	    private String courseTitle;
	    private String instructorName;
	    private int maximumCapacity;
	    private int currentEnrollment;

	    // Constructor
	    public Course(String courseCode, String courseTitle, String instructorName) {
	        this.courseCode = courseCode;
	        this.courseTitle = courseTitle;
	        this.instructorName = instructorName;
	        this.maximumCapacity = 30;
	        this.currentEnrollment = 29;
	    }

	    // Accessors (getters)
	    public String getCourseCode() {
	        return courseCode;
	    }

	    public String getCourseTitle() {
	        return courseTitle;
	    }

	    public String getInstructorName() {
	        return instructorName;
	    }

	    public int getMaximumCapacity() {
	        return maximumCapacity;
	    }

	    public int getCurrentEnrollment() {
	        return currentEnrollment;
	    }

	    // Mutators (setters)
	    public void setCourseCode(String courseCode) {
	        this.courseCode = courseCode;
	    }

	    public void setCourseTitle(String courseTitle) {
	        this.courseTitle = courseTitle;
	    }

	    public void setInstructorName(String instructorName) {
	        this.instructorName = instructorName;
	    }

	    // Method to enroll a student
	    public boolean enrollStudent() {
	        if (currentEnrollment < maximumCapacity) {
	            currentEnrollment++;
	            return true;
	        }
	        return false;
	    }

	    public static void main(String[] args) {
	        Course course = new Course("CS101", "Introduction to Programming", "John Doe");

	        // Attempt to enroll a student
	        boolean enrolled = course.enrollStudent();
	        if (enrolled) {
	            System.out.println("Student enrolled successfully.");
	        } else {
	            System.out.println("Enrollment is full. Student could not be enrolled.");
	        }
	    }

}

