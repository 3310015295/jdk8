package com.luo.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPRece implements Runnable {

	private DatagramSocket rece ;
	
	public UDPRece() {
		// TODO Auto-generated constructor stub
	}
	
	public UDPRece(DatagramSocket rece) {
		super();
		this.rece = rece;
	}

	@Override
	public void run() {
		
		try {
			while(true) {
				byte[] buff = new byte[1024];
				DatagramPacket dataPacket = new DatagramPacket(buff, buff.length);
				
				rece.receive(dataPacket);
				
				byte[] data = dataPacket.getData();
				InetAddress address = dataPacket.getAddress();
				System.out.println(address.getHostAddress()+": "+new String(data));
				
			}
		} catch (Exception e) {
			System.out.println("接收端出问题");
		}finally {
			if(rece!=null) {
				rece.close();
			}
		}
		
	}
	
	

}
