/*
 * 
 * Jonathan Hendrix
 * CSCI 150
 * 10/17/17
 * Simulates an email
 */
 
import java.util.ArrayList;

public class Mailbox 
{
private String owner;
private ArrayList <Message> list;
/**
 * Mailbox - instantiates name and list
 * @param name - owner of the mailbox
 */
public Mailbox(String name)
{
	owner = name;
   list = new ArrayList<Message>();
}
/**
 * getOwner - gets the owner of the email
 * @return - owner of the email
 */
public String getOwner()
{
	return owner;
}
/**
 * addMessage- adds the message to the array list
 * @param m - the message being fed in
 */
public void addMessage(Message m)
{
	list.add(m);
}
/**
 * 
 * getMessage - returns the index location of the message 
 * @param i = the index location
 * @return the index location of the message
 */
public Message getMessage(int i)
{
	return list.get(i);
}
/**
 * removeMessage - removes a message from the array list
 * @param i - the desired index location to be removed
 */
public void removeMessage (int i)
{
	list.remove(i);
}
/**
 * getSize - gets the size of the array
 * @return the size of the array
 */
public int getSize()
{
	return list.size();
	}
}
	

