package muntaser;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*;

public class client2 {

    public static void main(String args[]) throws Exception {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
        rec1 ppp=new rec1();
        ppp.start();

        while (true) {
            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");

            byte[] sendData = new byte[1024];

            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, 8888);

            clientSocket.send(sendPacket);


            clientSocket.close();
        }
    }

}
