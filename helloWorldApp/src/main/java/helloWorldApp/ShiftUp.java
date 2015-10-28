package helloWorldApp;

import java.util.Scanner;

public class ShiftUp extends EncryptionAlgorithm {

	@Override
	protected String encryption(String text, int key)  {
		//System.out.println(key);
		//System.out.println(text);
		Scanner scanner = new Scanner(text);
		StringBuilder sb = new StringBuilder();
		String line;
		while (scanner.hasNextLine()) {
		line   = scanner.nextLine();
		  for(int i = 0; i<text.length();i++){
				sb.append(Character.toChars(text.charAt(i) + key));
		  }
		//sb.append(System.lineSeparator());
		}
		scanner.close();
		return sb.toString();
	}

	@Override
	protected String decryption(String text, int key)  {
		//System.out.println(key);
		//System.out.println(text);
		Scanner scanner = new Scanner(text);
		StringBuilder sb = new StringBuilder();
		String line;
		while (scanner.hasNextLine()) {
		line   = scanner.nextLine();
		  for(int i = 0; i<text.length();i++){
				sb.append(Character.toChars((int)text.charAt(i) - key));
		  }
		//sb.append(System.lineSeparator());
		}
		scanner.close();
		return sb.toString();
	}



}
