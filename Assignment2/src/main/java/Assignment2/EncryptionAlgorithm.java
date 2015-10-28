package Assignment2;

public interface EncryptionAlgorithm  {
	String encryption(String text,int key) throws InvalidEncryptionKeyException;
	String decryption(String text,int key) throws InvalidEncryptionKeyException;
	public  int[] createKeys(int numOfKeys);
	public int getMaxKey();

}
