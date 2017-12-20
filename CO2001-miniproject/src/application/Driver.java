package application;

import java.io.IOException;

public class Driver extends MainController{
    public static void main(String[] argv) throws IOException {
////    	User one = new User("setho", "suckyamum", "Seth", "Odia", "19", "male");
////    	User two = new User("sethg", "suckyamama", "Beth", "Odia", "21", "female");
////    	a.addUser(one);
////    	a.addUser(two);
//    	 	a.write2DB();
//    	a.start();
//    	a.getUserList();
////    	a.createUserFromInput();
//    	User x = new User("sethg", "suckyamama");
//    	System.out.println(asda);
//    	if (matchInRegistry(x)==true)
//    		System.out.println("Correct Login");
//    	else System.out.println("Wrong Login");
//   
    	readCSVFile("ml-latest-small/movies.csv");
    	write2CSVFile("ml-latest-small/test.csv");
    }

}
