package com.esisa.back.office.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



@Service
@Component
public class FilesService {

	public static final String DOCUMENT_DIRECTORY = "./src/main/resources/documents";
	public static final String HOMEWORK_DIRECTORY = "./src/main/resources/homeworks";
	public static final String FEEDBACK_DIRECTORY = "./src/main/resources/feedbacks";
	
	public void uploadFile(MultipartFile file, String directory) throws IOException {
		Path filePath = Paths.get(directory  + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
	}
	
	public StreamingResponseBody downloadFile(String filePath) throws IOException {
		File f = new File(filePath);
		InputStream inputStream = new FileInputStream(f);
		 return outputStream -> {
	            int nRead;
	            byte[] data = new byte[1024];
	            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
	                outputStream.write(data, 0, nRead);
	            }
	            inputStream.close();
	        };
	}
}
