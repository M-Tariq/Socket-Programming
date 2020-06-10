package com.company;

import com.sun.org.apache.xerces.internal.impl.XMLEntityScanner;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket();
            InetAddress inetAddress=InetAddress.getLocalHost();
            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter message");
            String message=scanner.nextLine();
            byte[] buffer=message.getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(buffer, buffer.length, inetAddress, 5000);
            datagramSocket.send(datagramPacket);

            DatagramPacket repack=new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("remessage: "+new String(buffer));
        }catch (SocketException e){

        }catch (IOException e){

        }


    }
}
