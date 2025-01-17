package com.ict.edu2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_c implements Runnable{
	Socket s;
	
	OutputStream os;
	BufferedOutputStream bos;
	InputStream is;
	BufferedInputStream bis;
	Scanner sc = new Scanner(System.in);
	
	public Ex01_c() {
		new Thread(this).start();
	}
	
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.print("입력: ");
				String msg = sc.next();
				s = new Socket("203.236.220.86", 7777);
				
				//보내기
				os = s.getOutputStream();
				bos = new BufferedOutputStream(os);
				bos.write(msg.getBytes());
				bos.flush();
				
				//받기
				is = s.getInputStream();
				bis = new BufferedInputStream(is);
				
				/*
				byte b = 0;
				StringBuffer sb = new StringBuffer();
				
				while ((b = (byte)bis.read()) != -1) {
					sb.append((char)(b));
					
				}
				String str = sb.toString();
				*/
				
				byte[] b = new byte[1024];
				bis.read(b);
				
				String str = new String(b); 
				str = str.trim();
			
				if(str.equalsIgnoreCase("exit")) break;
				System.out.println("서버에서 온 문자: " + str);
				
			
				
			} 
			System.out.println("수고하셨습니다.");
		}
		catch (Exception e) {
				// TODO: handle exception
		} finally {
			try {
				s.close();
				bos.close();
				os.close();
				bis.close();
				is.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
			
	}
	
	public static void main(String[] args) {
		new Ex01_c();
	}
	
	
}

