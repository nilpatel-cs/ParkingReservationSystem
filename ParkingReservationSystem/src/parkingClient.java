/**
 *
 * @author Nil
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
     
     
    public class parkingClient {
    @SuppressWarnings("resource")
    public static void main(String[] args){
     
            try { Socket sock = new Socket("127.0.0.1",6013);
            //opens up for communication
            InputStream instream = sock.getInputStream();
            OutputStream outstream = sock.getOutputStream();
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);
            Scanner key = new Scanner(System.in);
            //sets up the outstream, instream, printwriter and scanners
            System.out.println("Enter your name, what you wish to do, date with 2 digit month and day, and a 4 digit year, time, spot");
            System.out.println("Ex: Nil Reserve 04/06/2015 13 44");
            System.out.println("Valid Commands are Reserve, Extend, Cancel, View.");
            System.out.println("Time slots are an hour long and can be reserved from 0-23 there are 50 spots.");
            //takes in user input based on directions
            String input = key.nextLine();
            out.println(input);
            out.flush(); //flushes user entry to server for processing
     
            while (in.hasNextLine()) // prints out response from server
            {
                String line = in.nextLine();
                System.out.println(line);
            }
            sock.close();
            }
            catch (IOException ioe){
            System.err.println(ioe);
            }
            }}