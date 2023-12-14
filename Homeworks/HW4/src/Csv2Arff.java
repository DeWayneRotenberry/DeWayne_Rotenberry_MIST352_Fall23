import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author DeWayne Rotenberry
 * 			MIST352
 *			HW4
 */

public class Csv2Arff {
    private static String csvFileLocation;

    /**
     * Keep as is.
     * Constructor.
     *
     * @param Location
     */
    public Csv2Arff(String Location) {
        csvFileLocation = Location;
    }

    /**
     * This method accepts the name and location of a csv file
     * and writes an arff file based on the csv data.
     * Writing arff file is similar to writing any .txt file.
     * Just make sure the arff file name ends with .arff
     *
     * @param theLocation: The name and location of any csv file
     */
    public void Convert2Arff(String theLocation) {
        try (BufferedReader br = new BufferedReader(new FileReader(theLocation));
             FileWriter fw = new FileWriter(theLocation.replace(".csv", ".arff"))) {

            // Writes ARFF header
            fw.write("@relation CSVtoARFF\n\n");

            // Read the CSV file and write ARFF attributes
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                //  first row contains attribute names
                if (line.startsWith("#") || line.trim().isEmpty()) {
                    continue; // Skip comments and empty lines
                }

                // Write ARFF attribute declaration
                for (String value : values) {
                    fw.write("@attribute " + value.trim() + " numeric\n");
                }

                // Write ARFF data section
                fw.write("\n@data\n");
                break;
            }

            // Write data rows
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }

            System.out.println("Conversion to ARFF is done =)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method reads the csv file into a two-dimensional array of Strings.
     * This method returns the data given in a specific row and column in the array.
     * @param fileNameToLookIn 
     *
     * @param theFile: name of the csv file to open
     * @param row:     row number in the two-dimensional array
     * @param column:  column number in the two-dimensional array
     * @return strData2Return: the data in the [column][row]
     */
    public static String RetrieveCell(String fileNameToLookIn, int row, int column) {
        String strData2Return = "";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileLocation))) {
            String line;
            int currentRow = 0;

            // Find the desired row
            while ((line = br.readLine()) != null) {
                if (currentRow == row) {
                    String[] values = line.split(",");
                    // Check if the specified column is within bounds
                    if (column >= 0 && column < values.length) {
                        strData2Return = values[column];
                        break;
                    }
                }
                currentRow++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return strData2Return;
    }
}