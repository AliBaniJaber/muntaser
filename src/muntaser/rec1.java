package muntaser;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Arrays;

public class rec1 extends Thread{

int portsrc=-1;
String ipsrc;


    public void run_mythread(String ipsrc,int portsrc) throws IOException
    {
        this.portsrc=portsrc;
        this.ipsrc=ipsrc;
        super.start();
    }

    byte[] byteBuffer1 = new byte[1024];
    byte[] byteBuffer =  new byte[1024];
   // DatagramPacket packet = new DatagramPacket(byteBuffer, 2, address, port);
    DatagramPacket packetReceive = new DatagramPacket(byteBuffer1, 1024);

    @Override
    public void run() {

        DatagramSocket clientSocket = null;
        try {
            clientSocket = new DatagramSocket(null);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            //serverSocket = new DatagramSocket(portsrc);
            InetAddress inetAddress= null;
            inetAddress = InetAddress.getByName(ipsrc);

            SocketAddress socketAddress=new InetSocketAddress(inetAddress, portsrc);
            clientSocket.setReuseAddress(true);

            clientSocket.bind(socketAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                byte[] receiveData = new byte[1024];
                InputStream receivePacket ;//=
                        //new DatagramPacket(receiveData, receiveData.length);

                clientSocket.receive(packetReceive);
                System.out.println("client 2:  "+ Arrays.toString(packetReceive.getData()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
