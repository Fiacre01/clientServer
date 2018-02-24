package com.soc;
/*Fiacre Indagiye Sibomana
 * 
 * ITCS 3166
 * This is a client class that uses sockets to communicate with the server class
 * it receives an ID from the server, then sends the server a username. 
 */

import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class Clients

{
	public static void main(String[] args) throws Exception // incase port is not available
	{
		//creating a socket for the client that requires an ipaddress of the server and a port number
		String ip= "localhost";
		int port = 9985;
		
		Socket s = new Socket(ip,port);
		
		//creating Data Streams for the client to send and receive data from and to the user
		
		DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());
		DataInputStream dataIN = new DataInputStream(s.getInputStream());
		
		//reading the id info received from the server
		int id = dataIN.readInt();
		
		//Asking the user to input their username
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println( "Please enter your username: ");
		String username = sc.nextLine();
		
		//sending the username to server
		dataOut.writeUTF(username);
		
		//closing everything
		sc.close();
		s.close();
	
	}
}
