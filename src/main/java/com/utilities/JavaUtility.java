package com.utilities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * This class contains JAVA Specific Generic methods
 * 
 * @author Harapriya
 * 
 */
public class JavaUtility {
	/**
	 * 
	 * generate integer random
	 * @return int
	 */
	public int getRandomNum() {
		Random ranNum= new Random();
		int random= ranNum.nextInt(1000);
		return random;
	}
/**
 * This will provide Generic method for system Date in String in Indian Standard Time(DD/MM/YYYY) form.
 * 
 * @return String IST_SystemDate
 */
	public String getSystemDate_IST() {
		
		Date dateObj= new Date();
		String dataAndTime = dateObj.toString();
		
		@SuppressWarnings("deprecation")
		int month= dateObj.getMonth();
		String year= dataAndTime.split(" ")[5];
		String date= dataAndTime.split(" ")[2];
		
		String ddMmYyyy= date+ "-"+month+"-"+year;
		return ddMmYyyy;
	}
	
	/**
	 * This will provide Generic method for system Date in String CRM (YYYY-MM-DD) form.
	 * 
	 * @return String System date
	 */
	public String getSystemDate() {
		
		Date dateObj= new Date();
		String dataAndTime = dateObj.toString();
	
		@SuppressWarnings("deprecation")
		int month= dateObj.getMonth();
		String year= dataAndTime.split(" ")[5];
		String date= dataAndTime.split(" ")[2];
		
		String yyyyMmDd= year+"-"+month+"-"+date;
		return yyyyMmDd;	
	}
	
	public String getTimeWithDate() {
		LocalDateTime lDateAndTime= LocalDateTime.now();
	
		int hour =lDateAndTime.getHour();
		int minute= lDateAndTime.getMinute();
		int seconds= lDateAndTime.getSecond();
		
		String month= lDateAndTime.getMonth().toString();
		int year= lDateAndTime.getYear();
		String dateAndTime= month.substring(0, 1)+ month.substring(1).toLowerCase();
		String todaydate=dateAndTime+" "+year+" "+hour+"_"+minute+"_"+seconds;
		return todaydate;
		
	}
}












