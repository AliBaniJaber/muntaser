package muntaser;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import java.io.*;
import java.net.*;
public class client2 {

    public static void main(String args[]) throws Exception {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
    thread_resved ppp=new thread_resved();
    ppp.start();
        while (true) {
            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");

            byte[] sendData = new byte[1024];
   //         byte[] receiveData = new byte[1024];

            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, 8888);

            clientSocket.send(sendPacket);

//            DatagramPacket receivePacket =
//                    new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String modifiedSentence =
                    new String(receivePacket.getData());

            System.out.println("client 1 : "+ modifiedSentence);
            sentence="";
            clientSocket.close();
        }
    }

}
