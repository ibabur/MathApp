package com.ib.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.ib.beans.QuestionsBean;
import com.ib.mathapp.activity.R;


public class AppProperties {

	private static AppProperties mInstance= null;

	private static ArrayList<QuestionsBean> currentQuestionList;
	private static ArrayList<Integer> randomNumbersList;
	private static int currentQuestionIndex=0;
	public static QuestionsBean getNextQuestion(){
		if(currentQuestionList == null || currentQuestionList.size()<=0 || currentQuestionIndex >= currentQuestionList.size())
			return null;
		
		return currentQuestionList.get(randomNumbersList.get(currentQuestionIndex++));
	}
	
	public static void setQuestionList(ArrayList<QuestionsBean> qList){
		currentQuestionList=qList;
		currentQuestionIndex=0;
		generateRandoms(0,currentQuestionList.size());
	}
	private static void generateRandoms(int start,int end) {

		// define ArrayList to hold Integer objects
		randomNumbersList = new ArrayList<Integer>();
		for (int i = start; i < end; i++) {
			randomNumbersList.add(i);
		}

		Collections.shuffle(randomNumbersList);
		System.out.println(randomNumbersList);
	}
	
	public static int starImagesArray[] = { R.drawable.star_bg0, R.drawable.star_bg1,
			R.drawable.star_bg2, R.drawable.star_bg3, R.drawable.star_bg4,
			R.drawable.star_bg5, R.drawable.star_bg6, R.drawable.star_bg7,
			R.drawable.star_bg8, R.drawable.star_bg9};
	
	public static int heartImagesArray[] = { R.drawable.heart_bg0, R.drawable.heart_bg1,
			R.drawable.heart_bg2, R.drawable.heart_bg3, R.drawable.heart_bg4,
			R.drawable.heart_bg5, R.drawable.heart_bg6, R.drawable.heart_bg7,
			R.drawable.heart_bg8, R.drawable.heart_bg9};
	public static int circleImagesArray[] = { R.drawable.num_bg0, R.drawable.num_bg1,
			R.drawable.num_bg2, R.drawable.num_bg3, R.drawable.num_bg4,
			R.drawable.num_bg5, R.drawable.num_bg6, R.drawable.num_bg7,
			R.drawable.num_bg8, R.drawable.num_bg9};
	
	
		protected AppProperties(){} 
	 
	    public static synchronized AppProperties getInstance(){ 
	        if(null == mInstance){ 
	                mInstance = new AppProperties(); 
	        } 
	        return mInstance; 
	    } 
	    

	    public static boolean isNull(String a) {
	        if (null == a || a.trim().equals("")) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public static String NVL(String str) {
	        if (null == str || str.trim().equals("")) {
	            return "";
	        } else {
	            return str;
	        }
	    }

	    public static int getInteger(String str,int val) {
	    	int ret=val;
	        if (null == str || str.trim().equals("")) {
	            return ret;
	        } else {
	    		try {
					ret=Integer.parseInt(str);
				} catch (Exception e) {
				}
				return ret;
	        }
	    }
	    
	    public static String getDateTimeZero(String str) {
	    	int ret=0;
	    	try {
    			ret=Integer.parseInt(str);
			} catch (Exception e) {
			}
			
	        if (ret<10) {
	            return "0"+ret;
	        } else {
	    	
				return ret+"";
	        }
	    }

	    public static Date parseEventDate(String dt,String sourceFormat){
			  Date date =null;
			  DateFormat formatter = new SimpleDateFormat(sourceFormat);
			  try {
				date = (Date)formatter.parse(dt);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return date;
		  }

	    public static String changeDateFormat(String dt,String sourceFormat,String dest){
	    	String finalDate =null;
			  DateFormat formatter = new SimpleDateFormat(sourceFormat);
			  DateFormat dateShow = new SimpleDateFormat(dest);
			  
			  try {
				  Date date = (Date)formatter.parse(dt);
				  finalDate=dateShow.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return finalDate;
		  }
	    public static String getDateShowFormat(Date date){
			  
			 DateFormat dateShow = new SimpleDateFormat("EEEEEEEEEE MMMMMMMMMM dd, yyyy");
			 String finalDate="";
			  try {
				finalDate=dateShow.format(date);
				int day = date.getDate();
				String dayString=day+suffixes[day]+",";
				finalDate=finalDate.replace(day+",", dayString);
//				System.out.println(finalDate);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return finalDate;
	  }
		  public static String changeDateShowFormat(Date date, String dateFormat){
			  
				 DateFormat dateShow = new SimpleDateFormat(dateFormat);
				 String finalDate="";
				  try {
					finalDate=dateShow.format(date);
					int day = date.getDate();
					String dayString=day+suffixes[day]+",";
					finalDate=finalDate.replace(day+",", dayString);
//					System.out.println(finalDate);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return finalDate;
		  }
		    static String[] suffixes =
				  //    0     1     2     3     4     5     6     7     8     9
				     { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
				  //    10    11    12    13    14    15    16    17    18    19
				       "th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
				  //    20    21    22    23    24    25    26    27    28    29
				       "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
				  //    30    31
				       "th", "st" };

			 
 
			 public static double getDouble(String str,double val) {
			    	double ret=val;
			        if (null == str || str.trim().equals("")) {
			            return ret;
			        } else {
			    		try {
							ret=Double.parseDouble(str);
						} catch (Exception e) {
						}
						return ret;
			        }
			    }

			
}
