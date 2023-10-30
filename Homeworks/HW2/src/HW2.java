/**
 * 
 */

/**
 * @author MJ
 *
 */
public class HW2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Course course1 = new Course("MIST352", "Businsess Application Programming","MJ Ahmad");
		Course course2 = new Course("CS101", "Introd. to Computer Science","Sarah Jones");
		Student student1 = new Student("Ashley Jaber");
		Student student2 = new Student("Ali June");
		

		//Keep If statements the way they are.
		if (course1.enrollStudent()) {
            System.out.println("Enrolling " + student1.getName() + " in " + course1.getCourseCode() + " successful");
            System.out.println("Current enrollment " + course1.getCurrentEnrollment());

            // Hard-coded grades for MIST352
            double mist352Grade1 = 80.0;
            double mist352Grade2 = 75.0;
            double mist352Grade3 = 85.0;

            // Adding grades for MIST352
            student1.calculateGPA(mist352Grade1, mist352Grade2, mist352Grade3);
            System.out.println("The current GPA is: " + String.format("%.6f", student1.getGPA()));
        } else {
            System.out.println("Enrolling " + student1.getName() + " in " + course1.getCourseCode() + " not successful");
        }

        if (course2.enrollStudent()) {
            System.out.println("Enrolling " + student1.getName() + " in " + course2.getCourseCode() + " successful");
            System.out.println("Current enrollment " + course2.getCurrentEnrollment());

            // Hard-coded grades for CS101
            double cs101Grade1 = 90.0;
            double cs101Grade2 = 85.0;
            double cs101Grade3 = 80.0;

            // Adding grades for CS101
            student1.calculateGPA(cs101Grade1, cs101Grade2, cs101Grade3);
            System.out.println("The current GPA is: " + String.format("%.6f", student1.getGPA()));
        } else {
            System.out.println("Enrolling " + student1.getName() + " in " + course2.getCourseCode() + " not successful");
        }

        if (course1.enrollStudent()) {
            System.out.println("Enrolling " + student2.getName() + " in " + course1.getCourseCode() + " successful");
            System.out.println("Current enrollment " + course1.getCurrentEnrollment());
        } else {
            System.out.println("Enrolling " + student2.getName() + " in " + course1.getCourseCode() + " not successful");
        }

        if (course2.enrollStudent()) {
            System.out.println("Enrolling " + student2.getName() + " in " + course2.getCourseCode() + " successful");
            System.out.println("Current enrollment " + course2.getCurrentEnrollment());
        } else {
            System.out.println("Enrolling " + student2.getName() + " in " + course2.getCourseCode() + " not successful");
        }
     
     // Compare Ashley's GPA in MIST352 and CS101
        if (course1.getCurrentEnrollment() > 0 && course2.getCurrentEnrollment() > 0) {
            double mist352GPA = student1.getGPA();
            double cs101GPA = student1.getGPA();

            if (mist352GPA > cs101GPA) {
                System.out.println("Ashley's GPA in MIST352 is greater than her GPA in CS101.");
            } else if (mist352GPA < cs101GPA) {
                System.out.println("Ashley's GPA in CS101 is greater than her GPA in MIST352.");
            } else {
                System.out.println("Ashley's GPA in MIST352 and CS101 are equal.");
            }
        }
	}
}

	//doesn't enroll Ali June because the course is full