/**
 *
 * @author Nil
 */
     
    public class date {
    private final parkingSpot[][] parking = new parkingSpot[24][50]; //creates a two dimensional array [hours][spot] for the instance of the date
    private int spot;
    private int time;
    private String name;
    private String date;
    private String message = "Kappa";//this is just a placeholder message if for some reason this returns to the user it basically means there is an error in the code
    private String message2 = "";

 
public date ()// constructor for instance initializes two dimensional array
{
    for(int i = 0; i<24;i++)
    {
        for (int j=0; j<50;j++)
        {
            parking[i][j] = new parkingSpot();
        }
    }
     
}
     
     
public String reserve(String name1, int time1, int spot1, String date1) //method will reserve the spot at certain time on a given date, and sets the date for the instance.
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
 
 
public String cancel(String name1, int time1, int spot1, String Date1)//will cancel reservation if it exists at the time and spot at given date
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
 
 
public String extend(String name1,int time1, int spot1, String Date1){   //will extend previous reservation if possible by one hour

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
    return message;
     
}
 
public String getDate()//returns date important to make sure more then one date (class) doesn't exist when looping through the arraylist in the server
{
    return date;
}
 
 
public String view(String date1){ //will return all reservations on given date
// Requires If-Else Statement to Return Occupied Based on Time
    for(int i = 0; i<24;i++)
    {
        for (int j=0; j<50;j++)
        {
            int k = j + 1; // spots are 1-50 but are stored from 0-49
            if(parking[i][j].getState().equalsIgnoreCase("Reserved"))
            { 
            if(!message2.equalsIgnoreCase(""))
            {message2 = message2 + ", ";}       
            message2 = message2 + " Spot " + k + " is reserved at " + i + " " + date1;}
        }
    }
    return message2;
 
}
 
 
 
}
