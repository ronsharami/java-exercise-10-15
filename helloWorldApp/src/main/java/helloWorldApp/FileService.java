package helloWorldApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
	
	protected String readFile(String sourceFilePath) throws IOException {
		String line;
		String result;
		FileReader sourceFile;
		BufferedReader br;
		StringBuilder sb;
		sourceFile = new FileReader(sourceFilePath);
		
		br = new BufferedReader(sourceFile);
		sb = new StringBuilder();
		line = br.readLine();
		
		while(line != null){
			sb.append(line);
			line = br.readLine();
			/*if (line != null)
				sb.append(System.lineSeparator());*/
			
		}
		result = sb.toString();
		br.close();
		return result;
	}
	protected void writeToFile(String str,String sourceFilePath) throws IOException {
		File toFile;
    	FileWriter outFileWriter;
    	BufferedWriter bw;
    	
    	toFile = new File(sourceFilePath);
	
		if(!toFile.exists())
		{
			toFile.createNewFile();
		}
		outFileWriter = new FileWriter(toFile);
		bw = new BufferedWriter(outFileWriter);
		bw.write(str);
		bw.close();
		outFileWriter.close();
	}

	public  String pathToDir(String sourceFilePath) {
		return sourceFilePath.substring(
				0,sourceFilePath.lastIndexOf('\\'));
	}
	public  String encryptionPath(String sourceFilePath, String fileName) {
		String outPath;
		outPath = pathToDir(sourceFilePath);
		
		outPath = outPath + "\\" + fileName.substring(0,fileName.lastIndexOf('.')) +"_encrypted";
		outPath = outPath +fileName.
				substring(fileName.lastIndexOf('.'));
		return outPath;
	}
	protected  int readFirstInt(String keyPath) throws IOException {
		String line;
		FileReader sourceFile = new FileReader(keyPath);

		BufferedReader br = new BufferedReader(sourceFile);
		StringBuilder sb = new StringBuilder();
		line = br.readLine();
		//System.out.println(line);
		String result = line.toString();
		br.close();
		//System.out.println(result);
		return Integer.parseInt(result);
	}
	public String decryptionPath(String sourceFilePath, String fileName) {
		String outPath;
		outPath = pathToDir(sourceFilePath);
		
		outPath = outPath + "\\" + fileName.substring(0,fileName.lastIndexOf('.')) +"_decrypted";
		outPath = outPath +fileName.
				substring(fileName.lastIndexOf('.'));
		return outPath;
	}
}
