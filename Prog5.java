import java.util.ArrayList;
import java.util.Scanner;

/*Prog5.java
 * CSCI 150
 *Jonathan Hendrix
 *last revision:11/15/2017
 *This program demonstrates an email system
 *
 */
public class Prog5 
{

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		String username = "";
		String input = "";
		String writemsg = "", recsname = "";
		Message m = null;
		boolean loggedon = false;
		MailSystem mySystem = new MailSystem();//Instantiate
		
		while (!input.equals("E"))//if the input equals 'e' then the program ends 
	{
			System.out.println("L)og In  W(rite message  I(nbox  S(ent Mail  O(ff-Log Out E(xit");//menu option
			input = in.next().toUpperCase();//user input
			if (input.equals("L"))//logging in
			{
				if(loggedon == false)
				{
				System.out.println("Username: ");//promt for user name
				loggedon = true;
			    username = in.next();
				}
				else
				{
					System.out.println("Someone is currently logged in");//does this if another user tries to log in while somebody else is logged in
				}
		     }
			
		if (loggedon == true || input.equals("E"))//makes sure they are logged in first before they can do the other options and allows them to leave if they are logged in
		{

			if(input.equals("W"))//writing the message
			{
				System.out.print("Recipients name:");//user prompt
				recsname = in.next();
				m = new Message(username, recsname);
				System.out.println("Enter text terminated with an empty line:");
				in.nextLine();//clears the buffer
				writemsg = in.nextLine();
				
				while(!(writemsg.equals("")))//once the user hits enter on the keyboard twice, it stops writing
				{
					 m.append(writemsg);//writing the message
					writemsg = in.nextLine();
			    }
				
				 mySystem.deliver(m);//sends the message
			}
			else if (input.equals("I"))//checking your inbox
			{
				System.out.println(username + "'s inbox");//displays users inbox
				mySystem.printMessages(username, "inbox");
			}
			else if (input.equals("S"))//checking outbox
			{
				System.out.println(username + "'s outbox");//displays users outbox
				
				mySystem.printMessages(username, "outbox");
			}
			else if(input.equals("O"))//logging off
			{
				System.out.println("Logged of successfully");//prints this if the user logs off
				username = "";
				loggedon = false;
			}
		}//if
		else
		{
			System.out.println("Not logged in");//prints this if you try to do the other options without logging in
		}
		
		if(input.equals("E"))
		{
			System.out.println("Thanks for using my email system, bye!");//good bye message
		}
		
	}//while
		
		

	}//main

}//class
