import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 */

/**
 * @author DeWayne Rotenberry
 * 			MIST352
 *			HW4
 */
public class HW4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//***********************************************************************************************
		// Keep lines 21 - 27 as is
        //Location of the data folder which has all csv files
		String directoryPath = "src/Data"; 
		//String that has the names of all csv files, without the directory.
        String[] csvFileNames = findCSVFileNames(new File(directoryPath));
    //***********************************************************************************************
        //to do:
        // 1. Print out the array of csv files
        PrintArray(csvFileNames);

        // 2. Access the array csvFileNames, add the directory to each file name.
        for (int i = 0; i < csvFileNames.length; i++) {
            csvFileNames[i] = directoryPath + "/" + csvFileNames[i];
        }

        // 3. Print out the array of csv files again after adding directory to each
        PrintArray(csvFileNames);

     // 4. Go through the array and create Csv2Arff objects
        for (String csvFileName : csvFileNames) {
            Csv2Arff csv2Arff = new Csv2Arff(csvFileName);

            // Extract first and last name 
            String firstName = "DeWayne";
            String lastName = "Rotenberry";

            // Construct the ARFF file name based on the specified format
            String arffFileName = firstName + "_" + lastName + "_" + new File(csvFileName).getName().replace(".csv", ".arff");

            // 5. Call the proper method to write the arff file for the current csv file in the loop.
            csv2Arff.Convert2Arff(arffFileName);
        }

        // 6. Ask the user for the name of a file to look in, then column number, and row number.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file to look in: ");
        String fileNameToLookIn = scanner.nextLine();

        // 6.1 Printout the value from that file.
        Csv2Arff csv2Arff = new Csv2Arff(fileNameToLookIn);
        System.out.println("Enter the column number: ");
        int columnNumber = scanner.nextInt();
        System.out.println("Enter the row number: ");
        int rowNumber = scanner.nextInt();
        System.out.println("Value at specified column and row: " + Csv2Arff.RetrieveCell(fileNameToLookIn, rowNumber, columnNumber));
    }

    /**
     * You need to code this
     * This method simply prints out the content of any given String array
     *
     * @param array: The array to print
     */
    public static void PrintArray(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }

	/**
	 * Keep as is.
	 * This method finds all csv files in a given directory
	 * @param directory: location of all csv files. This is passed from the main
	 * @return: Array of strings, each strring represents the name the location of a csv file
	 */
    private static String[] findCSVFileNames(File directory) {
        List<String> csvFileNames = new ArrayList<>();
        addCSVFileNames(directory, csvFileNames);
        return csvFileNames.toArray((new String[0]));
    }

    /**
     * Keep as is.
     * This method is magical. We Do not care what it does.
     * @param directory
     * @param csvFileNames
     */
    private static void addCSVFileNames(File directory, List<String> csvFileNames) {
        if (directory.isDirectory()) {
            // Define a filter for CSV files
            FilenameFilter csvFilter = (dir, name) -> name.toLowerCase().endsWith(".csv");

            // List all CSV files in the current directory
            File[] files = directory.listFiles(csvFilter);
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        csvFileNames.add(file.getName());
                    }
                }
            }

            // List all directories in the current directory
            File[] dirs = directory.listFiles(File::isDirectory);
            if (dirs != null) {
                for (File dir : dirs) {
                    addCSVFileNames(dir, csvFileNames); // Recursive call
                }
            }
        }
    }}


	


