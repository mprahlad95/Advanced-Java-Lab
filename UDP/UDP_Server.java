import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPServer {

    public static void main(String args[]) throws Exception {

		Scanner sc= new Scanner(System.in);
		int port= sc.nextInt();
        DatagramSocket serverSocket = new DatagramSocket(port);
        
BufferedReader inFromUser
                = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            DatagramPacket receivePacket
                    = new DatagramPacket(receiveData, receiveData.length);

            serverSocket.receive(receivePacket);
            String msg = new String(receivePacket.getData());
            
            System.out.println("Client says: "+msg);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            
            msg=inFromUser.readLine();
            String capitalizedSentence = msg;
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket
                    = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);

        }
    }
}
