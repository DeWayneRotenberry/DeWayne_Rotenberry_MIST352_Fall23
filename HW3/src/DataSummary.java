import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author MJ
 *
 */
public class DataSummary {
	private String fileLocation;
	private double averageSalary;
	
	/**
	 * Keep as is
	 * Constructor. 
	 * @param file
	 * @throws FileNotFoundException 
	 */
	public DataSummary(String file) throws FileNotFoundException
	{
		this.fileLocation = file;
		this.averageSalary = getAverage();
		
	}
	
	/**
	 * You need to code this
	 * This method opens the employee data file and returns the average salary of all employees in the data
	 * @param strFile: Location of the text file from the main
	 * @return dblSum: the Average of all salaries
	 * @throws FileNotFoundException: if file is not found, this is thrown
	 */
	public double getAverage() throws FileNotFoundException
	{
		  File data = new File(fileLocation);
	        Scanner scnReader = new Scanner(data);

	        double totalSalary = 0;
	        int employeeCount = 0;

	        while (scnReader.hasNext()) {
	            String strLine = scnReader.nextLine();
	            //  salary is the sixth element in the array (index 5)
	            totalSalary += Double.parseDouble(strLine.split(",")[5]);
	            employeeCount++;
	        }

	        scnReader.close();

	        if (employeeCount > 0) {
	            return totalSalary / employeeCount;
	        } else {
	            return 0; // Avoid division by zero
	        }	
	}
	

	/**
	 * You need to code this
	 * This method should printout all employees and their IDs to the console.
	 * @throws FileNotFoundException: Thrown if file is not found.
	 */
	public void ViewEmployeeAndIDs() throws FileNotFoundException
	{
		 File data = new File(fileLocation);
		    Scanner scnReader = new Scanner(data);

		    while (scnReader.hasNext()) {
		        String strLine = scnReader.nextLine();
		        // Assuming the employee name is the first element and the ID is the fourth element
		        String employeeName = strLine.split(",")[0];
		        int employeeID = Integer.parseInt(strLine.split(",")[5]);

		        System.out.println("Name: " + employeeName + ". ID: " + employeeID);
		    }

		    scnReader.close();
	}

	
	
	/**
	 * You need to code this
	 * This method accepts an employee name (first, last, or both) and searches for all employee with that name
	 * It should printout all employee's info to a GUI, otherwise, it should printout Not Found
	 * @param strEmployee: Employee name 
	 * @throws FileNotFoundException: Thrown if file is not found.
	 */
		public void SearchEmployee(String strEmployee) throws FileNotFoundException 
		{
	        File data = new File(fileLocation);
	        Scanner scnReader = new Scanner(data);

	        StringBuilder result = new StringBuilder();

	        while (scnReader.hasNext()) {
	            String strLine = scnReader.nextLine();
	            String employeeName = strLine.split(",")[0];
	            
	            // Check if the employee name contains the search string
	            if (employeeName.toLowerCase().contains(strEmployee.toLowerCase())) {
	                result.append(strLine).append("\n");
	            }
	        }

	        scnReader.close();

	        if (result.length() > 0) {
	            JOptionPane.showMessageDialog(null, result.toString());
	        } else {
	            JOptionPane.showMessageDialog(null, "Employee not found");
	        }	 
		}
	
	/**
	 * You need to code this
	 * This method accepts an employee role (i.e., position) and views for all employee in that role
	 * It should printout all employee's info to a GUI, otherwise, it should printout Not Found
	 * @param strRole: Employee role 
	 * @throws FileNotFoundException: Thrown if file is not found.
	 */
	public void ViewEmployeeForRole(String strRole) throws FileNotFoundException
	{
		File data = new File(fileLocation);
        Scanner scnReader = new Scanner(data);

        StringBuilder result = new StringBuilder();

        while (scnReader.hasNext()) {
            String strLine = scnReader.nextLine();
            String employeeRole = strLine.split(",")[2];
            
            // Check if the employee role matches the search role
            if (employeeRole.equalsIgnoreCase(strRole)) {
                result.append(strLine).append("\n");
            }
        }

        scnReader.close();

        if (result.length() > 0) {
            JOptionPane.showMessageDialog(null, result.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Not found");
        }	

		
	}
	

	/**
	 * Keep as is.
	 * This method displays the distinct roles in the text file
	 * @throws FileNotFoundException 
	 */
	public void ViewRoles() throws FileNotFoundException
	{	
		       
		        File myFile = new File(fileLocation);
		        Scanner inputFile = new Scanner(myFile);
		        Set<String> distinctRoles = new HashSet<>();

		        while(inputFile.hasNextLine()) {
		            String strData2Show = inputFile.nextLine();
		            // Splitting the line by comma
		            String[] dataParts = strData2Show.split(",");
		            // The role is the third element in the array (index 2)
		            distinctRoles.add(dataParts[2]);
		        }
		        inputFile.close();
		        String strRole="";
		        // Displaying distinct roles
		        for (String role : distinctRoles) {
		        	strRole = strRole + role + "\n";
		            //System.out.println(role);
		        }
		        JOptionPane.showMessageDialog(null, strRole);
		    }
	
}
