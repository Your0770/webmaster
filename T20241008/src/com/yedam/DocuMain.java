package com.yedam;

import java.util.Scanner;

public class DocuMain {
	
	static Scanner sc = new Scanner(System.in);
	static DocuDAO docudao = new DocuDAO();
	static Member login = null;
	
	public static void main(String[] args) {
		
		docudao.start();
		sc.close();
	} //main
		
	
}

