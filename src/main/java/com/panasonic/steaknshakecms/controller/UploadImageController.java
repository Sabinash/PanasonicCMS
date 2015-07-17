package com.panasonic.steaknshakecms.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.panasonic.steaknshakecms.constants.RouteConfig;
import com.panasonic.steaknshakecms.service.ImageUploadService;
import com.wordnik.swagger.annotations.Api;

@RestController
@RequestMapping(value = RouteConfig.ROOT_MAPPING)
@Api(value = "CMSServices Image Uploader")
public class UploadImageController {

	@Autowired
	ImageUploadService imageUploadService;

	@RequestMapping(value = RouteConfig.ROOT_MAPPING_UPLOADIMAGE, method = POST)
	public void imageUpload(@RequestParam(value = "file") MultipartFile file) {
		imageUploadService.imageFileUpload(file);
	}

	@RequestMapping(value = RouteConfig.ROOT_MAPPING_RETRIVEIMAGE, method = GET)
	public void getImage(@PathVariable(value = "name") String name,
			HttpServletResponse resp) throws IOException {
		imageUploadService.getImageFile(name, resp);
	}

}
