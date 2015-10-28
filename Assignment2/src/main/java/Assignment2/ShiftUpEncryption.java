package Assignment2;

import java.util.Scanner;

public class ShiftUpEncryption extends ShiftEncryption implements EncryptionAlgorithm {


	public ShiftUpEncryption(int maxKey) {
		super(maxKey);
		// TODO Auto-generated constructor stub
	}

	public ShiftUpEncryption() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	int shift(int a, int b) {
		// TODO Auto-generated method stub
		
		return a+b;
	}

	@Override
	int arcShift(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	
}
