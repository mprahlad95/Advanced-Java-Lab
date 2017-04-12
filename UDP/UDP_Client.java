import java.io.*;
import java.net.*;
import java.util.*;

public class UDPClient {

    public static void main(String args[]) throws Exception {
		
		System.out.println("Enter same port number as in server");
		Scanner sc= new Scanner(System.in);
		int port= sc.nextInt();
        BufferedReader inFromUser
                = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress
                = InetAddress.getByName("localhost");
        
while(true){
    
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        
        String msg = inFromUser.readLine();

        sendData = msg.getBytes();
        DatagramPacket sendPacket
                = new DatagramPacket(sendData, sendData.length,
                        IPAddress, port);

        clientSocket.send(sendPacket);

        DatagramPacket receivePacket
                = new DatagramPacket(receiveData, receiveData.length);

        clientSocket.receive(receivePacket);
        String modifiedSentence
                = new String(receivePacket.getData());

        System.out.println("Received from Server:" + modifiedSentence);

        
    } 

    }
}
