package com.ict.edu2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Ex02_c implements Runnable{
	Scanner sc = new Scanner(System.in);
	Socket s;
	
	OutputStream out;
	OutputStreamWriter osw;
	BufferedWriter bw;
	
	InputStream in;
	InputStreamReader isr;
	BufferedReader br;
	
	public Ex02_c() {
		new Thread(this).start();
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.print("입력: ");
				String msg = sc.nextLine();
				s = new Socket("203.236.220.86", 7788);
				
				//보내기 
				
				out = s.getOutputStream();
				osw = new OutputStreamWriter(out);
				bw = new BufferedWriter(osw);
				msg += System.getProperty("line.separator");
				
				bw.write(msg);
				bw.flush();
				
				//받기
				
				in = s.getInputStream();
				isr = new InputStreamReader(in);
				br = new BufferedReader(isr);
				
				String str = br.readLine();
				if(str.equalsIgnoreCase("exit")) break;
				System.out.println("서버에서 온 문자 : " + str);
				
				
			} 
			System.out.println("수고하셨습니다.");
		}
		catch (Exception e) {
				// TODO: handle exception
		} finally {
			try {
				s.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
			
	}
	
	public static void main(String[] args) {
		new Ex02_c();
	}
	
	
}

