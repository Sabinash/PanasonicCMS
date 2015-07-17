package com.panasonic.steaknshakecms.service;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.panasonic.steaknshakecms.constants.Constants;
import com.panasonic.steaknshakecms.serviceinterface.ImageUploadServiceInterface;

@Service("ImageUploadService")
public class ImageUploadService implements ImageUploadServiceInterface {

	private static final Logger LOG = LoggerFactory
			.getLogger(ImageUploadService.class);

	@Override
	public void imageFileUpload(MultipartFile file) {
		// TODO Auto-generated method stub
		LOG.info("START ImageUploadService");
		File serverFile = null;
		if (!file.isEmpty()) {
			try {
				String filename = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				serverFile = new File(Constants.IMAGE_UPLOAD_PATH + filename);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				LOG.error(e.toString());
			}
		} else {
			LOG.error(Constants.FAILED_TOUPLOAD);
		}
		LOG.info("END ImageUploadService");
		System.out.println("Uploaded image path : ==  "
				+ serverFile.getAbsolutePath().toString());
	}

	@Override
	public void getImageFile(String name, HttpServletResponse resp)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedImage image = ImageIO.read(new File(Constants.IMAGE_UPLOAD_PATH
				+ name + ".png"));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(image, "png", os);
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		try {
			resp.setHeader("Content-Disposition", "inline;filename=test.png");
			OutputStream out = resp.getOutputStream();
			resp.setContentType("Content-type: image/png");
			IOUtils.copy(is, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			LOG.error(e.toString());
		}
	}
}
