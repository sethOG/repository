package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// class final so no object can be created;
// cannot be extended and in it
// attributes and methods are all static
public class CSVFileHandler extends Registry{
	
    //Delimiter used in CSV file
	static List<Rating> ratings = new ArrayList<Rating>();
    private static final String COMMA = ",";
    private static final String NEWLINE = "\n";
    static String re;	
    //private static final String fileName = "ml-latest-small/movies.csv";
		
    // read assuming data is well formatted, if not
    // make sure the csv is in the correct format
    // This program needs be modified to checking data format	
    public String getRatingList( ) {
        StringBuffer result = new StringBuffer("");
        String tb = "\t";
        String nwLine = "\n";   
    for (Rating u : ratings) {
    	result.append(u.getMovieID()     + tb +
                u.getTitle()     + tb +
                u.getValue()    + tb +
                nwLine);
}
System.out.println(result.toString());
return result.toString();

}
    
    public static void readCSVFile(String fileName) {
  
	BufferedReader reader = null;
        try {
        	  
	    //Create a new list of ratings from CSV file data 
//	     List<Rating> ratings = new ArrayList<Rating>();
            reader = new BufferedReader(new FileReader(fileName));
            String line = " ";          
            //Skip the CSV file header 
	    reader.readLine();           
            //Read the file line by line starting from the second line
            while ((line = reader.readLine()) != null) {
                //Get all tokens by splitting using the comma
		//We know the data has 3 columns 0, 1, 2
                String[] tokens = line.split(COMMA);
                if (tokens.length > 0) {
//                	System.out.println("sfge");
		    //Create a new rating object and fill his  data
		    try {
//		    	System.out.println("efwe");
			long mid = Long.parseLong(tokens[0]);
			String title = tokens[1];
			double val = Double.parseDouble(tokens[2]);
			
			Rating rating = new Rating(mid, title, val);
//			System.out.println(rating);
			
			ratings.add(rating);
			truu tru= new truu(rating);
			re = null;
			re = tru.getUserList();
			System.out.println("sfsfv"+re);
//			System.out.println(ratings);
		    } catch (Exception e) { // a bit lazy here but its OK!
			System.out.println("Wrong data format in the file!");
			System.exit(0);
			
		    } ;
		}
            }
           
//            System.out.println(ratings.toString());
            
            //Print the new ratings list
            
        } 
        catch (Exception e) {
	    System.out.println("Error in reading CSV file !!!");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing Reader !!!");
                e.printStackTrace();
            }
        }
        
    }

    // Writing to a CSV File in appending mode
    String fileNam="test.csv";
    public static  void write2CSVFile(String fileNam) {		
	//Create an array of rating objects
//	Rating[] ratings = {new Rating(100, "", 4.8), new Rating(101, "",2.8)};
	FileWriter writer = null;				
	try {
	    writer = new FileWriter(fileNam, false);		
	    //Write the new ratings into the CSV file
		writer.append("movieId,title,rating");
		writer.append(NEWLINE);

	    for (Rating rating : ratings) {
		writer.append(String.valueOf(rating.getMovieID()));
		writer.append(COMMA);
		writer.append(String.valueOf(rating.getTitle()));
		writer.append(COMMA);
		writer.append(String.valueOf(rating.getValue()));
                writer.append(NEWLINE);
                System.out.println(writer.toString());
	    }	
	} catch (Exception e) {
	    System.out.println("Error in CsvFileWriter!");
	    e.printStackTrace();
	} finally {			
	    try {
		writer.flush();
		writer.close();
	    } catch (IOException e) {
		System.out.println("Error while flushing/closing fileWriter!");
		e.printStackTrace();
	    }
			
	}
    }
}

