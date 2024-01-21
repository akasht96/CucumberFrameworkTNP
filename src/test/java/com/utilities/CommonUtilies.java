package com.utilities;

import java.util.Date;

public class CommonUtilies {

	public static String getEmailTimeStamp() {
		Date date=new Date();
		return "akasht"+date.toString().replace(" ", "_").replace(":", "_")+"@gamil.com";
		
	}
}
