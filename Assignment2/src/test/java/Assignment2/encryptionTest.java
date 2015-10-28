package Assignment2;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import junit.framework.TestCase;

public class encryptionTest  {
	

	private DoubleEncryption doubleEncryption;
	ShiftUpEncryption alg= new ShiftUpEncryption();
	ShiftMultiplyEncryption alg2 = new ShiftMultiplyEncryption();
	FileService fs;
	ShiftMultiplyEncryption algCom1 =  mock(ShiftMultiplyEncryption.class);
	ShiftUpEncryption algCom2=  mock(ShiftUpEncryption.class);
	@Before
	public void executedBeforeEach() throws IOException, InvalidEncryptionKeyException {
		fs = mock(FileService.class);
		when(fs.readFile("testInput")).thenReturn("abcd");
		when(fs.readFile("testInput2")).thenReturn("ghij");
		when(fs.readFile("testInput3")).thenReturn(")!%*");
		when(fs.readFile("testInput4")).thenReturn("öÆÞü");
		when(fs.readKeys("testKey",2)).thenReturn( new int[] {2,4});
		when(fs.readKeys("testKey2",2)).thenReturn( new int[] {2,3});
		when(fs.readKeys("testKey3",2)).thenReturn( new int[] {28,30});
		//doCallRealMethod().when(fs).readKeys("testKey3", 2);
		//when(fs.readKeys("testKey2",2));
		doCallRealMethod().when(fs).writeToFile(anyString(), anyString());
		doCallRealMethod().when(fs).
				readFile("C:\\Users\\win7\\Downloads\\testOut.txt");
		doCallRealMethod().when(fs).
					readFile("C:\\Users\\win7\\Downloads\\testOut2.txt");
		doCallRealMethod().when(fs).readKeys
				("C:\\Users\\win7\\Downloads\\testOut.txt", 2);
		doubleEncryption = new DoubleEncryption(alg, fs);
;
        //System.out.println("@Before: executedBeforeEach");
    }
	@Test
	public void TestCase1() throws IOException, InvalidEncryptionKeyException {
		 // Encryption - ShiftUpEncryption
		doubleEncryption.encryptFile("testInput",
				"C:\\Users\\win7\\Downloads\\testOut.txt", "testKey");
		String expected = fs.readFile("C:\\Users\\win7"
				+ "\\Downloads\\testOut.txt");
		String actual = "ghij";
		
		assertEquals(expected, actual);
	}
	@Test
	public void TestCase2() throws IOException, InvalidEncryptionKeyException {
		 // Decryption - ShiftUpEncryption
		doubleEncryption.decryptFile("testInput2"
				,"C:\\Users\\win7\\Downloads\\testOut2.txt", "testKey");
		String expected = fs.readFile("C:\\Users\\"
				+ "win7\\Downloads\\testOut2.txt");
		String actual = "abcd";
		
		assertEquals(expected, actual);
	}
	@Test
	public void TestCase3() throws IOException, InvalidEncryptionKeyException {
		// Encryption - ShiftMultiplyEncryption
		doubleEncryption.setAlgorithem(alg2);
		
		doubleEncryption.encryptFile("testInput3",
				"C:\\Users\\win7\\Downloads\\testOut.txt", "testKey2");
		String expected = fs.readFile("C:\\Users\\win7"
				+ "\\Downloads\\testOut.txt");
		String actual = "öÆÞü";
		
		assertEquals(expected, actual);
	}
	@Test
	public void TestCase4() throws IOException, InvalidEncryptionKeyException {
		 // Decryption - ShiftMultiplyEncryption
		doubleEncryption.setAlgorithem(alg2);
		
		doubleEncryption.decryptFile("testInput4"
				,"C:\\Users\\win7\\Downloads\\testOut2.txt", "testKey2");
		String expected = fs.readFile("C:\\Users\\"
				+ "win7\\Downloads\\testOut2.txt");
		String actual = ")!%*";
		
		assertEquals(expected, actual);
	}
	@Test(expected = InvalidEncryptionKeyException.class)
	public void TestCase5() throws IOException, InvalidEncryptionKeyException  {
		//doubleEncryption.setAlgorithem(alg);
		doubleEncryption.encryptFile("testInput",
				"C:\\Users\\win7\\Downloads\\testOut.txt", "testKey3");
		
	}
	@Test(expected = InvalidEncryptionKeyException.class)
	public void TestCase6() throws IOException, InvalidEncryptionKeyException  {
		doubleEncryption.encryptFile("testInput",
				"C:\\Users\\win7\\Downloads\\testOut.txt", "C:\\Users\\win7\\Downloads\\testOut.txt");
		
	}
	public void TestCase7() throws IOException, InvalidEncryptionKeyException  {
		when(algCom1.getMaxKey()).thenReturn(4);
		when(algCom2.getMaxKey()).thenReturn(4);
		AlgorithmComparator com = new AlgorithmComparator();
		int expected = com.compare(algCom1,algCom2);
		int actual = 0;
		assertEquals(expected, actual);
	}
	public void TestCase8() throws IOException, InvalidEncryptionKeyException  {
		//doubleEncryption.setAlgorithem(alg);
		when(algCom1.getMaxKey()).thenReturn(3);
		when(algCom2.getMaxKey()).thenReturn(4);
		AlgorithmComparator com = new AlgorithmComparator();
		int expected = com.compare(algCom1,algCom2);
		int actual = -1;
		assertEquals(expected, actual);
	}
	public void TestCase9() throws IOException, InvalidEncryptionKeyException  {
		//doubleEncryption.setAlgorithem(alg);
		when(algCom1.getMaxKey()).thenReturn(3);
		when(algCom2.getMaxKey()).thenReturn(2);
		AlgorithmComparator com = new AlgorithmComparator();
		int expected = com.compare(algCom1,algCom2);
		int actual = 1;
		assertEquals(expected, actual);
	}
}
