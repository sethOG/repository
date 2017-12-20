package application;
/**
 * @author EMT@UoL
 * Date: 20/11/2017
 */
public class Driver2 extends CSVFileHandler{
    public static void main(String[] argv) {	
    	  final String fileName = "ml-latest-small/movies.csv";
	//String fileName = "myratings.csv"; // assume this file is already there
//	System.out.println("Write into CSV file:");
//	CSVFileHandler.write2CSVFile(fileName);		
	System.out.println("\nRead CSV file:");
	readCSVFile(fileName);
    }
}
