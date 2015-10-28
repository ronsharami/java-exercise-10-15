package Assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DoubleEncryption extends Encryptor {
	public DoubleEncryption(EncryptionAlgorithm alg, FileService fs) {
		super(alg, fs);
		// TODO Auto-generated constructor stub
	}
	

	public void encryptFile(String originalFilePath,
			String outFilePath,String keyFilePath)
					throws IOException, InvalidEncryptionKeyException{
		String text = fileService.readFile(originalFilePath);
		int [] key = fileService.readKeys(keyFilePath,2);
		
		String encText = algorithem.encryption(text, key[0]);
		encText = algorithem.encryption(encText, key[1]);
		fileService.writeToFile(encText, outFilePath);

	}
	public void decryptFile(String encryptedFilePath,
		String outFilePath,String keyFilePath)
				throws IOException, InvalidEncryptionKeyException{
		String encText = fileService.readFile(encryptedFilePath);
		int [] key = fileService.readKeys(keyFilePath,2);
		String decText = algorithem.decryption(encText, key[1]);
		decText = algorithem.decryption(decText, key[0]);
		fileService.writeToFile(decText, outFilePath);
	}



}
