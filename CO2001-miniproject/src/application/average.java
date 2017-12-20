package application;

import java.util.HashMap;

public class average {
	protected static HashMap<Long,average> average2 = new HashMap<Long, average>();
	static Long p;
	static Long as;
public average(Long p, Long as) {
	average.p = p;
	average.as = as;
	}
public Long getP() {
		return p;
	}
	public void setP(Long p) {
		average.p = p;
	}
	public Long getAS() {
		return as;
	}
	public void setAS(Long as) {
		average.as = as;
	}
  	public String getAverage( ) {
        StringBuffer result = new StringBuffer("");
        String tab = "\t";
        String newLine = "\n";       
        for (average a : average2.values()){
            result.append(
            		a.getP() +tab+
            		a.getAS()+newLine
            		);
        }
        System.out.println(result.toString());
        return result.toString();
        
    } 
}
