package muntaser;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*;

public class client1 {

    public static void main(String args[]) throws Exception {

        rec2 pp=new rec2();

        pp.start();
        while (true) {


            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");

            byte[] sendData = new byte[1024];
           byte[] receiveData = new byte[1024];

            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, 9999);//dest

            clientSocket.send(sendPacket);

           clientSocket.close();
        }
    }

}
