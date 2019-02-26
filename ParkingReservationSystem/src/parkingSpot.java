

/**
 *
 * @author Nil
 */
public class parkingSpot {
 
    private String state;
    private String name;
     
    public parkingSpot()
        {
        state = "Available";
        name = "";
        }
     
     
    public boolean reserve(String name)
        {
            if (state.equalsIgnoreCase("Available"))
            {
                state = "Reserved";
                name = this.name;
                return true;
             
            }
            else
                return false;
         
        }
     
    public void cancel()
        {
            state = "Available";
 
        }
     
    public String getState()
        {
            return state;
        }
     
    public String getName()
        {
            return name;
        }
}