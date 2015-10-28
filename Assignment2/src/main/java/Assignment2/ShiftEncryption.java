package Assignment2;

import java.util.Random;
import java.util.Scanner;

public abstract class ShiftEncryption extends Algorithm implements EncryptionAlgorithm {

	public ShiftEncryption(int maxKey) {
		super(maxKey);
		// TODO Auto-generated constructor stub
	}
	public ShiftEncryption() {
		super(26);
		// TODO Auto-generated constructor stub
	}
	public String encryption(String text, int key) throws InvalidEncryptionKeyException {
		//Scanner scanner = new Scanner(text);
		if(key > this.maxKey) {
			throw new InvalidEncryptionKeyException(1);
		}
		StringBuilder sb = new StringBuilder();
		//String line;
		//while (scanner.hasNextLine()) {
		//line   = scanner.nextLine();
		  for(int i = 0; i<text.length();i++){
				sb.append(Character.toChars(shift((int)text.charAt(i),key)));
		  }
		//sb.append(System.lineSeparator());
		//}
		//scanner.close();
		return sb.toString();
	
	}
	public String decryption(String text, int key) throws InvalidEncryptionKeyException {
		if(key > this.maxKey) {
			throw new InvalidEncryptionKeyException(1);
		}
		//Scanner scanner = new Scanner(text);
		StringBuilder sb = new StringBuilder();
		String line;
		//while (scanner.hasNextLine()) {
		//line   = scanner.nextLine();
		  for(int i = 0; i<text.length();i++){
				sb.append(Character.toChars(arcShift((int)text.charAt(i),key)));
		  }
		//sb.append(System.lineSeparator());
		//}
		//scanner.close();
		return sb.toString();
	}

	 abstract int shift(int a,int b);
	 abstract int arcShift(int a,int b);
}
