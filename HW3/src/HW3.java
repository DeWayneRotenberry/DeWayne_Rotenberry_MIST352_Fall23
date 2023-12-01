/**
 * 
 */

/**
 * @author DeWayne Rotenberry
 * MIST352-001
 * HW3
 * used ChatGPT for switch statement due to errors kept getting
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class HW3 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
	//****** Keep as is *******************
		// The location of the employee text file 
		String strDataLocation ="src/EmployeeData.txt";
		String strOutputLocation ="src/EmployeeSummary.txt";
		File myFile = new File(strDataLocation);
		Scanner inputFile = new Scanner (myFile);
		PrintWriter writer =new PrintWriter(strOutputLocation);
		int intChoice  = Integer.parseInt( JOptionPane.showInputDialog(null,  ViewOptions()));
		DataSummary myData = new DataSummary(strDataLocation);
	//*************************************

		
		//used ChatGPT kept getting an error at case 2 and 6 
		while(intChoice !=0)
		{
			switch(intChoice)
			{
			case 1:
                myData.ViewEmployeeAndIDs();
                break;
            case 2:
                String searchName = JOptionPane.showInputDialog("Enter employee name:");
                myData.SearchEmployee(searchName);
                break;
            case 3:
                myData.ViewRoles();
                break;
            case 4:
                String role = JOptionPane.showInputDialog("Enter employee role:");
                myData.ViewEmployeeForRole(role);
                break;
            case 5:
                double avgSalary = myData.getAverage();
                JOptionPane.showMessageDialog(null, "Average Salary: $" + avgSalary);
                break;
            case 6:
                // Summarize and Write data
                myData.DataSummary();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                break;
			}
			intChoice  = Integer.parseInt( JOptionPane.showInputDialog(null,  ViewOptions()));	
		}


		writer.close();
		inputFile.close();	
		
	}
	/**	 
	 * Keep as is
	 * A method to display options
	 * @return : The options to display in the GUI
	 */
	
	public static String ViewOptions()
	{
		String strMessageToDisplay="Choose an option:"
				+ "\n0.\tExit"
				+ "\n1.\tView Employees and IDs"
				+ "\n2.\tSearch for Employee"
				+ "\n3.\tView current roles"
				+ "\n4.\tView employees for a certain role"
				+ "\n5.\tView Average Salary"
				+ "\n6.\tSummerize and Write data";
		return strMessageToDisplay;
	} }