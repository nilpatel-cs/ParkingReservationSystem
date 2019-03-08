

/**
 *
 * @author Nil
 */
public class parkingSpot {
 
    private String state;
    private String name;
     
    public parkingSpot()//parkingSpot constructor defaults state as available 
        {
        state = "Available";
        name = "";
        }
     
     
    public void reserve(String name)//method to switch state to reserved and to set name of reserver
        {
       
                state = "Reserved";
                name = this.name;       
        }
     
    public void cancel() // changes state to Available
        {
            state = "Available";
        }
     
    public String getState() //returns state
        {
            return state;
        }
     
    public String getName() //returns reserver's name
        {
            return name;
        }
}