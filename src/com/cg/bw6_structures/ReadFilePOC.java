package com.cg.bw6_structures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFilePOC {

	/*
	 * public static void main(String a[]) throws IOException {
	 * System.out.println("*****");
	 * ReadFilePOC.FilesToBeMoved("D:\\PocForBridgesAndOauth\\MigrationPOC",
	 * "D:\\com\\cg\\test"); System.out.println("......"); }
	 */

//		// Declaring variables
//		String fileName;
//
//		Path pathToBeMovedTo;
//		List<Path> files = Files.walk(Paths.get("D:\\RestSoapJms\\JMSTEST")).filter(Files::isRegularFile)
//				.filter(path -> path.toString().endsWith(".bwp")).collect(Collectors.toList());
//
//		for (Path path : files) {
//			System.out.println(path);
//			pathToBeMovedTo = Paths.get("D:\\com\\cg\\tibco\\ap19\\test\\"Processes" + "\\" + path.getFileName());
//			Files.copy(path, pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
//		}
//
//	}

	public static void FilesToBeMoved(/* String extention, */ String sourcePath, String targetPath) throws IOException {

		Path pathToBeMovedTo = Paths.get(sourcePath);
		List<Path> files = Files.walk(pathToBeMovedTo).filter(Files::isRegularFile).collect(Collectors.toList());
		/* .filter(path -> path.toString().endsWith(".bwp")) */
//
//		for(Path p : files) {
//			System.out.println(p);
//		}
//		

		for (int i = 0; i < files.size() ; i++) {
			if (files.get(i).toString().endsWith(".process") || files.get(i).toString().endsWith(".bwp")
					|| files.get(i).toString().endsWith(".customProcess")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\Processes\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			} else if (files.get(i).toString().endsWith(".xsd") || files.get(i).toString().endsWith(".xml")
					|| files.get(i).toString().endsWith(".dtd")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\Schemas\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			} else if (files.get(i).toString().endsWith(".wsdl") || files.get(i).toString().endsWith(".serviceagent")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\Service Descriptors\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			} else if (files.get(i).toString().endsWith(".substvar") || files.get(i).toString().endsWith(".bwm")
					|| files.get(i).toString().endsWith(".jsv") || files.get(i).toString().endsWith(".msv")
					|| files.get(i).toString().endsWith(".MF")) {
				pathToBeMovedTo = Paths.get(targetPath + "\\META-INF\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			} else if (files.get(i).getFileName().toString().equalsIgnoreCase(".config")
					|| files.get(i).getFileName().toString().equalsIgnoreCase(".project")
					|| files.get(i).getFileName().toString().equalsIgnoreCase("build.properties")) {

				String tempDirectoryPath = targetPath + "\\" + files.get(i).getFileName();
				File file = new File(tempDirectoryPath);
				file.mkdirs();

				pathToBeMovedTo = Paths.get(targetPath + "\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			} else {
				pathToBeMovedTo = Paths.get(targetPath + "\\EXTRA\\" + files.get(i).getFileName());
				Files.copy(files.get(i), pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
			}
		}

//		for (Path path : files) {
//			System.out.println(path);
//			pathToBeMovedTo = Paths.get(targetPath + "\\" + path.getFileName());
//			Files.copy(path, pathToBeMovedTo, StandardCopyOption.REPLACE_EXISTING);
//		}
	}

}
