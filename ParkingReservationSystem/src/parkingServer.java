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
         
        ArrayList<date> dates = new ArrayList<date>();
     
    try{ 
        ServerSocket sock = new ServerSocket(6013);
    //opens socket for communication
        while(true){//sets up infinite loop
            Socket client = sock.accept();
             
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            String name = in.next();
            String action = in.next();
            String date1 = in.next();
            int time = in.nextInt();
            int spot = in.nextInt();
            spot = spot--;
            int j = 0;
            int i = 0;
             
            DateFormat dateYear = new SimpleDateFormat("yyyy");
            DateFormat dateMonth = new SimpleDateFormat("MM");
            DateFormat dateDay = new SimpleDateFormat("dd");
            Date now = new Date();
            String year = dateYear.format(now);
            String month = dateMonth.format(now);
            String day = dateDay.format(now);
            int yr = Integer.parseInt(year);
            int mth = Integer.parseInt(month);
            int dy = Integer.parseInt(day);
            String month2 = date1.substring(0,2);
            String day2 = date1.substring(3,5);
            String year2 = date1.substring(6,10);
            int yr2 = Integer.parseInt(year2);
            int mth2 = Integer.parseInt(month2);
            int dy2 = Integer.parseInt(day2);
             
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
                    if(dy2 >= dy)
                    {
                        i = 1;
                    }
                     
                }
            }
             
            if(i == 1)
            {
                        if (action.equalsIgnoreCase("Reserve"))
                        {
                            for(date date : dates)
                            {
                                if(date.getDate().equalsIgnoreCase(date1))
                                {
                                    out.print(date.reserve(name, time, spot, date1));
                                    j = 1;
                                    break;
                                 
                                }
                             
                            }
                             
                            if (j == 0)
                            {
                                date date = new date();
                                out.print(date.reserve(name, time, spot, date1));
                                dates.add(date);
                             
                            }
                         
                        }
                        else if (action.equalsIgnoreCase("Cancel"))
                        {
                            for(date date : dates)
                            {
                                if(date.getDate().equalsIgnoreCase(date1))
                                {
                                    out.print(date.cancel(name, time, spot, date1));
                                    j=1;
                                    break;
                                     
                                 
                                }}
                                if (j==0)
                                    out.print("No reservation to cancel");
                             
                             
                         
                        }
                             
                        else if (action.equalsIgnoreCase("Extend"))
                        { 
                            for(date date : dates)
                            {
                                if(date.getDate().equalsIgnoreCase(date1))
                                {
                                    out.print(date.extend(name, time, spot, date1));
                                    j=1;
                                    break;
                                 
                                }
                             
                            }
                            if (j==0)
                                out.print("No reservation to extend!");
                             
                        }
                         
                        else if (action.equalsIgnoreCase("View"))
                        {String display="";
                            for(date date : dates)
                        { if (date1.equalsIgnoreCase(date.getDate()))
                        		{out.print(date.view(date1));
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