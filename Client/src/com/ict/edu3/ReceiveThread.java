package com.ict.edu3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread implements Runnable {
	Socket s;
	
	InputStream in;
	InputStreamReader isr;
	BufferedReader br;
	
	public ReceiveThread() {}
	
	public ReceiveThread(Socket s) {
		this.s = s;
		
		// 입력준비
		try {
			in = s.getInputStream();
			isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void run() {
		try {
			while (true) {
				String str = br.readLine();
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
