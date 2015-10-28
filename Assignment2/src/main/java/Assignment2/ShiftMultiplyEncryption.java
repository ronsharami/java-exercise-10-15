package Assignment2;

public class ShiftMultiplyEncryption extends ShiftEncryption implements EncryptionAlgorithm {

	
	public ShiftMultiplyEncryption(int maxKey) {
		super(maxKey);
		// TODO Auto-generated constructor stub
	}
	public ShiftMultiplyEncryption() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	int shift(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	int arcShift(int a, int b) {
		// TODO Auto-generated method stub
		return a/b;
	}

}
