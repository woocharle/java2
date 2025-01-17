package com.ict.edu3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendThread implements Runnable{
	Socket s;
	Scanner sc = new Scanner(System.in);
	
	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;
	
	public SendThread() {}
	
	public SendThread(Socket s) {
		this.s = s;
		
		//출력 준비
		try {
			out = s.getOutputStream();
			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				System.out.print("입력: ");
				String msg = sc.nextLine();
				msg += System.getProperty("line.separator");
				
				bw.write(msg);
				bw.flush();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
