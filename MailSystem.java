/*Jonathan Hendrix
 * CSCI 150
 * 10/30/2017
 * This class simulates an email
 * 
 */
import java.util.ArrayList;

public class MailSystem 
{
private ArrayList <Mailbox> mbList;
/**
 * MailSystem - instantiates the array list mblist
 */
public MailSystem()
{
	mbList = new ArrayList<Mailbox>();
}
/**
 * deliver - gets the index of the sender and recipient and creates mailbox for each if they dont have one
 * @param m - the message being added
 */
public void deliver(Message m)
{
	int sendindex = 0;
	int recindex = 0;
	
	sendindex = getIndex(m.getSender());
	recindex = getIndex(m.getRecipient());
	
	if (sendindex == -1)//creates mailbox and gets the sender
	{
		Mailbox mb = new Mailbox(m.getSender());
		mbList.add(mb);
		sendindex = getIndex(m.getSender());
		
	}
	if (recindex == -1)//creates mailbox and gets the recipient
	{
		Mailbox mb = new Mailbox(m.getRecipient());
		mbList.add(mb);
		recindex = getIndex(m.getRecipient());
	}
	mbList.get(sendindex).addMessage(m);//adds the message to the senders outbox
	mbList.get(recindex).addMessage(m);//adds the message to the recipients inbox
	
}
/**
 * printMessages - prints out the messages in the inbox and outbox of an owner
 * @param owner - owner of the mailbox
 * @param messageType - type of message, either outbox or inbox
 */
public void printMessages(String owner, String messageType)
{
	int ownerindex = 0;
	ownerindex = getIndex(owner);
	if (messageType.equals("outbox"))
	 {
		if(ownerindex >=0)//makes sure that there is something there
		{
			for(int x = 0; x < mbList.get(ownerindex).getSize(); x++)
            {
	             if (mbList.get(ownerindex).getMessage(x).getSender().equals(owner))
	            {
	            	 System.out.println(mbList.get(ownerindex).getMessage(x));//print out all the messages that the owner has sent
	            }
	            	 
	         }

		}
		else
		{
			System.out.println("No messages");//if there is nothing in the outbox, its prints no messages
		}

	 }//outbox

	
	if (messageType.equals("inbox"))
	 {
		if(ownerindex >=0)
		{
			for(int x = 0; x < mbList.get(ownerindex).getSize(); x++)
            {
	             if (mbList.get(ownerindex).getMessage(x).getRecipient().equals(owner))
	            {
	            	 System.out.println(mbList.get(ownerindex).getMessage(x));//print out all the messages that the owner has received
	            }
	            	 
	         }

		}
		else
		{
			System.out.println("No messages");//if there is nothing in the inbox, its prints no messages
		}

	 }//inbox
}
/**
 * getIndex - retrieves the location of the owner of a mailbox
 * @param owner - the owner of the mailbox
 * @return - returns -1 if the arraylist is empty or the owner of the mailbox was not found,
 ** if the owner is found, then it returns the position of the owner of the mailbox in the arraylist
 */
private int getIndex(String owner)
{
	
	if (mbList.size() == 0)//makes sure the array list is not empty
	{
		return -1;
	}
	for (int x = 0; x < mbList.size(); x++)
	{
		if(mbList.get(x).getOwner().equals(owner))//returns the index position of the owner
       {
    	   return x;
	
       }
	}
	return -1;
}
}

