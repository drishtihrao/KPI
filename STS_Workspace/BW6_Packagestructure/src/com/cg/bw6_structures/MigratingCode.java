package com.cg.bw6_structures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.cg.bw6_structures.ReadFilePOC;

public class MigratingCode {
	public static void main(String[] args) throws IOException {
		// Declaring variables
		String driveName, continueLoop, folderToBeCreated, directoryPath, tempDirectoryPath, sourceDirectory ;
		boolean loopInput = true, status;

		Scanner scanner = new Scanner(System.in);

		// Making an empty directory for the input project name

		while (loopInput) {
			// Asking User which Drive they want the folder to be in
			// Asking user the name of the project to be created
			System.out.println("Enter the Drive name where you want the folder to be in and"
					+ " directory path to be created");

			driveName = scanner.nextLine();
			directoryPath = scanner.nextLine();

			tempDirectoryPath = driveName + ":\\" + directoryPath;
			
			folderToBeCreated = tempDirectoryPath.replace('.', '\\');

			Path path = Paths.get(folderToBeCreated);
			File file = new File(folderToBeCreated);

			// checking if the directory exists
			if (!Files.exists(path)) {
				status = file.mkdirs();

				if (status)
					System.out.println("Directory created");
				else
					System.out.println("Some error occured");

			} else {
				System.out.println("Directory already exists");
			}

			//creating all other folders
			tempDirectoryPath = folderToBeCreated + "\\.settings";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\.WebResources";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\META-INF";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\Policies";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\Processes";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\Resources";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\Schemas";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\Service Descriptors";
			file = new File(tempDirectoryPath);
			file.mkdirs();
			
			tempDirectoryPath = folderToBeCreated + "\\EXTRA";
			file = new File(tempDirectoryPath);
			file.mkdirs();
		
			//reading the existing files
			System.out.println("Enter the source directory");
			sourceDirectory = scanner.nextLine();
			ReadFilePOC.FilesToBeMoved(sourceDirectory, folderToBeCreated);
			System.out.println("......");
		
			// Asking user if they want to continue
			System.out.println("Do you wish to continue? Y or N");
			continueLoop = scanner.nextLine();
			if (continueLoop.equalsIgnoreCase("y")) {
				loopInput = true;
			} else {
				loopInput = false;
			}
		} 
		
		
		//while loop ends
		
		
		
		
		
		
		
	}
}