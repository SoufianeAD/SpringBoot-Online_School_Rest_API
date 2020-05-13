package com.esisa.back.office.services;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.esisa.back.office.entities.Account;
import com.esisa.back.office.entities.Level;
import com.esisa.back.office.entities.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Vector;



@Service
@Component
public class FilesService {

	public static final String DOCUMENT_DIRECTORY = "./src/main/resources/documents";
	public static final String HOMEWORK_DIRECTORY = "./src/main/resources/homeworks";
	public static final String FEEDBACK_DIRECTORY = "./src/main/resources/feedbacks";
	public static final String IMPORT_STUDENTS_DIRECTORY = "./src/main/resources/importStudents";
	public static final String EXPORT_ABSENSES_DIRECTORY = "./src/main/resources/exportAbsences";
	
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
	
	public List<Student> importSudents(MultipartFile file, String directory, Level level) throws IOException {
		Path filePath = Paths.get(directory  + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		List<Student> students = new Vector<>();
		FileInputStream f = new FileInputStream(new File(directory  + File.separator + StringUtils.cleanPath(file.getOriginalFilename())));
		Workbook workbook = new XSSFWorkbook(f);
		Sheet sheet = workbook.getSheetAt(0);
		boolean isHeader = true;
		for (Row row : sheet) {
			if(isHeader) {
				isHeader = false;
			} else {
				Student student = new Student();
				student.setLevel(level);
				student.setCne(row.getCell(0).getRichStringCellValue().toString());
				student.setLastName(row.getCell(1).getRichStringCellValue().toString());
				student.setFirstName(row.getCell(2).getRichStringCellValue().toString());
				student.setPhone(row.getCell(3).getRichStringCellValue().toString());
				student.setEmail(row.getCell(4).getRichStringCellValue().toString());
				student.setAddress(row.getCell(5).getRichStringCellValue().toString());
				//
				Account account = new Account(student.getLastName() + "/" + student.getFirstName(), student.getCne(), level.getSchool());
				student.setAccount(account);
				students.add(student);
			}
		}
				
		return students;
	}
}
