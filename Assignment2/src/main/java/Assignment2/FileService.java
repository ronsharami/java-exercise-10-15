package Assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
	
	
	public String readFile(String sourceFilePath) throws IOException {
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
	
	public void writeToFile(String str,String sourceFilePath)
			throws IOException {
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


	public static  String pathToDir(String sourceFilePath) {
		return sourceFilePath.substring(
				0,sourceFilePath.lastIndexOf('\\'));
	}
	
	public   String encryptionPath(String sourceFilePath) {
		String outPath;
		String fileName = sourceFilePath.substring(
  				sourceFilePath.lastIndexOf('\\')+1);
		outPath = pathToDir(sourceFilePath);
		
		outPath = outPath + "\\" + fileName.substring
				(0,fileName.lastIndexOf('.')) +"_encrypted";
		outPath = outPath +fileName.
				substring(fileName.lastIndexOf('.'));
		return outPath;
	}
	public  String decryptionPath(String sourceFilePath) {
		String outPath;
		String fileName = sourceFilePath.substring(
  				sourceFilePath.lastIndexOf('\\')+1);
		outPath = pathToDir(sourceFilePath);
		
		outPath = outPath + "\\" + fileName.substring
				(0,fileName.lastIndexOf('.')) +"_decrypted";
		outPath = outPath +fileName.
				substring(fileName.lastIndexOf('.'));
		return outPath;
	}
	public  void wirteKeys(String keysPath, int[] keys) throws IOException {
		File toFile;
    	FileWriter outFileWriter;
    	BufferedWriter bw;
    	
    	toFile = new File(keysPath);
    	
    	
		if(!toFile.exists()) {
				toFile.createNewFile();
	}
			outFileWriter = new FileWriter(toFile);
			bw = new BufferedWriter(outFileWriter);
			//System.out.println(keys[0]);
			for(int i = 0;i<keys.length;i++) {
				bw.write(Integer.toString(keys[i]));
				if (i < keys.length - 1) {
					bw.newLine();
				}
			}
			
			bw.close();
			outFileWriter.close();


		
	}
	
	public int [] readKeys(String keyPath,int numOfKeys) throws InvalidEncryptionKeyException, IOException {
		String line;
		FileReader sourceFile = new FileReader(keyPath);
		
		BufferedReader br = new BufferedReader(sourceFile);
		line = br.readLine();
		int [] keys = new int [numOfKeys];
		int i = 0;
		while(line != null && i < numOfKeys){
			
			if(!isNumeric(line.toString())) {
				throw new InvalidEncryptionKeyException(1);
			}
			keys[i] = Integer.parseInt(line.toString());

			i++;
			line = br.readLine();
		}
		if(i != numOfKeys || line != null) {
			throw new InvalidEncryptionKeyException(0);
		}

		br.close();
		return keys;
	}
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) {
	        	return false;
	        }
	    }
	    return true;
	}
}
