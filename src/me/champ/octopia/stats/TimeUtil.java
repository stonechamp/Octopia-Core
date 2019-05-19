package me.champ.octopia.stats;

public class TimeUtil {
	
	public String timePlayer(Long joindate) {
	    Long now = System.currentTimeMillis();
	    //Long date = now - joindate; 
	 
	    long seconds = joindate / 1000 % 60;
	    long minutes = joindate / (60 * 1000) % 60;
	    long hours = joindate / (60 * 60 * 1000) % 24;
	    long days = joindate / (24 * 60 * 60 * 1000);
	    
	    if (minutes == 0 && hours == 0 && days == 0) {
	    	return seconds+" second(s)";
	    } else if (hours == 0 && days == 0) {
	    	return minutes+" minute(s) "+seconds+" second(s)";
	    } else if (days == 0) {
	    	return hours+" hour(s) "+minutes+" minute(s) "+seconds+" second(s)";
	    } else {
	    	String fulldate = days+" day(s) "+hours+" hour(s) "+minutes+" minute(s) "+seconds+" second(s)";
			return fulldate;
	    }
	    
	   }

}
