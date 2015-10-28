package Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public abstract class Algorithm implements EncryptionAlgorithm {

	public Algorithm(int maxKey) {
		super();
		this.maxKey = maxKey;
	}

	protected int maxKey;
	
	public int getMaxKey() {
		return maxKey;
	}
	public void setMaxKey(int maxKey) {
		this.maxKey = maxKey;
	}
	public int getKeyStrength() {
		return (int) (Math.floor (Math.log10(Math.abs(maxKey))) + 1);
	}
	public int[] createKeys(int numOfKeys) {
		int [] keys = new int [numOfKeys];
		Random rand = new Random();
		for(int i=0;i<numOfKeys;i++) {
			 keys[i] = rand.nextInt(maxKey) + 1;
		}
    	  
		return keys;
	}
	protected boolean keysOutOfRange(int [] keys) {
		for (int k:keys) {
			if(k > this.maxKey) 
				return false;
		}
		return true;
		
	}

	public abstract String encryption(String text, int key) throws InvalidEncryptionKeyException ;

	public abstract String decryption(String text, int key) throws InvalidEncryptionKeyException;



}
