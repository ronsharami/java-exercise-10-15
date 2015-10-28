package Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Encryptor {
	protected EncryptionAlgorithm algorithem;
	public EncryptionAlgorithm getAlgorithem() {
		return algorithem;
	}
	public void setAlgorithem(EncryptionAlgorithm algorithem) {
		this.algorithem = algorithem;
	}
	public FileService getFileService() {
		return fileService;
	}
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	protected FileService fileService;
	public Encryptor(EncryptionAlgorithm alg,FileService fs) {
		this.algorithem = alg;
		this.fileService = fs;
	}

	
}
