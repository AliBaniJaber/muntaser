package muntaser;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*;

public class client1 {

   public String ipsrc="";
   public String ipdes="";
   public int portsrc=0;
   public int portdest=0;

    public void set_infoSoket(String ipsrc , int portsrc , String ipdes , int portdest)
    {
        this.ipdes=ipdes;
        this.ipsrc=ipsrc;
        this.portsrc=portsrc;
        this.portdest=portdest;

    }


    public void start(){
        //Activ


    }


    public static void main(String args[]) throws Exception {
        user1 proc=new user1();
        proc.Start_chating();
    }

}
