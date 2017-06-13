package jp.co.rakus.stockmanagement.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class Image implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private MultipartFile file;
	
//	@NotNull
//	@Size(min = 0, max = 100)
	private String description;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
}
