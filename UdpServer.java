package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket(5000);
            byte[] buffer=new byte[50];
            DatagramPacket datagramPacket=new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("Message: "+new String(buffer));
            int port=datagramPacket.getPort();
            InetAddress inetAddress=datagramPacket.getAddress();
            DatagramPacket repack=new DatagramPacket(buffer, buffer.length, inetAddress, port);


            datagramSocket.send(repack);
        }catch (SocketException e){

        }catch (IOException e){

        }

    }
}
