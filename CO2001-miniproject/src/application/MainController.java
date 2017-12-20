package application;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;

public class MainController extends CSVFileHandler implements Initializable{

	

    @FXML
    private TextField registerUsername;

    @FXML
    private TextField registerPassword,loginPassword,loginUsername;

    @FXML
    private RadioButton registerFemale, registerMale;


    @FXML
    private TextField registerFirstname;

    @FXML
    private TextField registerLastname;

    @FXML
    private TextField registerAge;
    
     
     
    @FXML
    private Button login, register, logout,showMovie, addMovie,
    deleteMovie,movieSearch, ratingSort,rateMovieButton,saveRating;
    
    @FXML
    private TextField registerGender;
    
    @FXML
    private TextArea movieText;
    
    @FXML
    private TextField movieTitle, movieRating, deleteMovieID,
    movieSearchText,rateMovieID,rateMovieRating;
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
//		 TODO Auto-generated method stub
	}
    
    @FXML
    public void  onClickSaveRating(ActionEvent event) throws IOException {
    	write2CSVFile("ml-latest-small/movies.csv");
    }
    @FXML
    public void  onClickRateMovie(ActionEvent event) throws IOException {
    	Long a = Long.parseLong(rateMovieID.getText());
    	Double w= Double.parseDouble(rateMovieRating.getText());
    	Double yt =(double) 15;
    	for (Rating u : ratings) {
    		Double rt= u.getValue();
//    		g=g+1;
    		if(a.equals(u.getMovieID())) {
    			rt =((rt *yt )+ w);
    			yt = yt +1;
    			rt =rt/yt;
    			u.setValue(rt);
    			
    		}
    		truu b= new truu(u);
    			re = b.getUserList();
    			movieText.setText(re);
    	}
    }
    
    
    @FXML
    public void  onClickSortRatings(ActionEvent event) throws IOException {
    	Long a=(long) 1;
    	int b =3;
    	String movie=movieText.getText();
    	System.out.println(movie);
   	List<String> movies= Arrays.asList(movie.split("\n"));
   	
   	System.out.println(movies.toString());
   	ArrayList<String> movieratings = new ArrayList<String>();
   	ArrayList<Double> movieratiings = new ArrayList<Double>();
   	
    	for (String moviie : movies) {
            String both[]=moviie.split("=");
//            str = str.replaceAll("\\D+","");
            String movierating=both[3];
            movieratings.add(movierating);
        }
    	for (String r : movieratings) {
   		r = r.replaceAll("\\s+","");
   		Double f= Double.parseDouble(r);
   		movieratiings.add(f);
   	}
    	System.out.println(movieratiings);
    	Collections.sort(movieratiings);
    	Collections.reverse(movieratiings);
    	System.out.println(movieratiings);
    	StringBuffer result = new StringBuffer("");
    	String tab = "\t";
    String newLine = "\n";
    
    for(int oi=0;oi<movieratiings.size();oi++) {
    	
    	for (String moviie : movies) {
    		
    			String vas = Double.toString(movieratiings.get(oi));
    			if(moviie.contains(vas)) {
    				if(result.toString().contains(moviie)) {
    			break;
    		}
    				
    				result.append(moviie     + tab +
                            
                            newLine);
    				
    			}
//    			break;
    		}
    	}
    	String qwerty = result.toString();
    	movieText.setText(qwerty);
    	
    	
//    	String[] rows = ratingSort.getText().split("\n");
//    	List rows = new ArrayList();
    	
    	
//    	HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>()//    	Arrays.sort(rows);
    }
    String gh;
    @FXML
    public void  onClickSearch(ActionEvent event) throws IOException {
    	StringBuffer string = new StringBuffer();
    	String tab = "\t";
        String newLine = "\n"; 
    	for(int g=0;g<ratings.size();g++) {
//    		System.out.println(ratings.size());
    		;
//    	if(ratings.get(g).getTitle().contains(movieSearchText.getText())) {
    		if(Pattern.compile(Pattern.quote(movieSearchText.getText()), Pattern.CASE_INSENSITIVE).matcher(ratings.get(g).getTitle()).find()) {
    			

    			string.append(ratings.get(g) + tab +newLine);
    			String vafje = string.toString();
//    			System.out.println("bumpa " +vafje);

    	}
    	
    	}
    	String finalString = string.toString();
    	movieText.setText(finalString);
    	
    }

    

//    public void z(){
//    	
//    }
    int g = -1;
    int o ;
    @FXML
    public void  onClickDeleteMovie(ActionEvent event) throws IOException {
    	Long a = Long.parseLong(deleteMovieID.getText());
    	for (Rating u : ratings) {
    		g=g+1;
    		if(a.equals(u.getMovieID())) {
    			o=g;
//    			System.out.println(u.toString());
//    			ratings.remove(u);
    			
//    			movieText.setText(re);
//    			u = null;
//    			System.out.println(u.toString());
    			
    		}
    		
    	}
//    	System.out.println(ratings.get(o));
    	ratings.remove(o);
    	Rating v = new Rating(0,"",0);
        truu tru= new truu(v);
    	re =tru.getUserList();
//    	System.out.println("astat "+re);
    	
//    	System.out.println(ratings);
    	movieText.setText(re);
    }
    @FXML
    public void onAddMovieClick(ActionEvent event) throws IOException {
    	if(ratings.isEmpty()) {
        	readCSVFile("ml-latest-small/movies.csv");
        }
//    	System.out.println("works");
    	if(Double.parseDouble(movieRating.getText())<=5 && Double.parseDouble(movieRating.getText())>=1) {
    		try{
    Rating v = new Rating(new Long(ratings.size()+1),movieTitle.getText(),Double.parseDouble(movieRating.getText()));
    truu tru= new truu(v);
    ratings.add(v);
//    System.out.println("fhwre"+v.toString());
    
//    System.out.println(tru.getUserList());
    re = tru.getUserList();
    System.out.println("baba  "+re);
	movieText.setText(re);
//	movieID.setText("");
	movieTitle.setText("");
	movieRating.setText("");
    	}
    		catch (NumberFormatException e) {
    		    System.out.println("movie ID is meant to be a number!!");
//    	            e.printStackTrace();
    	        }
    		catch (RuntimeException e) {
    		    System.out.println("movie ID is meant to be a number!!");
//    	            e.printStackTrace();
    	        }
    		
    	}
    }

    @FXML
    public void onShowMovieClick(ActionEvent event) throws IOException {
    	movieText.setText("");
    String[] splitRatings=	ratings.toString().split("],");
//    System.out.println("prr"+splitRatings);
    
    if(ratings.isEmpty()) {
    	readCSVFile("ml-latest-small/movies.csv");
    }
//    if(!(ratings.isEmpty())) {
//    	
//    }
//    	 re = tru.getUserList();
    	movieText.setText(re);
//    	System.out.println(re);
    	
//    	for(String s : splitRatings)
//    	    System.out.println("zzz"+s.toString());
    //	System.out.println("ml-latest-small/movies.csv");
    }
    
//
    @FXML
    public void onClick(ActionEvent event) throws IOException {
    	User x = new User(registerUsername.getText(), registerPassword.getText(), registerFirstname.getText(),
    			          registerLastname.getText(), registerAge.getText(), registerGender.getText());
    	a.start();
    	System.out.println(a.getUserList());
    	a.addUser(x);
    a.write2DB();

    }
//
    Parent root;
    @FXML
    public void onClick2(ActionEvent even) throws IOException{
    	a.start();
    	System.out.println("one");
    	User y = new User(loginUsername.getText(), loginPassword.getText());
    	System.out.println(y.toString());
    	if(matchInRegistry(y)==true) {
    		System.out.println("two");
    		try {
    			Stage stage; 
//    		     Parent root;
 
    		        stage=(Stage) login.getScene().getWindow();
    		        //load up OTHER FXML document
    		  root = FXMLLoader.load(getClass().getResource("Movies.fxml"));
    		      
    		     //create a new scene with root and set the stage
    		      Scene scene = new Scene(root);
    		      stage.setScene(scene);
    		      stage.show();
    		      
    		      
   
    			
    			
    			

    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
  		

    	}
    	
    }
    
    @FXML
    public void onLogoutClick(ActionEvent even) throws IOException{
    	
    		try {
    			Stage stage; 
    		     Parent root;
 
    		        stage=(Stage) logout.getScene().getWindow();
    		        //load up OTHER FXML document
    		  root = FXMLLoader.load(getClass().getResource("main.fxml"));
    		      
    		     //create a new scene with root and set the stage
    		      Scene scene = new Scene(root);
    		      stage.setScene(scene);
    		      stage.show();
    	}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    		}		
    			
    			

    		

    
    	
    
    
    static String asda = "username doesnt work";
    public static boolean matchInRegistry(User y) {
    	boolean bool =false;
    	for(User u : userTable.values()) {
    		
    		System.out.println(u.getUserID());
    		if(y.getUsername().equals(u.getUsername())) {
    			 asda= "username matches";
    			if(y.getPassword().equals(u.getPassword())) {
    				asda= "p matches";
    				System.out.println(asda) ;
    				 bool = true;
    				}
    			}	
    	}
		return bool;
    
    	
    	
    }
    
//    @Override
//    public void initialize(URL location, ResourceBundle resources){
//    	
//    }

}
