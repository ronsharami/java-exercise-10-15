package helloWorldApp;

public abstract class EncryptionAlgorithm {
	
	protected abstract String encryption(String text,int key);
	protected abstract String decryption(String text,int key);
}
