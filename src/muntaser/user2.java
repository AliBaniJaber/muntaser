package muntaser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class user2 {



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



    }


    public  void Start_chating() throws Exception {
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        rec2 pp=new rec2();

        try
        {
            System.out.println(" ipsrc");
            ipsrc = inFromUser.readLine();
            System.out.println(" ipdes");
            ipdes = inFromUser.readLine();
            System.out.println(" portsrc");
            portsrc =Integer.parseInt(inFromUser.readLine());
            System.out.println(" portdes");
            portdest = Integer.parseInt(inFromUser.readLine());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        pp.run_mythread(ipsrc,portsrc);





        while (true) {




            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(ipdes);//ipdest

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];

            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, portdest);//dest

            clientSocket.send(sendPacket);

            clientSocket.close();
        }
    }




}
