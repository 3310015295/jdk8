package com.luo.net;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestUDP {
	
	public static void main(String[] args) throws SocketException {
		
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10000);
		
		UDPSender send = new UDPSender(sendSocket);
		
		UDPRece rece = new UDPRece(receSocket);
		
		new Thread(rece).start();
		
		new Thread(send).start();
	}
	@Test
	public void testIP() throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost();
		 ip = InetAddress.getByName("192.168.1.1");
		System.out.println(ip.getHostName());
	}

}
