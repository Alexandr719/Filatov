package com.epam.chat.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.epam.chat.elements.User;

public class FileUploader {

  private User user;
  public static final String ABSOLUTEPATH = "D:\\Filatov\\Programs\\JAVA\\Images\\chat\\files";
  public static final String RELATIVEPATH = "files";

  public boolean downloadFile(User user, MultipartFile file) {
    System.out.println("Работает новый метод");
    String fileName = null;
    boolean result = false;

    if (!file.isEmpty()) {
      try {
	byte[] bytes = file.getBytes();
	fileName = file.getOriginalFilename();
	File dir = new File(ABSOLUTEPATH + File.separator + user.getIdUser());
	user.setPathToFoto(RELATIVEPATH + "/" + user.getIdUser() + "/" + fileName);
	this.setUser(user);

	if (!dir.exists()) {
	  dir.mkdirs();
	}
	File uploadedFile = new File(dir.getAbsolutePath() + File.separator + fileName);
	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
	stream.write(bytes);
	stream.flush();
	stream.close();

	result = true;

      } catch (Exception e) {
	result = false;
      }
    } else {
      result = false;
    }
    return result;

  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
