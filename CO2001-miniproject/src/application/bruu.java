package application;

public class bruu extends CSVFileHandler{
	
	Rating rating;
	public bruu(Rating rating) {
		this.rating = rating;
	}
	
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "bruu [rating=" + rating + ", getRating()=" + getRating() + "]";
	}
	public String getUserList() {
        StringBuffer result = new StringBuffer("");
        String tab = "\t";
        String newLine = "\n";       
        for (Rating u : ratings){
            result.append(u.toString()     + tab +
                          
                          newLine);
        }
//        System.out.println(result.toString());
        return result.toString();
        
    }
	
}
