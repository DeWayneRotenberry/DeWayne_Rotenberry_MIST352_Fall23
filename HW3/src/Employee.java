import java.util.Date;

public class Employee {
    private String name;
    private String dateOfBirth;
    private String role;
    private int employeeId;
    private String email;
    private double salary;
    private boolean aboveAvg;
    private String bar;

    // Constructor
    /**
     * This constructor accepts one line from a text file
     * It should split it up and initialize all attributes in this class using the values from the line
     * For example, name should equal to the first portion of the split line and dateOfBirth is second and so on.
     * Lastly, set aboveAvg to false
     * @param line
     */
    public Employee(String line) {
        // Split the line into individual attributes
        String[] parts = line.split(",");

        // Assuming order in the line is: name, dateOfBirth, role, employeeId, email, salary
        this.name = parts[0].trim();
        this.dateOfBirth = parts[1].trim();
        this.role = parts[2].trim();
        this.employeeId = Integer.parseInt(parts[3].trim());
        this.email = parts[4].trim();
        this.salary = Double.parseDouble(parts[5].trim());
        this.aboveAvg = false; // Default value

        // Call the method to set aboveAvg based on salary
        setAboveAvg(salary);
    }

    /**
     * This method accepts the average salary from the main and decides whether this employee's salary is above average or not
     * If it is, then set aboveAvg to true
     * @param dblAverage
     */
    public void setAboveAvg(double dblAverage) {
        aboveAvg = (salary > dblAverage);
    }

    /**
     * This method accepts an employee's salary and returns a bar chart of stars representation of the salary
     * For example,
     * if the salary is 60,000, then the bar should return 6 stars: ******
     * if the salary is 95,600, then the bar should return 9 stars: *********
     * @param salary: the employee salary
     * @return bar: representation in stars of the salary. Each * represents $10,000
     */
    public String SalaryBarChart(double salary) {
        int stars = (int) (salary / 10000);
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < stars; i++) {
            bar.append('*');
        }
        return bar.toString();
    }

    /**
     * This method provides a summary of each employee.
     * It returns a string formatted to include: employee name, employee ID, the bar chart of the salary, and whether salary is above average or not.
     * @return : Formatted string of employee's basic information.
     */
    public String SummarizeEmployee() {
        return String.format("Name: %s\nEmployee ID: %d\nSalary Bar Chart: %s\nAbove Average: %b",
                name, employeeId, bar, aboveAvg);
    }
}
