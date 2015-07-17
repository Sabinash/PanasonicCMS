package com.panasonic.steaknshakecms.serviceinterface;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadServiceInterface {
	void imageFileUpload(MultipartFile file) ;

	void getImageFile(String name, HttpServletResponse resp) throws IOException;
}
