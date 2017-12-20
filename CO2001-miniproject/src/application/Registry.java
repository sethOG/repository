package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Registry {


    protected static HashMap<Long,User> userTable;
    private static final String DB = "userRegister.dat"; // file containing the users

//----------------------------------
//    Constructors
//----------------------------------
    // default constructor
    public Registry () {
	userTable = new HashMap<Long, User>();
    }
    static Registry a = new Registry();
    // build up the database from the file 
    // note the file name is hard-coded as DB
    public Registry(String filename) throws FileNotFoundException,
			     IOException {
        openFile(DB);
    }


    public void addUser(User user)
                        throws IllegalArgumentException{

        if (userTable.containsKey(user.getUserID())) {
            
            throw new IllegalArgumentException(
                "User with the same ID already exists");
                
        } else {
        	user.setUserID(userTable.size()+1);
            userTable.put(user.getUserID(), user);
//            System.out.println(Arrays.asList(userTable));
        }
    }

    public void delete(long id) {
        userTable.remove(id);
    }

    public User getUser(long id) {
        return userTable.get(id);
    }

    // start by loading the DB into the user table
    public void start() {
	try {
	    openFile(DB);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    // end by dumping the current user table into DB
    public void write2DB() {
	try {
	    saveFile(DB);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    public String getUserList( ) {
        StringBuffer result = new StringBuffer("");
        String tab = "\t";
        String newLine = "\n";       
        for (User u : userTable.values()){
            result.append(u.getUserID()     + tab +
                          u.getFirstName()     + tab +
                          u.getLastName()     + tab +
                          u.getUsername()     + tab +
                          u.getPassword() + tab +
                          u.getAge() + tab +
                          u.getGender() + tab +
                          newLine);
        }
        System.out.println(result.toString());
        return result.toString();
        
    }


    public void openFile(String filename)
                    throws FileNotFoundException,
                           IOException {      
        FileInputStream inFileStream =
                    new FileInputStream( new File(filename));
                    
        ObjectInputStream inObjectStream =
                    new ObjectInputStream(inFileStream);

        try {
            userTable = (HashMap<Long,User>) inObjectStream.readObject();
//            System.out.println(userTable);
        } catch (ClassNotFoundException e) {
            throw new IOException("Unrecognized data in the designated file");
        }
        inObjectStream.close();

    }

    public void saveFile(String filename)
                    throws IOException {
        
        FileOutputStream outFileStream =
                 new FileOutputStream(new File(filename));
                 
        ObjectOutputStream outObjectStream =
                 new ObjectOutputStream(outFileStream);

        outObjectStream.writeObject(userTable);
//        System.out.println(userTable);
        outObjectStream.close();
    }

    public User createUserFromInput( ) {
	User u = new User();
        Scanner sc = new Scanner(System.in);
//	System.out.print("Enter ID:");
//	long userID = 0;
//	try {
//	    userID = sc.nextLong();
//	} catch (InputMismatchException e) {
//	    System.out.println("UserID must be integer!!!");
//	    System.exit(0);
//	}
        
        
        System.out.print("Enter First name:");
        String firstName = sc.next();
        
        System.out.print("Enter Last name:");
        String lastName = sc.next();
        
        System.out.print("Enter Username:");
        String username = sc.next();
        
        System.out.print("Enter Password:");
        String password  = sc.next();
        
        System.out.print("Enter age:");
        String age = sc.next();
        
        System.out.print("Enter gender:");
        String gender = sc.next();
	
	try {
	    u = new User(username, password, firstName, lastName, age, gender);
	 	a.addUser(u);
	 	System.out.println(userTable.toString());
	} catch (IllegalArgumentException e) {
	    System.out.println("Failed to create this user!!!");
	    System.exit(0);
	}
	return u;
    }

    // create users by the keyboard
    // This has no validation and needs be improved
    public void processInputData( ) {
	User u = createUserFromInput( );
	try {
	    addUser(u);
	} catch (Exception e) {
	    System.out.println("This user cannot be added!!!");
	}
    }

}
