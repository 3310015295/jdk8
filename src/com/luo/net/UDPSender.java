package com.luo.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender implements Runnable{
	
	private DatagramSocket send;

	public UDPSender() {
		// TODO Auto-generated constructor stub
	}
	
	public UDPSender(DatagramSocket send) {
		super();
		this.send = send;
	}

	@Override
	public void run() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			while((line=br.readLine())!=null) {
				DatagramPacket dataPacket = new DatagramPacket(line.getBytes(),0,line.length(),
						InetAddress.getByName("192.168.1.255"), 10000);
				send.send(dataPacket);
				if("88".equals(line)) {
					break;
				}
			}
			send.close();
		} catch (Exception e) {
			System.out.println("发送端发生异常");
		}finally {
			if(send!=null) {
				
			}
		}
		
	}

}
