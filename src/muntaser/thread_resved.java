package muntaser;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class thread_resved  extends Thread{

String ipsrc="";
String ipdes="";
int portsrc=0;
int portdest=0;


public void set_infoSoket(String ipsrc , int portsrc , String ipdes , int portdest)
{
    this.ipdes=ipdes;
    this.ipsrc=ipsrc;
    this.portsrc=portsrc;
    this.portdest=portdest;


}

    public void run_mythread() throws IOException {



    }


    @Override
    public void run() {

        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9999);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);
        try {
            serverSocket.receive(receivePacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( new String(receivePacket.getData()));
    }
}
