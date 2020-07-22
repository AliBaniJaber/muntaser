package muntaser;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class rec2 extends Thread {
    @Override
    public void run() {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket =
                        new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);
                System.out.println(new String(receivePacket.getData()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
