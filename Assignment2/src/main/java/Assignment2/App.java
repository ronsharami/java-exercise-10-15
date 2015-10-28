package Assignment2;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
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
	public static void main( String[] args ) throws Exception
    {
    	String mode;
    	String sourceFilePath;
    	String outPath;
    	String keysPath;
    	int[] keys;
    	FileService fs = new FileService();
    	ShiftUpEncryption alg = new ShiftUpEncryption();
		DoubleEncryption encryption = new DoubleEncryption(alg, fs);
    	    	Scanner console = new Scanner(System.in);
    	System.out.println("Please select between encryption and decryption:");
    	mode = console.nextLine();
    	System.out.println("Please enter filepath:");
    	sourceFilePath = console.nextLine();

       if (mode.equals(ENC))  {
       	//Encryption mode
    	   keys = alg.createKeys(2);
    	   keysPath = FileService.pathToDir(sourceFilePath)+"\\key.txt";
    	   fs.wirteKeys(keysPath,keys);
    	   outPath = fs.encryptionPath(sourceFilePath);
    	   try {
			encryption.encryptFile(sourceFilePath, outPath, keysPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//message
			if(e instanceof InvalidEncryptionKeyException) {
				System.err.println("InvalidEncryptionKeyException");
			}
			else
				throw e;
			
			e.printStackTrace();
		}
    }
       else if (mode.equals(DEC))  {
       	//Decryption mode
    	 System.out.println("Please enter key_path:");
       	keysPath = console.nextLine();
       	outPath = fs.decryptionPath(sourceFilePath);
       	try {
			encryption.decryptFile(sourceFilePath, outPath, keysPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//message
			if(e instanceof InvalidEncryptionKeyException) {
				System.err.println("Invalid Key");
			}
			else
				throw e;
			
			e.printStackTrace();
		}
       }
       console.close();
}

}
