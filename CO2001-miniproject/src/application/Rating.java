package application;

public class Rating {
	
	
	long movieID;
	String title;
	double value;
	
	public  Rating (long mid, String title, double val) {
		this.title = title;
		this.movieID = mid;
		this.value = val;
	}
	

	public  long getMovieID() {
		return movieID;
	}
	
	public  String getTitle() {
		return title;
	}
	
	public  double getValue() {
		return value;
	}
	
	
	public void setMovieID(long movieID) {
		this.movieID = movieID;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setValue(double value) {
		this.value = value;
	}
	
	

	@Override
	public String toString() {
		return "Title=" + title + ", movieID=" + movieID
				+ ", Rating="+ value  ;
	}
}
