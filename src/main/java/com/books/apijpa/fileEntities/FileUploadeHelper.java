package com.books.apijpa.fileEntities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUploadeHelper {
	//public final String UPLOAD_DIR="C:\\Users\\Gaurav\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\books-api-restapi-with-data-jpa\\src\\main\\resources\\static\\images";
	public final String UPLOAD_DIR=new ClassPathResource("static/image").getFile().getAbsolutePath();
	public FileUploadeHelper() throws IOException
	{
		
	}
	public boolean uploadefile(MultipartFile multipartFile) {
		boolean f=false;
		
		
		//old Api 
		//data read
		try {
			InputStream in=multipartFile.getInputStream();
			byte data[]=new byte[in.available()];
			in.read(data);
			//data write
			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
			fos.write(data);
			fos.close();
			System.out.println(fos);
			f=true; 
			
			// new way 
			//Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			System.out.println("h...");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("b....");
		return f;
	}
}
