
/**
 * This class allows you to convert a csv file to arff file.
 * @author MJ
 *
 */
public class Csv2Arff {
	private String csvFileLocation;
	
	/**
	 * Keep as is. 
	 * Constructor.
	 * @param Location
	 */
	public Csv2Arff(String Location)
	{
		csvFileLocation=Location;
	}
	
	/**
     * You need to code this
     * This method accepts the name and location of a csv file
     * and writes an arff file based on the csv data.
     * Writing arff file is similar to writing any .txt file.
     * Just make sure the arff file name ends with .arff
     *
     * @param theLocation: The name and location of any csv file
     */
    public void Convert2Arff(String theLocation) {
        // Read CSV file and write ARFF file
        try (BufferedReader br = new BufferedReader(new FileReader(theLocation));
             FileWriter fw = new FileWriter(theLocation.replace(".csv", ".arff"))) {

            // TODO: Implement the conversion logic from CSV to ARFF

            System.out.println("Conversion to ARFF is done =)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method reads the csv file into a two-dimensional array of Strings.
     * This method returns the data given in a specific row and column in the array.
     *
     * @param theFile: name of the csv file to open
     * @param row:     row number in the two-dimensional array
     * @param column:  column number in the two-dimensional array
     * @return strData2Return: the data in the [column][row]
     */
    public static String RetrieveCell(String theFile, int row, int column) {
        String strData2Return = "";

        // TODO: Implement logic to read the CSV file and retrieve data at the specified row and column

        return strData2Return;
    }
}
