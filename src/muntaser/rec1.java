package muntaser;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class rec1 extends Thread{

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
