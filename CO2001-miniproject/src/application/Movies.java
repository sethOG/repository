package application;



import java.util.HashMap;

import javax.swing.ImageIcon;


public class Movies {
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	private double rating;
	private int movieID;
	private String genre;
	private ImageIcon image = new ImageIcon();
	public Movies(String title, double rating, int movieID, String genre){
		this.title = title;
		this.rating = rating;
		this.movieID = movieID;
		this.genre = genre;
	}	
	protected static HashMap<String,Long> user;
//	user = new HashMap<Long,Movies>();
	
	Movies one = new Movies("Toy Story (1995)",2.75,1,"");
	Movies two = new Movies("Pocahontas (1995)",2.75,48,"");
	Movies three = new Movies("Bad Boys (1995)",2.75,145,"");
	Movies four = new Movies("Batman Forever (1995)",2.75,153,"Action|Adventure|Comedy|Crime");
	Movies five = new Movies("Paranormal Activity 2 (2010)",2.75,81417,"Horror");
	Movies six = new Movies("Megamind (2010)",2.75,81564,"Action|Animation|Children|Comedy|Sci-Fi");
	Movies seven = new Movies("Harry Potter and the Deathly Hallows: Part 1",2.75,81834,"Action|Adventure|Fantasy");
	Movies eight = new Movies("X-Men: First Class (2011)",2.75,87232,"Action|Adventure|Sci-Fi|Thriller|War");
	Movies nine = new Movies("Captain America: The First Avenger (2011)",2.75,88140,"Action|Adventure|Sci-Fi|Thriller|War");
	Movies ten = new Movies("Final Destination 5 (2011)",2.75,88932,"Horror|Thriller");
	
//	moviex.put
//	 public void addUser(User user)
//             throws IllegalArgumentException{
//
//
//	
// moviex.put(user.getUserID(), user);
//// System.out.println(Arrays.asList(userTable));
//
//}

	//movie.put(user.getUserID(), user);
//	public String getUserList( ) {
//        StringBuffer result = new StringBuffer("");
//        String tab = "\t";
//        String newLine = "\n";       
//        for (Movies u : moviex.values()){
//            result.append(u.getTitle()     + tab +
//                          u.getRating()     + tab +
//                          u.getMovieID()     + tab +
//                          u.getGenre()     + tab +
//                          
//                          newLine);
//        }
//        System.out.println(result.toString());
//        return result.toString();
//        
//    }
	
 
}
