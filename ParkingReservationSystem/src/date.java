/**
 *
 * @author Nil
 */
    import java.util.*;
    import java.text.*;
     
    public class date {
    private parkingSpot[][] parking = new parkingSpot[24][50];
    private int spot;
    private int time;
    private String name;
    private String date;
    private String message = "Kappa";
    private String message2 = "";
     
    DateFormat dateHour = new SimpleDateFormat("HH");
    Date now = new Date();
    String hour = dateHour.format(now);
    int hr = Integer.parseInt(hour);
     
    int i2 = 0;
     
    DateFormat dateYear = new SimpleDateFormat("yyyy");
    DateFormat dateMonth = new SimpleDateFormat("MM");
    DateFormat dateDay = new SimpleDateFormat("dd");
    Date now2 = new Date();

 
public date ()
{
    for(int i = 0; i<24;i++)
    {
        for (int j=0; j<50;j++)
        {
            parking[i][j] = new parkingSpot();
        }
    }
     
}
     
     
public String reserve(String name1, int time1, int spot1, String date1)
{
            Date now2 = new Date();
	    String year = dateYear.format(now2);
	    String month = dateMonth.format(now2);
	    String day = dateDay.format(now2);
	    int yr = Integer.parseInt(year);
	    int mth = Integer.parseInt(month);
	    int dy = Integer.parseInt(day);
	    String month2 = date1.substring(0,2);
	    String day2 = date1.substring(3,5);
	    String year2 = date1.substring(6,10);
	    int yr2 = Integer.parseInt(year2);
	    int mth2 = Integer.parseInt(month2);
	    int dy2 = Integer.parseInt(day2);
	     
	    {
	    if(yr2 > yr)
	    {
	        i2 = 1;
	    }
	     
	    else if(yr2 == yr)
	    {
	        if(mth2 > mth)
	        {
	            i2 = 1;
	        }
	         
	        else if(mth2 == mth)
	        {
	            if(dy2 >= dy)
	            {
	                i2 = 1;
	            }
	             
	        }
	    }
	    }
    if(i2 == 0)
    {
        if(time1 < hr)
        {
            i2 = 1;
        }
    }
     
    if(i2 == 1)
    {
   
    spot1--;
    if (parking[time1][spot1].getState().equalsIgnoreCase("Available"))
        {
        parking[time1][spot1].reserve(name1);
        name = name1;
        date = date1;
        message = "Spot Reserved";
        
        }
    else
        message = "Spot unavailable";
    return message;
    }
     
    else
    {
        message = "You cannot make a reservation on a date that has already passed.";
        return message;
     
    }
     
     
}
 
 
public String cancel(String name1, int time1, int spot1, String Date1)
{
            Date now2 = new Date();
	    String year = dateYear.format(now2);
	    String month = dateMonth.format(now2);
	    String day = dateDay.format(now2);
	    int yr = Integer.parseInt(year);
	    int mth = Integer.parseInt(month);
	    int dy = Integer.parseInt(day);
	    String month2 = Date1.substring(0,2);
	    String day2 = Date1.substring(3,5);
	    String year2 = Date1.substring(6,10);
	    int yr2 = Integer.parseInt(year2);
	    int mth2 = Integer.parseInt(month2);
	    int dy2 = Integer.parseInt(day2);
	     
	    {
	    if(yr2 > yr)
	    {
	        i2 = 1;
	    }
	     
	    else if(yr2 == yr)
	    {
	        if(mth2 > mth)
	        {
	            i2 = 1;
	        }
	         
	        else if(mth2 == mth)
	        {
	            if(dy2 >= dy)
	            {
	                i2 = 1;
	            }
	             
	        }
	    }
	    }
if(i2 == 0)
{
    if(time1 < hr)
    {
        i2 = 1;
    }
}
 
if(i2 == 1)
{
    spot1--;
    System.out.println(parking[time1][spot1].getState().equalsIgnoreCase("Reserved"));
        if(parking[time1][spot1].getState().equalsIgnoreCase("Reserved"))
        {
            time = time1;
            spot = spot1;
            name = name1;
            parking[time][spot].cancel();
            message = "You have successfully cancelled your reservation.";
            return message;
         
         
        }
         
        else
        {
            message = "Cannot cancel an invalid reservation.";
            return message;
             
         
        }
    }
         
        else
        {
            message = "You cannot make a reservation on a date that has already passed.";
            return message;
         
        }
    }
 
 
public String extend(String name1,int time1, int spot1, String Date1){    
Date now2 = new Date();
String year = dateYear.format(now2);
String month = dateMonth.format(now2);
String day = dateDay.format(now2);
int yr = Integer.parseInt(year);
int mth = Integer.parseInt(month);
int dy = Integer.parseInt(day);
String month2 = Date1.substring(0,2);
String day2 = Date1.substring(3,5);
String year2 = Date1.substring(6,10);
int yr2 = Integer.parseInt(year2);
int mth2 = Integer.parseInt(month2);
int dy2 = Integer.parseInt(day2);
 

if(yr2 > yr)
{
    i2 = 1;
}
 
else if(yr2 == yr)
{
    if(mth2 > mth)
    {
        i2 = 1;
    }
     
    else if(mth2 == mth)
    {
        if(dy2 >= dy)
        {
            i2 = 1;
        }
         
    }
}

    if(i2 == 0)
    {
        if(time1 < hr)
        {
            i2 = 1;
        }
    }
     
    if(i2 == 1)
    {
        int timeDes = time1;
        spot = spot1-1;
         
        if (parking[timeDes][spot].getState().equalsIgnoreCase("Reserved"))
        {
        String nameTemp = parking[timeDes][spot].getName();
         
        for(int i = 0; i<50;i++)
        {
            if(parking[timeDes+1][i].getState().equalsIgnoreCase("Available"))
            {
                if(parking[timeDes+1][i].reserve(nameTemp))
                    {
                        name=name1;
                        parking[timeDes+1][spot].reserve(name);
                        message = "Your reservation was extended.";
                        i=51;
                    }
                }
            else
                {
                    message = "It is not possible to extend your reservation.";
                 
                }
            }
             
        }
         
    else
        {
            message = "Unable to extend a non-existent reservation.";
        }
     
    }
     
    else
    {
        message = "You cannot make a reservation on a date that has already passed.";
    }
    return message;
     
}
 
public String getDate()
{
    return date;
}
 
 
public String view(String date1){
// Requires If-Else Statement to Return Occupied Based on Time
    for(int i = 0; i<24;i++)
    {
        for (int j=0; j<50;j++)
        {
            int k = j + 1;
            if(parking[i][j].getState().equalsIgnoreCase("Reserved"))
            { message2 = "";
            message2 = message2 + " Spot " + k + " is reserved at " + i + " " + date1;}
        }
    }
    return message2;
 
}
 
 
 
}
