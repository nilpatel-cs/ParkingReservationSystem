import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;
/**
 *
 * @author Nil
 */

 
public class parkingServer {
    @SuppressWarnings("resource")
    public static void main(String[] args){
         
        ArrayList<date> dates = new ArrayList<date>(); //creates an ArrayList of the class date
     
    try{ 
        ServerSocket sock = new ServerSocket(6013);
    //opens socket for communication
        while(true){//sets up infinite loop
            Socket client = sock.accept();
             
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            String name = in.next(); // first word in should be user's name
            String action = in.next(); // next word in line will be desired action
            String date1 = in.next();//next will be the date
            int time = in.nextInt(); //takes time
            int spot = in.nextInt();// takes spot from input
            spot = spot--;
            int j = 0;
            int i = 0;
             
            DateFormat dateYear = new SimpleDateFormat("yyyy");
            DateFormat dateMonth = new SimpleDateFormat("MM");
            DateFormat dateDay = new SimpleDateFormat("dd");
            Date now = new Date();
            //next couple of lines take the current date as strings and then parses them into ints.
            String year = dateYear.format(now);
            String month = dateMonth.format(now);
            String day = dateDay.format(now);
            int yr = Integer.parseInt(year);
            int mth = Integer.parseInt(month);
            int dy = Integer.parseInt(day);
            //next three lines take the user input read as date1 and breaks it up
            String month2 = date1.substring(0,2);// the first two digits are the month
            String day2 = date1.substring(3,5); // the next two after a slash are the day
            String year2 = date1.substring(6,10); //finally after the next slash is four digits for the year
            //parses the data just seperated into ints
            int yr2 = Integer.parseInt(year2);
            int mth2 = Integer.parseInt(month2);
            int dy2 = Integer.parseInt(day2);
            //the series of if statements checks to see if the date the user enters has not been passed already 
            if(yr2 > yr)
            {
                i = 1;
            }
             
            else if(yr2 == yr)
            {
                if(mth2 > mth)
                {
                    i = 1;
                }
                 
                else if(mth2 == mth)
                {
                    if(dy2 >= dy)// this will make it so all parking reservations and adjustments must be done a day in advance
                    {
                        i = 1;
                    }
                     
                }
            }
             
            if(i == 1)
            {
                        if (action.equalsIgnoreCase("Reserve"))
                        {
                            for(date date : dates)//sets date as every date stored in dates arraylist
                            {
                                if(date.getDate().equalsIgnoreCase(date1))//checks to see if the date given by the user matches a date already in the arraylist
                                {
                                    out.print(date.reserve(name, time, spot, date1)); //attempts to reserve parking spot at the time given by the user
                                    j = 1;
                                    break;
                                 
                                }
                             
                            }
                             
                            if (j == 0)
                            {
                                date date = new date(); //creates new date since entered date does not exist in system yet
                                out.print(date.reserve(name, time, spot, date1));//reserves for newly created date
                                dates.add(date);//adds date to arraylist
                             
                            }
                         
                        }
                        else if (action.equalsIgnoreCase("Cancel"))
                        {
                            for(date date : dates)//sets date as every date stored in dates arraylist
                            {
                                if(date.getDate().equalsIgnoreCase(date1))//checks to see if matches existing date
                                {
                                    out.print(date.cancel(name, time, spot, date1));//attempts to cancel reservation
                                    j=1;
                                    break;
                                     
                                 
                                }}
                                if (j==0)
                                    out.print("No reservation to cancel"); //if date doesn't exist will return this
                             
                             
                         
                        }
                             
                        else if (action.equalsIgnoreCase("Extend"))
                        { 
                            for(date date : dates)
                            {
                                if(date.getDate().equalsIgnoreCase(date1))
                                {
                                    out.print(date.extend(name, time, spot, date1)); //will atempt to add an hour to reservation
                                    j=1;
                                    break;
                                 
                                }
                             
                            }
                            if (j==0)
                                out.print("No reservation to extend!");//message to return if the date doesnt exist
                             
                        }
                         
                        else if (action.equalsIgnoreCase("View"))
                        {String display="";
                            for(date date : dates)
                        { if (date1.equalsIgnoreCase(date.getDate()))
                        		{out.print(date.view(date1)); //will return all reservations, I remember I did it this because I wanted the view command to give the user more information than just the given spot and time
                                j=1;
                                break;}
                        }
                            out.print(display);
                        if (j==0)
                            out.print("No reservations to view!");
                         
                        }
            }
             
            else
            {
                System.out.println("You cannot make a reservation on a date that has already passed.");
             
            }
             
        out.flush();
        client.close(); }}
     
    catch(IOException ioe){
        System.err.println(ioe);
    }
}
}