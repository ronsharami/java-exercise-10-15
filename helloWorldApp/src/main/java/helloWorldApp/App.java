package helloWorldApp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	final static String ENC = "encryption";
	final static String DEC = "decryption";

    public static void main( String[] args ) throws IOException
    {
    	ShiftUp myShif = new ShiftUp();
    	FileService myFileService = new FileService();
    	
    	System.out.println("start");
    	String mode;
    	String sourceFilePath;
    	String outPath;
    	String outFilename;
    	String fileName;
    	
    	String result;
    	String keyPath;
    	
    	int key;   	
    	Random rand = new Random();
    	
    	Scanner console = new Scanner(System.in);  
        System.out.println("Please select between encryption and decryption:");
        mode = console.nextLine();
        
        if (mode.equals(ENC))  {
        	//Encryption mode
        	System.out.println("Please enter filepath:");
        	sourceFilePath = console.nextLine();
        	key = rand.nextInt(26);
        	result = myShif.encryption(myFileService.readFile(sourceFilePath), key);
       		fileName = sourceFilePath.substring(
       				sourceFilePath.lastIndexOf('\\')+1);
        	outPath = myFileService.encryptionPath(sourceFilePath, fileName);
        	myFileService.writeToFile(result, outPath);
        	keyPath = myFileService.pathToDir(sourceFilePath)+"\\key.txt";
        	myFileService.writeToFile(Integer.toString(key),keyPath);
			System.out.println("key_path is:");
			System.out.println(keyPath);
        }
        else if (mode.equals(DEC))  {
        	//Decryption mode
        	System.out.println("Please enter filepath:");
        	sourceFilePath = console.nextLine();
        	System.out.println("Please enter key_path:");
        	keyPath = console.nextLine();
        	key = myFileService.readFirstInt(keyPath);
        	result = myShif.decryption(myFileService.readFile(sourceFilePath), key);
        	fileName = sourceFilePath.substring(
    				sourceFilePath.lastIndexOf('\\')+1);
    		
    		outPath = myFileService.decryptionPath(sourceFilePath, fileName);
        	myFileService.writeToFile(result, outPath);
        	System.out.println("decrypted is:");
			System.out.println(outPath);

        }
        
        
    }
	private static int getKey(String keyPath) throws IOException {
		String line;
		FileReader sourceFile = new FileReader(keyPath);

		BufferedReader br = new BufferedReader(sourceFile);
		StringBuilder sb = new StringBuilder();
		line = br.readLine();
		String result = sb.toString();
		br.close();
		return Integer.parseInt(result);
	}
	public static String decryptionContent(String sourceFilePath, int key)
			throws FileNotFoundException, IOException {
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
			for(int i = 0; i<line.length();i++){
				sb.append(Character.toChars(line.charAt(i) - key));
			}
			sb.append(System.lineSeparator());
			line = br.readLine();
			
		}
		result = sb.toString();
		br.close();
		return result;
	}
	public static String encryptionContent(String sourceFilePath, int key)
			throws FileNotFoundException, IOException {
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
			for(int i = 0; i<line.length();i++){
				sb.append(Character.toChars(line.charAt(i) + key));
			}
			sb.append(System.lineSeparator());
			line = br.readLine();
			
		}
		result = sb.toString();
		br.close();
		return result;
	}
	public static String encryptionPath(String sourceFilePath, String fileName) {
		String outPath;
		outPath = pathToDir(sourceFilePath);
		
		outPath = outPath + "\\" + fileName.substring(0,fileName.lastIndexOf('.')) +"_encrypted";
		outPath = outPath +fileName.
				substring(fileName.lastIndexOf('.'));
		return outPath;
	}
	public static String pathToDir(String sourceFilePath) {
		return sourceFilePath.substring(
				0,sourceFilePath.lastIndexOf('\\'));
	}
    public static void writeStringToFile(String str,String outWritePath) throws IOException {
    	File toFile;
    	FileWriter outFileWriter;
    	BufferedWriter bw;
    	
    	toFile = new File(outWritePath);
	
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
}
