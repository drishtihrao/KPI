package com.cg.basicjava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFilePOC {

	public static void main(String a[]) throws IOException {
		//Declaring variables
		String fileName;
		
		System.out.println("Enter the required path");
		Scanner scanner = new Scanner(System.in);
		fileName = scanner.nextLine();
		//File listOfFiles = new File(fileName);
		String listOfFiles = Files.walk(Paths.get("D:\\RestSoapJms\\JMSTEST")).filter(Files::isRegularFile).forEach(System.out::println);
	}

}
