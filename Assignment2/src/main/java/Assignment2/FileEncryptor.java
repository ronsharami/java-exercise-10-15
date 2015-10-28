package Assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileEncryptor extends Encryptor{

	
	public FileEncryptor(EncryptionAlgorithm alg, FileService fs) {
		super(alg, fs);
		// TODO Auto-generated constructor stub
	}
	public void encryptFile(String originalFilePath,
			String outFilePath,String keyFilePath) throws IOException, InvalidEncryptionKeyException{
		String text = fileService.readFile(originalFilePath);
		int key = fileService.readKeys(keyFilePath, 1)[0];
		String encText = algorithem.encryption(text, key);
		fileService.writeToFile(encText, outFilePath);

	}
	public void decryptFile(String encryptedFilePath,
			String outFilePath,String keyFilePath) throws IOException, InvalidEncryptionKeyException{
		String encText = fileService.readFile(encryptedFilePath);
		int key = fileService.readKeys(keyFilePath,1)[0];
		String decText = algorithem.decryption(encText, key);
		fileService.writeToFile(decText, outFilePath);
	}
	


	

}
