package com.soc;
/*Fiacre Indagiye Sibomana
 * 
 * ITCS 3166
 * This is a server class that uses sockets to communicate with the client class
 * it accepts connections to two clients, assigns both a unique id and each user sends their usernames
 * which the server prints with each their respective IDS
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws Exception //incase port is not available
	{
	
	System.out.println("S: Server has Started");
	
			
	//starting a new server socket for the client to connect
	
	ServerSocket s1 = new ServerSocket (9985);
	
	System.out.println("S: Server is waiting for clients");
	// creating value s (true statement) to indicate when to stop trying to connect when the socket has closed 
	int t=1;
	//accepting the connection with the client
	while (t==1)
	{
	Socket ss = s1.accept();
	Socket ss2 = s1.accept();
	System.out.println("S: both clients are connected");
	
	//creating Data streams for both clients so the server can send the id
	
	DataInputStream data2IN = new DataInputStream(ss.getInputStream());
	DataOutputStream data1Out = new DataOutputStream(ss.getOutputStream());
	
	DataInputStream dataIN = new DataInputStream(ss2.getInputStream());
	DataOutputStream data2Out = new DataOutputStream(ss2.getOutputStream());
	// sending ID1
	int id = 85;
	data1Out.writeInt(id);
	//sending ID2	
	int id2 = 23;
	data2Out.writeInt(id2);
	//reading username1
	String username1;
	username1= dataIN.readUTF();
	//reading username2
	String username2;
	username2= data2IN.readUTF();
	
	//printing out both IDs and usernames
	System.out.println("ID1: "+id+"  username1: " + username1);
	System.out.println("ID2: "+id2+" username2: " + username2);
	
	
	System.out.println("S: IDs were sent to both clients and usernames were received, now closing the sockets");
	
	t=0;// making t false to end the loop and disconnect
	//closing and disconnecting
	ss.close();
	s1.close();
	ss2.close();
	}
	 
	
	

	}

}
