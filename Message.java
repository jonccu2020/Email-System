/*Jonathan Hendrix
 * CSCI 150
 * 10/17/2017
 * Simulates an email 
 * 
 */
public class Message 
{
	private String recipientname;
	private String sendername;
	private String messagebody;

/**
 * Message initializes recipientname and sendername
 * @param recName set to recipientname
 * @param sendName set to sendername
 */
public Message(String sendName, String recName)
{
	recipientname = recName;
	  sendername = sendName;
	  messagebody = "";
}
/**
 * getSender - returns the sender name
 * @return sendername
 */
public String getSender()
{
	return sendername;
}
/**
 * getRecipient - returns the recipients name
 * @return recipientname
 */
public String getRecipient()
{
	return recipientname;
}
/**
 * append - allows the user to type as much as they want
 * @param erasetext the message being entered, and will not print *** to the console
 */
public void append (String erasetext)
{
	messagebody = messagebody + erasetext +"\n";
}
/** toString - formats the email 
 * @return return the formatted email to the user
 */
public String toString()
{
	return "From:" + getSender() + "\nTo:" + getRecipient() + "\n\n" + messagebody;
}
}//class


